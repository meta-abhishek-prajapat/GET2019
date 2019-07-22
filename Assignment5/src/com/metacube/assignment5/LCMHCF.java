package com.metacube.assignment5;

public class LCMHCF {

	/**
	 * Find GCD of two numbers
	 * @param number1
	 * @param number2
	 * @return GDC of number1 and number2
	 */
	public static Integer CalculateGCD(Integer number1, Integer number2)  
	{  
	    if (number1 == 0) 
	        return number2;  
	    return CalculateGCD(number2 % number1, number1);  
	}  

	/**
	 * Find LCM of two numbers
	 * @param number1 
	 * @param number2
	 * @return LCM of number1 and number2
	 */
	public static Integer CalculateLCM(Integer number1, Integer number2)  
	{  
	    return (number1*number2)/CalculateGCD(number1, number2);  
	}  
	
	/**
	 * Find HCF of Two numbers
	 * @param number1
	 * @param number2
	 * @return Highest common factor of number1 and number2
	 */
	public static Integer CalculateHCF(Integer number1, Integer number2){
		if(number1==0)
			return number2;
		if(number2==0)
			return number1;
		if(number1>number2){
			return CalculateHCF(number1%number2,number2);
		}
		else{
			return CalculateHCF(number2%number1,number1);
		}
	}
		
}
