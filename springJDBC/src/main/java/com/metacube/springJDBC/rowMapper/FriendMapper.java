package com.metacube.springJDBC.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.springJDBC.entities.Friend;

public class FriendMapper implements RowMapper<Friend> {

	@Override
	public Friend mapRow(ResultSet rs, int arg1) throws SQLException {
		Friend friend = new Friend();
		friend.setFriend_id(rs.getInt(1));
		friend.setFriend_name(rs.getString(2));
		friend.setVehicle_number(rs.getString(3));
		friend.setEmail(rs.getString(4));
		friend.setContact(rs.getString(5));
		return friend;
	}

}
