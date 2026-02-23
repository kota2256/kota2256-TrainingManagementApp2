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
	
	// 体重記録 全件取得取得（ページネーション用）
	public List<WeightLog> getWeightLog(String email, int page, int pageSize);
	
	// 体重記録の総件数取得
	public int getWeightLogCount(String email);
}

