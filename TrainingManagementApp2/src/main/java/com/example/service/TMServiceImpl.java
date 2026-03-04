package com.example.service;

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
	
	//体重記録1件登録
	@Override
	public void  insertWeightLog(WeightLog weightLog) {
		mapper.insertWeightLog(weightLog);
	}
	
	//ログインユーザー情報取得
	@Override
	public MUser getLoginUser(String email) {
		return mapper.findLoginUser(email);
	}
	
	// 体重記録 全件取得（ページネーションなし）
//	@Override
//	public List<WeightLog> getWeightLog(int id){
//		return mapper.findManyWeightLog(id);
//	}
	
	// 体重記録 全件取得（ページネーション用）
	public List<WeightLog> getWeightLog(int id, int page, int pageSize){
		int offset = (page - 1) * pageSize;
		return mapper.findWeightLogByUserId(id, pageSize, offset);
	}
	
	// 体重記録の総件数取得
	public int getWeightLogCount(int id) {
		return mapper.countWeightLogByUserId(id);
	}
	
	//ユーザー情報全件取得
	@Override
	public List<MUser> getUsers() {
		return mapper.findMany();
	}
}
