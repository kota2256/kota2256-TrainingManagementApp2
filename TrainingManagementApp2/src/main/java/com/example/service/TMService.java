package com.example.service;

import java.util.List;

import com.example.model.MUser;
import com.example.model.WeightLog;

public interface TMService {

	//ユーザー1件登録
	public void signup(MUser user);
	
	//ログインユーザー情報取得
	public MUser getLoginUser(String email);
	
	// 体重記録 全件取得
	public List<WeightLog> getWeightLog(String email);
}

