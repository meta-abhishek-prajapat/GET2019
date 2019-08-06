package com.metacube.employee;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

	@Test
	public void positivetestcase(){
		Integer[] empId = {1, 4, 3, 2, 5};
		String[] empName = {"A", "B", "C", "D", "E"};
		String[] empAddress = {"Address1", "Address2", "Address3", "Address4", "Address5",};
		EmployeeInfo emplinfo = new EmployeeInfo();
		emplinfo.addEmployee(empId, empName, empAddress);
		emplinfo.sortEmloyeeListById();
		Integer TestempId[] = new Integer[]{1,2,3,4,5};
		int i = 0;
		for(Employee empl : emplinfo.employee){
			Assert.assertEquals((Integer)TestempId[i], (Integer)empl.getId());
			i++;
		}
	}
	
	@Test
	public void negativetestcase(){
			Integer[] empId = {1, 4, 3, 2, 5};
			String[] empName = {"A", "B", "C", "D", "E"};
			String[] empAddress = {"Address1", "Address2", "Address3", "Address4", "Address5",};
			EmployeeInfo emplinfo = new EmployeeInfo();
			emplinfo.addEmployee(empId, empName, empAddress);
			emplinfo.sortEmloyeeListById();
			Integer TestempId[] = new Integer[]{5,4,2,3,1};
			int i = 0;
			for(Employee empl : emplinfo.employee){
				Assert.assertNotEquals((Integer)TestempId[i], (Integer)empl.getId());
				i++;
			}
		
	}
}
