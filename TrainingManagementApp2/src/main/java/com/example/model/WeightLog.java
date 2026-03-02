package com.example.model;

import java.util.Date;

import lombok.Data;

@Data
public class WeightLog {

	private int userId;
	private Date recordedDate;
	private Double weight;
	
}
