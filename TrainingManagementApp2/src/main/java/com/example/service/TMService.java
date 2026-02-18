package com.example.service;

import com.example.model.MUser;
import com.example.model.WeightLog;

public interface TMService {

	//ユーザー1件登録
	public void signup(MUser user);
	
	//体重記録1件登録
	public void  insertWeightLog(WeightLog weightLog);
	
	//ログインユーザー情報取得
	public MUser getLoginUser(String email);
}

