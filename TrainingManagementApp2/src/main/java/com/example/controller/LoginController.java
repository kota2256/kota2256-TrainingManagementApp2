package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.LoginForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@GetMapping("/login")
	public String getLogin(@ModelAttribute LoginForm form) {
		return "login";
	}
	
//	SecurityConfigで設定済み
	@PostMapping("login")
	public String postLogin(@ModelAttribute @Validated LoginForm form, BindingResult bindingresult) {
		
		if(bindingresult.hasErrors()) {
			return getLogin(form);
		}
		
		log.info(form.toString());
		
		return "redirect:/home";
	}
}
