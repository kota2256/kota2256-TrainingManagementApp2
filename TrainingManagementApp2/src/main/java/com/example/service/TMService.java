package com.example.service;

import java.util.Date;
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
	
	// 体重記録 1件取得
	public WeightLog getWeightLogOne(int userId, Date createdAt);
	
	// 体重記録 1件更新
	public int updateWeightLogOne(int userId, Date createdAt, Date recordedDate, Double weight);
	
	// 体重記録 1件削除
	public int deleteWeightLogOne(int userId, Date createdAt);
	
	//ユーザー情報全件取得
	public List<MUser> getUsers();
 }

