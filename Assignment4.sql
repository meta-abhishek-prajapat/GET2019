use storefront;
DROP FUNCTION IF EXISTS calculate_orders;
DROP FUNCTION IF EXISTS get_month_of_maximum_orders;
DROP PROCEDURE IF EXISTS get_average_sale;
DROP PROCEDURE IF EXISTS get_order_status_of_certain_period;

#Create a function to calculate number of orders in a month.
#Month and year will be input parameter to function.
DELIMITER $$
create function calculate_orders(month INT,year INT) RETURNS INT DETERMINISTIC
BEGIN
 DECLARE result INT;
 
 SET result=0;
 SELECT COUNT(id) INTO result from orders 
 where EXTRACT(Month from date_of_order_placed)=month AND
 EXTRACT(YEAR from date_of_order_placed)=year;
 
 return result;
END $$

SELECT calculate_orders(04,2018);

#Create a function to return month in a year having maximum orders.
#Year will be input parameter.

DELIMITER $
create function get_month_of_maximum_orders(year INT) RETURNS INT DETERMINISTIC
BEGIN
 DECLARE month INT;
 
 SELECT max.max_month  into month FROM(
 SELECT COUNT(date_of_order_placed) AS COUNT, MONTH(date_of_order_placed) AS max_month 
 FROM orders where EXTRACT(YEAR from date_of_order_placed)=year
 GROUP BY MONTH(date_of_order_placed))max
 ORDER BY max.count DESC LIMIT 1;
 
 return month;
END$

SELECT get_month_of_maximum_orders(2018);

#Create a Stored procedure to retrieve average sales of each product in a month.
#Month and year will be input parameter to function.

DELIMITER $@
create procedure get_average_sale(year INT,month INT) 

BEGIN

SELECT  p.name,  sum(i.quantity) AS Quantity
from item_list i,product p, orders o
where i.order_number=o.id AND i.product_id=p.id AND month(o.date_of_order_placed)=month AND year(o.date_of_order_placed)=year
GROUP BY i.product_id;

END $@

call get_average_sale(2019,08);

#Create a stored procedure to retrieve table having order detail with status for a given period.
#Start date and end date will be input parameter.
# Put validation on input dates like start date is less than end date.
# If start date is greater than end date take first date of month as start date.
DELIMITER $&
create procedure get_order_status_of_certain_period(start_date DATE, end_date DATE)

BEGIN

SELECT p.name, i.quantity, i.status
from orders o join item_list i join product p
where o.id=i.order_number AND i.product_id=p.id AND o.date_of_order_placed between start_date AND end_date;
end $&

call get_order_status_of_certain_period("2019-01-10","2019-09-30");
