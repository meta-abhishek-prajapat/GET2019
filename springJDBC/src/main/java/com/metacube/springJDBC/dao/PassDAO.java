package com.metacube.springJDBC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.springJDBC.entities.Pass;
import com.metacube.springJDBC.utils.Queries;

@Transactional
@Repository
public class PassDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;	
	
	public Integer insertPass(Pass pass) throws Exception{
		return jdbcTemplate.update(Queries.insertPass,pass.getVehicle_id(),pass.getEmp_id(),pass.getPass_type(),pass.getRate());
	}

}
