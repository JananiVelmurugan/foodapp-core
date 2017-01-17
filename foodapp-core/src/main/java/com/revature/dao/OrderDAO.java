package com.revature.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.revature.model.Menu;
import com.revature.model.Order;
import com.revature.util.ConnectionUtil;

public class OrderDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(Order order) {

		String sql = "insert into orders(id,menu_id,quantity) values(?,?,?)";
		Object[] params = { order.getId(), order.getMenu().getId(), order.getQuantity() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}

	public List<Order> list() {

		String sql = "select orders.id,menu_id,name,quantity from orders join menu where menu.id = orders.menu_id";
		List<Order> list = jdbcTemplate.query(sql, (rs, rowNum) -> {

			Order order = new Order();
			order.setId(rs.getInt("id"));

			Menu menu = new Menu();
			menu.setId(rs.getInt("menu_id"));
			menu.setName(rs.getString("name"));
			order.setMenu(menu);

			order.setQuantity(rs.getInt("quantity"));

			return order;

		});
		return list;

	}

}
