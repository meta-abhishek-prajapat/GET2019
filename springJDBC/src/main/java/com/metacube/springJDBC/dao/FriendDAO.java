package com.metacube.springJDBC.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.springJDBC.entities.Employee;
import com.metacube.springJDBC.entities.Friend;
import com.metacube.springJDBC.utils.Queries;

@Transactional
@Repository
public class FriendDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Friend> getAllFriends(Integer emp_id) throws Exception{
		//RowMapper<Friend> rowmapper = new BeanPropertyRowMapper<Friend>(Friend.class);
		//return jdbcTemplate.query(Queries.getAllfriends,rowmapper,emp_id,emp_id);
		List<Friend> frnds = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(Queries.getAllfriends,emp_id,emp_id);
        for (Map row : rows) {
            Friend obj = new Friend();
            obj.setFriend_id(((Integer) row.get("id")));
            obj.setFriend_name((String) row.get("name"));
			// Spring returns BigDecimal, need convert
            frnds.add(obj);
        }
        return frnds;
	}
	
	public Friend getFriendProfile(Integer id) throws Exception{
		RowMapper<Friend> rowmapper = new BeanPropertyRowMapper<Friend>(Friend.class);
		Friend frnd = jdbcTemplate.queryForObject(Queries.getFriendProfile,rowmapper,id); 
		return frnd;
	}
	

}
