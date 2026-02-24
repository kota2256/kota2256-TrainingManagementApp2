package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.form.WeightEditForm;

@Controller
public class WeightEditController {

	@GetMapping("/physicals/edit/physical_details.{createdAt}")
	public String getEditForm(@ModelAttribute WeightEditForm form, @PathVariable("createdAt") String createdAt, @AuthenticationPrincipal UserDetails loginuser) {
		
		// 体重記録一件取得
		
		//modelに格納
		
		return "user/weightEdit";
	}
}
