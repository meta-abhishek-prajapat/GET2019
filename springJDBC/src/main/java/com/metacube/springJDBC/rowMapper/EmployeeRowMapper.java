package com.metacube.springJDBC.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.springJDBC.entities.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setGender(rs.getString(3));
		emp.setEmail(rs.getString(4));
		emp.setPassword(rs.getString(5));
		emp.setContact(rs.getString(6));
		emp.setOrganization_id(rs.getInt(7));
		return emp;		
	}

	
	
	

}
