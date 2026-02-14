package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.MUser;
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
	
	//ユーザー情報全件取得
	@Override
	public List<MUser> getUsers() {
		return mapper.findMany();
	}
}
