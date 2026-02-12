package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getLogin() {
		return "login";
	}
	
	//SecurityConfigで設定済み
//	@PostMapping("login")
//	public String postLogin() {
//		return "redirect:/home";
//	}
}
