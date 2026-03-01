package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.MUser;
import com.example.model.WeightLog;
import com.example.repository.TMMapper;

@Service
public class TMServiceImpl implements TMService {
	
	@Autowired
	private TMMapper mapper;
	@Autowired
	private PasswordEncoder encoder;
	
	
	//ユーザー1件登録
	@Override
	public void signup(MUser user) {
		user.setPassword(encoder.encode(user.getPassword()));	//パスワードのハッシュ化
		user.setRoleCode(2);
		mapper.insertOne(user);
	}
	
	//ログインユーザー情報取得
	@Override
	public MUser getLoginUser(String email) {
		return mapper.findLoginUser(email);
	}
	
	// 体重記録 全件取得
	@Override
	public List<WeightLog> getWeightLog(String email){
		// email（username）からuserId取得
		int userId = getLoginUser(email).getId();
		return mapper.findManyWeightLog(userId);
	}
	
	// 体重記録 全件取得取得（ページネーション用）
	public List<WeightLog> getWeightLog(String email, int page, int pageSize){
		int userId = getLoginUser(email).getId();
		int offset = (page - 1) * pageSize;
		return mapper.findWeightLogByUserId(userId, pageSize, offset);
	}
	
	// 体重記録の総件数取得
	public int getWeightLogCount(String email) {
		int userId = getLoginUser(email).getId();
		return mapper.countWeightLogByUserId(userId);
	}
	
	// 体重記録 1件取得
	@Override
	public WeightLog getWeightLogOne(int userId, Date createdAt) {
		return mapper.findWeightLogOne(userId, createdAt);
	}
	
	// 体重記録 1件更新
	@Override
	public int updateWeightLogOne(int userId, Date createdAt, Date recordedDate, Double weight) {
		return mapper.updateOne(userId, createdAt, recordedDate, weight);
	}
	
	// 体重記録 1件削除
	@Override
	public int deleteWeightLogOne(int userId, Date createdAt) {
		return mapper.deleteOne(userId, createdAt);
	}
	
	//ユーザー情報全件取得
	@Override
	public List<MUser> getUsers() {
		return mapper.findMany();
	}
}
