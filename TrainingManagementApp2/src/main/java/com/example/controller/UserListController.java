package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.MUser;
import com.example.service.TMService;

@Controller
public class UserListController {

	@Autowired
	TMService tmService;
	
	@GetMapping("/users")
	public String getUserList(Model model) {
		//ユーザーリストをモデル格納
		List<MUser> userList = tmService.getUsers(); 
		model.addAttribute("userList" , userList);	

		return "admin/userList";
	}
}