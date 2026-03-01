package com.example.form;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class WeightLogForm {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date recordedDate;
	
	@Digits(integer=3, fraction=1)
	@NotNull
	@PositiveOrZero
	private Double weight;
}
