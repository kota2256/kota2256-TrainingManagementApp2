package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.MUser;
import com.example.model.WeightLog;

@Mapper
public interface TMMapper {

	// 1件登録
	public int insertOne(MUser user);
	
	// ログインユーザー取得
	public MUser findLoginUser(String email);
	
	//体重記録全件取得
	public List<WeightLog> findManyWeightLog(int userId);
}
