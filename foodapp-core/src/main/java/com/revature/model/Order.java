package com.revature.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Order {

	private int id;
	private Menu menu;
	private int quantity;
	private LocalDateTime orderDate;

}
