package com.metacube.springJDBC.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.springJDBC.entities.Vehicle;

public class VehicleRowMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int arg1) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setId(rs.getInt(1));
		vehicle.setVehicle_name(rs.getString(2));
		vehicle.setType(rs.getString(3));
		vehicle.setVehicle_number(rs.getString(4));
		vehicle.setEmp_id(rs.getInt(5));
		vehicle.setIdentification(rs.getString(6));
		return vehicle;
	}

}
