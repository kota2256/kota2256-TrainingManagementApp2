package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.WeightLogForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class WeightLogController {

	@GetMapping("/weightLog")
	public String getWeightLog(@ModelAttribute WeightLogForm form) {
		return "user/weightLog";
	}
	
	@PostMapping("/weightLog")
	public String postWeightLog(@ModelAttribute @Validated WeightLogForm form, BindingResult bindingresult) {
		//入力チェック
		if (bindingresult.hasErrors()) {
			return getWeightLog(form);
		}		
		log.info(form.toString());
				
		//登録処理
		
		
		return "redirect:/home";
	}
}

