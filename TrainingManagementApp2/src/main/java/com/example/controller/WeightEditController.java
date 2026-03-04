package com.example.controller;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.WeightEditForm;
import com.example.model.MUser;
import com.example.model.WeightLog;
import com.example.service.TMService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j		//Simple Logging Facade for Javaの略
public class WeightEditController {

	@Autowired
	private TMService tmService;
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/physicals/edit/physical_details.{createdAt}")
	public String getEditForm(Model model, WeightEditForm form, 
			@PathVariable("createdAt") @DateTimeFormat(pattern = "EEE MMM dd HH:mm:ss zzz yyyy") Date createdAt,
			@AuthenticationPrincipal UserDetails loginuser) {
		
		// ログインユーザー情報の取得
		MUser user = tmService.getLoginUser(loginuser.getUsername());
		
		// 体重記録一件取得
		WeightLog weightLogOne = tmService.getWeightLogOne(user.getId(), createdAt);
		
		// 画面表示用にモデル格納
		form = modelMapper.map(weightLogOne, WeightEditForm.class);
		model.addAttribute("weightEditForm", form);
		return "user/weightEdit";
	}
	
	@PostMapping("/physicals/edit/physical_details.{createdAt}")
	public String postEditForm(Model model, @ModelAttribute @Validated WeightEditForm form, BindingResult bindingresult,
			@PathVariable("createdAt") @DateTimeFormat(pattern = "EEE MMM dd HH:mm:ss zzz yyyy") Date createdAt,
			@AuthenticationPrincipal UserDetails loginuser) {
		
		// エラーチェック
		if (bindingresult.hasErrors()) {
			return "user/weightEdit";		//テンプレートを返しても画面入力値が保持されるのはなぜ？
		}
		
		log.info(form.toString());
		
		// ログインユーザー情報の取得
		MUser user = tmService.getLoginUser(loginuser.getUsername());
		
		// 更新処理 
		tmService.updateWeightLogOne(user.getId(), createdAt, form.getRecordedDate(), form.getWeight());
		
		// 体重閲覧画面にリダイレクト
		return "redirect:/physicals/users." + user.getId();
	}
	
}
