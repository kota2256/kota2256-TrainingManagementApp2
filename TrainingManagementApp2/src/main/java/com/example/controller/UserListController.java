package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserListController {

	@GetMapping("/users")
	public String getUserList() {
		return "admin/userList";
	}

}
