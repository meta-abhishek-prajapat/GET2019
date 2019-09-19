package com.metacube.springJDBC.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.springJDBC.entities.Pass;

public class PassRowMapper implements RowMapper<Pass> {

	@Override
	public Pass mapRow(ResultSet rs, int arg1) throws SQLException {
		Pass pass = new Pass();
		pass.setId(rs.getInt(1));
		pass.setVehicle_id(rs.getInt(2));
		pass.setEmp_id(rs.getInt(3));
		pass.setPass_type(rs.getString(4));
		pass.setRate(rs.getString(5));
		return pass;
	}

}
