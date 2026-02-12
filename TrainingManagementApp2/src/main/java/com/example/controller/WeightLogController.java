package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class WeightLogController {

	@GetMapping("/weightLog")
	public String getWeightLog() {
		return "user/weightLog";
	}
	
	@PostMapping("/weightLog")
	public String postWeightLog() {
		return "redirect:/user/weightLog";
	}
}
