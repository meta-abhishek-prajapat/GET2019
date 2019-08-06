package com.metacube.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeInfo {
	
	public  ArrayList<Employee> employee = new ArrayList<Employee>();
	
	/**
	 * Add employee to arraylist employee
	 * @param empId unique id 
	 * @param empName employee name
	 * @param empAddress employee address
	 * @return true if addded else give assertion error
	 */
	public  boolean addEmployee( Integer[] empId, String[] empName, String[] empAddress ) {
		if(empId == null || empName == null || empAddress == null) {
			throw new AssertionError("input cannot be null");
		}
		if (empId.length < 5 && empId.length != empName.length && empId.length != empAddress.length) {
			throw new AssertionError("inputs should be equal or cannot be less than 5");
		}
		for(int i = 0; i < empId.length; i++) {
			Employee empObj = new Employee(empId[i], empName[i], empAddress[i]);
			for(Employee emp : employee){
				if(emp.getId() == empId[i]){
					throw new AssertionError("Employee should be unique");
				}
			}
			employee.add(empObj);
		}
		return true;
	}
	
	/**
	 * Sort the employee list by the id
	 * @return true after sorting successfully
	 */
	public  boolean sortEmloyeeListById() {
		Collections.sort(employee, new Comparator<Employee>() {
			
		    public int compare(Employee e1, Employee e2) {
		    	return Integer.valueOf(e1.getId()).compareTo(e2.getId());
		    }
		});
		return true;
	}
	
	/**
	 * Sort the employee list by the employee name
	 * @return true after sorting
	 */
	public boolean sortEmployeeListByName() {
		Collections.sort(employee, new Comparator<Employee>() {
			
		    public int compare(Employee e1, Employee e2) {
		    	return e1.getName().compareTo(e2.getName());
		    }
		});
		return true;
	}
	
}
