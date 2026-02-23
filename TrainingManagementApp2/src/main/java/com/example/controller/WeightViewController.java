package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.WeightLog;
import com.example.service.TMService;

@Controller
public class WeightViewController {

	@Autowired
	private TMService tmService;
	
	@GetMapping("physicals/users.{id}")
	public String getWeightView(Model model, @PathVariable("id") String Id, @AuthenticationPrincipal UserDetails loginuser) {
		
		//体重記録のリスト取得しモデル格納
		List<WeightLog> weightLogList = tmService.getWeightLog(loginuser.getUsername());
		model.addAttribute(weightLogList);
		
		return "user/weightView";
	}
	
}
