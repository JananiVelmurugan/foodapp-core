package com.revature.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.revature.model.Food;

public class TestFoodDAO {
	public static void main(String[] args) {
		Food food = new Food();
		food.setType("LUNCH");
		food.setCreatedDate(LocalDate.now());
		food.setStartTime(LocalTime.parse("11:15:00"));
		food.setEndTime(LocalTime.parse("15:00:00"));

		FoodDAO foodDAO = new FoodDAO();
		foodDAO.save(food);

		List<Food> foodList = foodDAO.list();
		for (Food f : foodList) {
			System.out.println(f);
		}

	}
}
