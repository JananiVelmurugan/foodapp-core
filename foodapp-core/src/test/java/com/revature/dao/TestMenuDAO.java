package com.revature.dao;

public class TestMenuDAO {
	public static void main(String[] args) {

		// Menu menu = new Menu();
		// menu.setId(2);
		// menu.setName("Vada");
		//
		// MenuDAO dao = new MenuDAO();
		// dao.save(menu);

		// Menu m = dao.listByName("Pongal");
		// System.out.println(m);

		// for (Menu m : menus) {
		// System.out.println(m);
		//
		// }
		MenuDAO dao = new MenuDAO();
		// Boolean isValid = dao.validateMenu("idli");
		// System.out.println(isValid);
		//
		// Long count = dao.findCount();
		// System.out.println(count);
		//
		// List<String> menuNames = dao.findMenuNames();
		// for (String menuName : menuNames) {
		// System.out.println(menuName);
		// }

		String status = dao.checkMenuAvailability("idli");
		System.out.println(status);
	}
}
