package com.revature.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class Food {

	private int id;
	private String type;
	private LocalDate createdDate;
	private LocalTime startTime;
	private LocalTime endTime;

}
