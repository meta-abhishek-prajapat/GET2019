package com.metacube.springJDBC.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.springJDBC.entities.Employee;
import com.metacube.springJDBC.entities.Organization;
import com.metacube.springJDBC.utils.Queries;

@Transactional
@Repository
public class OrganizationDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;	
	
	public Organization getOrganization(Integer id) throws Exception{
		String query = "select * from organization where id=?";
		RowMapper<Organization> rowmapper = new BeanPropertyRowMapper<Organization>(Organization.class);
		Organization org = jdbcTemplate.queryForObject(query,rowmapper,id);
		return org;		
	}
	
	public List<Organization> getAllOrganization() throws Exception{
		RowMapper<Organization> rowmapper = new BeanPropertyRowMapper<Organization>(Organization.class);
		return jdbcTemplate.query(Queries.getAllOrganization,rowmapper);
	}	

}
