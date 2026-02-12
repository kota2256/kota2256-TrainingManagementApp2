package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class WeightViewController {

	@GetMapping("/weightView")
	public String getWeightView() {
		return "user/weightView";
	}
	
	@PostMapping("/weightView")
	public String postWeightView() {
		return "redirect:/user/weightView";
	}
}
