package com.revature.model;

import lombok.Data;

@Data
public class Order {

	private int id;
	private Menu menu;
	private int quantity;

}
