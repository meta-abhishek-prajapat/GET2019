package com.metacube.springJDBC.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.springJDBC.entities.Employee;
import com.metacube.springJDBC.utils.Queries;


@Transactional
@Repository
public class EmployeeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public Employee getEmployee(Integer id) throws Exception{
		RowMapper<Employee> rowmapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		Employee emp = jdbcTemplate.queryForObject(Queries.getEmployee,rowmapper,id); 
		return emp;
	}
	
	public List<Employee> getAllEmployeeOfSameOrganization(Integer org_id) throws Exception{
		RowMapper<Employee> rowmapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		return jdbcTemplate.query(Queries.getEmployeeofSameOrg,rowmapper);
	}
	
	public Integer insertEmployee(Employee emp) throws Exception{
		return jdbcTemplate.update(Queries.insertEmployee,emp.getName(),emp.getGender(),emp.getEmail(),emp.getPassword(),emp.getContact(),emp.getOrganization_id());
	}
	
	public Integer getLastInsertedEmpId() throws Exception{
		String query = "select max(id) from employee";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		if(count>0)
			return count;
		else
			return 0;
		
	}
	
	public Employee validUser(String email,String password) throws Exception{
		Employee emp =jdbcTemplate.queryForObject(Queries.checkUser, new Object[]{email,password},new BeanPropertyRowMapper<Employee>(Employee.class));
		System.out.println(emp);
		return emp; 
				    
	}
	
	public Integer updateEmployee(Employee emp) throws Exception{
		return jdbcTemplate.update(Queries.updateEmployee,emp.getName(),emp.getEmail(),emp.getContact(),emp.getOrganization_id(),emp.getId());
	}

}
