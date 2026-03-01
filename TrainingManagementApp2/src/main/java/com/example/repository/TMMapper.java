package com.example.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
	
	// 体重記録一覧（ページネーション用）
	public List<WeightLog> findWeightLogByUserId(
			@Param("userId") int userId,
			@Param("pageSize") int pageSize, 
			@Param("offset") int offset
			);
	
	// 体重記録件数カウント
	public int countWeightLogByUserId(@Param("userId") int userId);
	
	// 体重記録1件取得
	public WeightLog findWeightLogOne(
			@Param("userId") int userId,
			@Param("createdAt") Date createdAt);
	
	// 体重記録一件更新
	public int updateOne(
		@Param("userId") int userId,
		@Param("createdAt") Date createdAt,
		@Param("recordedDate") Date recordedDate,
		@Param("weight") Double weight
		);
	
	

	// 全件取得
	public List<MUser> findMany(); 
}
