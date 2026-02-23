package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WeightViewController {

	@GetMapping("physicals/users.{id}")
	public String getWeightView(@PathVariable("id") String Id) {
		
		return "user/weightView";
	}
}
