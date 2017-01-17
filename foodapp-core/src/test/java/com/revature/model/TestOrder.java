package com.revature.model;

public class TestOrder {
	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.setId(3);
		menu.setName("Pongal");

		Order order = new Order();
		order.setId(101);
		order.setMenu(menu);
		order.setQuantity(1);

		System.out.println(order);

	}
}
