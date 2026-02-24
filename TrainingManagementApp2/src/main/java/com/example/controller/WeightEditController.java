package com.example.controller;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.form.WeightEditForm;
import com.example.model.WeightLog;
import com.example.service.TMService;

@Controller
public class WeightEditController {

	@Autowired
	private TMService tmService;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/physicals/edit/physical_details.{recodedDate}")
	public String getEditForm(Model model, WeightEditForm form,
			@RequestParam("userId") int userId,
			@RequestParam("createdAt") @DateTimeFormat(pattern = "EEE MMM dd HH:mm:ss zzz yyyy") Date createdAt,
			@AuthenticationPrincipal UserDetails loginuser) {
		
		// 体重記録一件取得
		WeightLog weightLogOne = tmService.getWeightLogOne(userId, createdAt);
		// 画面表示用にモデル格納
		form = modelMapper.map(weightLogOne, WeightEditForm.class);
		model.addAttribute("weightEditForm", form);
		
		return "user/weightEdit";
	}
	
//	@PostMapping("/physicals/edit/physical_details.{recodedDate}")
//	public String postEditForm(@ModelAttribute WeightEditForm form, @PathVariable("createdAt") String createdAt, @AuthenticationPrincipal UserDetails loginuser) {
//		
//		// 更新処理
//		
//		// 体重閲覧画面にリダイレクト
//		MUser user = tmService.getLoginUser(loginuser.getUsername());
//		return "redirect:/physicals/users." + user.getId();
//	}
//	
}
