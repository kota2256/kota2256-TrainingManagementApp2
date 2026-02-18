package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.MUser;
import com.example.service.TMService;

@Controller
public class HomeController {

	@Autowired
	TMService tmService;
	
	@GetMapping("/home")
	public String getHome(Model model,@AuthenticationPrincipal UserDetails loginuser) {
		
		MUser user = tmService.getLoginUser(loginuser.getUsername());
		model.addAttribute("id", user.getId());
		
		return "home";
	}
}
