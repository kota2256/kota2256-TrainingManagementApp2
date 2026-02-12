package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UserListController {

	@GetMapping("/userList")
	public String getUserList() {
		return "admin/userList";
	}
	
	@PostMapping("/userList")
	public String postUserList() {
		return "redirect:/admin/userList";
	}
}
