package com.example.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.WeightLogForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class WeightLogController {

//	@Autowired
//	private TMService tmService;
//	@Autowired
//	private ModelMapper modelMapper;
	
	@GetMapping("/physicals/create")
	public String getWeightLog(@ModelAttribute WeightLogForm form) {
		return "user/weightLog";
	}
	
	@PostMapping("/physicals/create")
	public String postWeightLog(@ModelAttribute @Validated WeightLogForm form, BindingResult bindingresult,@AuthenticationPrincipal UserDetails loginuser) {
		//入力チェック
		if (bindingresult.hasErrors()) {
			return getWeightLog(form);
		}		
		log.info(form.toString());
				
		//ログインuserデータ取得 getUserOneメソッド要作成！！！
//		MUser user = tmService.getUserOne(loginuser.getUsername());
		
		//登録処理
//		WeightLog weightLog = modelMapper.map(form, WeightLog.class);
//		weightLog.setUserId(user.getId());
//		tmService.insertWeightLog(weightLog);
			
		return "redirect:/home";
	}
}

