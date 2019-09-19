package com.metacube.springJDBC.dao;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.springJDBC.entities.Vehicle;
import com.metacube.springJDBC.utils.Queries;

@Transactional
@Repository
public class VehicleDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public  Integer insertVehicle(Vehicle vehicle) throws Exception{
		return jdbcTemplate.update(Queries.insertVehicle,vehicle.getVehicle_name(),vehicle.getType(),vehicle.getVehicle_number(),vehicle.getEmp_id(),vehicle.getIdentification());	
	}
	
	public  Integer getlastInsertedVehicleId() throws Exception{
		String query = "select max(id) from vehicle";
		int count = jdbcTemplate.queryForObject(query, Integer.class);
		if(count>0)
			return count;
		else
			return 0;
	}
}
