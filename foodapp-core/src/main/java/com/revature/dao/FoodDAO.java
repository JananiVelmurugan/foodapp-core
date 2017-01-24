package com.revature.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Food;
import com.revature.util.ConnectionUtil;

public class FoodDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Food food) {

		String sql = "insert into food(type,created_date,start_time,end_time) values(?,?,?,?)";
		Object[] params = { food.getType(), food.getCreatedDate(), food.getStartTime(), food.getEndTime() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public List<Food> list() {

		String sql = "select id,type,created_date,start_time,end_time from food";
		List<Food> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Food food = convert(rs);
			return food;
		});
		return list;

	}

	static Food convert(ResultSet rs) throws SQLException {
		Food food = new Food();
		food.setId(rs.getInt("id"));
		food.setType(rs.getString("type"));
		food.setCreatedDate(rs.getDate("created_date").toLocalDate());
		food.setStartTime(rs.getTime("start_time").toLocalTime());
		food.setEndTime(rs.getTime("end_time").toLocalTime());
		return food;
	}
}
