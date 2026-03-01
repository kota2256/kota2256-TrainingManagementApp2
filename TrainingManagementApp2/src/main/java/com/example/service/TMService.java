package com.example.service;

import java.util.List;

import com.example.model.MUser;
import com.example.model.WeightLog;

public interface TMService {

	//ユーザー1件登録
	public void signup(MUser user);
	
	//ログインユーザー情報取得
	public MUser getLoginUser(String email);
	
	// 体重記録 全件取得（ページネーションなし）
//	public List<WeightLog> getWeightLog(int id);
	
	// 体重記録 全件取得（ページネーション用）
	public List<WeightLog> getWeightLog(int id, int page, int pageSize);
	
	// 体重記録の総件数取得
	public int getWeightLogCount(int id);

	//ユーザー情報全件取得
	public List<MUser> getUsers();
 }

