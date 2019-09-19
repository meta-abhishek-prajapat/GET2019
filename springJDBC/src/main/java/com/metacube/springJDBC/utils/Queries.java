package com.metacube.springJDBC.utils;

public class Queries {
	
	public static final String getEmployee = "select * from employee where id=?";

	public static final String getEmployeeofSameOrg = "select * from employee where organization_id=?";
	
	public static final String insertEmployee = "insert into employee(name,gender,email,password,contact,organization_id) values(?,?,?,?,?,?)";

	public static final String checkUser = "select id,name,gender,email,password,contact,organization_id from employee where email=? and password=?";
	
	public static final String updateEmployee = "update employee set name=?,email=?,contact=?,organization_id=? where id=?";
	
	public static final String getAllOrganization = "select * from organization";
	
	public static final String insertVehicle = "insert into vehicle(vehicle_name,type,vehicle_number,emp_id,identification) values(?,?,?,?,?)";
	
	public static final String insertPass = "insert into pass(vehicle_id,emp_id,pass_type,rate) values(?,?,?,?)";
	
	public static final String getAllfriends = "select id,name from employee where organization_id = (select organization_id from employee where id=?) and id <> ?";
	
	public static final String getFriendProfile = "select emp.name,v.vehicle_number,emp.email,emp.contact from employee emp left join vehicle v on emp.id = v.emp_id where emp.id=?";
	
}
