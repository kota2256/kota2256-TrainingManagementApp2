package com.example.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.model.WeightLog;
import com.example.service.TMService;

@Controller
public class WeightDeleteController {

	@Autowired
	private TMService tmService;
	
	@PostMapping("/physicals/delete/physical_details.{createdAt}")
	public String postDelete(@PathVariable("createdAt") @DateTimeFormat(pattern = "EEE MMM dd HH:mm:ss zzz yyyy") Date createdAt) {
		
		// 体重記録一件取得(リダイレクト用)	
		WeightLog weightLogOne = tmService.getWeightLogOne(createdAt);
		
		// 削除処理
		tmService.deleteWeightLogOne(createdAt);
		
		return "redirect:/physicals/users." + weightLogOne.getUserId();
	}
}
