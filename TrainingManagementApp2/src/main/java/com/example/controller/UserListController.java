package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MUser;
import com.example.service.TMService;

@Controller
@RequestMapping("/admin")
public class UserListController {

	@Autowired
	TMService tmService;
	
	@GetMapping("/userList")
	public String getUserList(Model model) {
		//ユーザーリストをモデル格納
		List<MUser> userList = tmService.getUsers(); 
		model.addAttribute("userList" , userList);	
		
		return "admin/userList";
	}
	
//	@PostMapping("/userList")
//	public String postUserList() {
//		return "redirect:/admin/userList";
//	}
}
