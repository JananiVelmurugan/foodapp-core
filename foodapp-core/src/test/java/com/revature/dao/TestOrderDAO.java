package com.revature.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.revature.model.Menu;
import com.revature.model.Order;

public class TestOrderDAO {
	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.setId(1);
		menu.setName("Idli");

		Order order = new Order();
		order.setId(103);
		order.setMenu(menu);
		order.setQuantity(2);
		order.setOrderDate(LocalDateTime.now());

		OrderDAO orderDAO = new OrderDAO();
		orderDAO.save(order);

		List<Order> orderList = orderDAO.list();
		for (Order o : orderList) {
			System.out.println(o);

		}
	}
}
