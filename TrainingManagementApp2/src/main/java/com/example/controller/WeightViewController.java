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
	public String getWeightView(Model model, @PathVariable("id") int id, @AuthenticationPrincipal UserDetails loginuser, 
			@RequestParam(defaultValue = "1") int page) {
		

		//体重記録のリスト取得しモデル格納（ページネーションなし）
//		List<WeightLog> weightLogList = tmService.getWeightLog(loginuser.getUsername());
//		model.addAttribute(weightLogList);
		
		//体重記録のリスト取得(ページネーション用）
		int pageSize = 10;
		List<WeightLog> weightLogList = tmService.getWeightLog(id, page, pageSize);
		
		// 体重記録の総件数から総ページ数の取得(ページネーション用）
		int totalCount = tmService.getWeightLogCount(id);
		int totalPages = (int) Math.ceil((double) totalCount / pageSize);		//Math.ceilで切り上げ
		
		//モデル格納
		model.addAttribute(weightLogList);	//属性名省略（Listの場合オブジェクトの先頭小文字の文字列に「List」が付加される＝「weightLogList」）
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", totalPages);
		
		return "user/weightView";
	}
	
}
