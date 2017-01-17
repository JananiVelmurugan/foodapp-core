package com.revature.dao;

import java.util.List;

import com.revature.model.Menu;

public class TestMenuDAO {
	public static void main(String[] args) {

		// Menu menu = new Menu();
		// menu.setId(2);
		// menu.setName("Vada");
		//
		MenuDAO dao = new MenuDAO();
		// dao.save(menu);
		
		Menu m = dao.listByName("Pongal");
		//System.out.println(m);

		// for (Menu m : menus) {
		// System.out.println(m);
		//
		// }

	}
}
