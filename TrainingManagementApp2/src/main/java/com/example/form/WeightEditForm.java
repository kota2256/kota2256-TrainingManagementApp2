package com.example.form;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class WeightEditForm {
	private int userId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date recordedDate;
	
	@Digits(integer=3, fraction=1)
	@NotNull
	@PositiveOrZero
	private Double weight;
	
	@DateTimeFormat(pattern = "EEE MMM dd HH:mm:ss zzz yyyy") 
	private Date createdAt;
}
