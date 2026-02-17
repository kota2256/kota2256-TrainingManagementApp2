package com.example.form;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class WeightLogForm {

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	public Date recordedDate;
	
	@Digits(integer=3, fraction=1)
	@NotNull
	public Double weight;
}
