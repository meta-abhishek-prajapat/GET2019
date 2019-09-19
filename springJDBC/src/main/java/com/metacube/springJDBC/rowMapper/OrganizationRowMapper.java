package com.metacube.springJDBC.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.springJDBC.entities.Organization;

public class OrganizationRowMapper implements RowMapper<Organization> {

	@Override
	public Organization mapRow(ResultSet rs, int arg1) throws SQLException {
		Organization org = new Organization();
		org.setId(rs.getInt(1));
		org.setOrganization_name(rs.getString(2));
		return null;
	}

}
