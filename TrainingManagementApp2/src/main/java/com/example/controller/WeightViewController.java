package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.WeightLog;
import com.example.service.TMService;

@Controller
public class WeightViewController {

	@Autowired
	private TMService tmService;
	
	@GetMapping("physicals/users.{id}")
	public String getWeightView(Model model, @PathVariable("id") String Id, @AuthenticationPrincipal UserDetails loginuser, 
			@RequestParam(defaultValue = "1") int page) {
		
		//体重記録のリスト取得しモデル格納
//		List<WeightLog> weightLogList = tmService.getWeightLog(loginuser.getUsername());
//		model.addAttribute(weightLogList);
		
		//体重記録のリスト取得(ページネーション用）
		int pageSize = 5;
		List<WeightLog> weightLogList = tmService.getWeightLog(loginuser.getUsername(), page, pageSize);
		
		// 体重記録の総件数から総ページ数の取得(ページネーション用）
		int totalCount = tmService.getWeightLogCount(loginuser.getUsername());
		int totalPages = (int) Math.ceil((double) totalCount / pageSize);		//Math.ceilで切り上げ
		model.addAttribute(weightLogList);
		
		//モデル格納
		model.addAttribute(weightLogList);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		
		return "user/weightView";
	}
	
}
