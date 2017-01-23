package com.revature.dao;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.revature.model.Menu;
import com.revature.util.ConnectionUtil;

public class MenuDAO {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Menu menu) {

		String sql = "insert into menu(id,name) values(?,?)";
		Object[] params = { menu.getId(), menu.getName() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public void update(Menu menu) {

		String sql = "update menu set name=? where id=?";
		Object[] params = { menu.getName(), menu.getId() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);

	}

	public void delete(int id) {

		String sql = "delete from menu where id=?";
		int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}

	public List<Menu> list() {

		String sql = "select id,name from menu";
		List<Menu> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			Menu menu = new Menu();
			menu.setId(rs.getInt("id"));
			menu.setName(rs.getString("name"));
			return menu;

		});
		return list;

	}

	public Boolean validateMenu(String name) {
		String sql = "select fn_is_menu_present(?)";
		Boolean isAvailable = jdbcTemplate.queryForObject(sql, new Object[] { name }, Boolean.class);
		return isAvailable;
	}

	public String checkMenuAvailability(String name) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("pr_check_menu_availability")
				.declareParameters(new SqlParameter("in_name", Types.VARCHAR),
						new SqlOutParameter("out_status", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource().addValue("in_name", name);
		Map<String, Object> execute = call.execute(in);
		String status = (String) execute.get("out_status");
		return status;

	}

	public Long findCount() {
		Long menuCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM menu", Long.class);
		return menuCount;
	}

	public List<String> findMenuNames() {
		List<String> menuNameList = jdbcTemplate.queryForList("SELECT name FROM menu", String.class);
		return menuNameList;
	}

	public Menu listByName(String name) {
		Menu menu = null;
		try {
			String sql = "select id,name from menu where name=?";
			Object[] params = { name };
			menu = jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
				Menu m = new Menu();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				return m;

			});
		} catch (EmptyResultDataAccessException e) {
			System.out.println("Menu Not Available");
		}

		return menu;

	}
}
