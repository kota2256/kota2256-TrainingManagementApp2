package com.example.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserWithName extends User {
	private final String name;
	
	//コンストラクタで値をセット
	public UserWithName(String username, String password, Collection<? extends GrantedAuthority> authorities, String name) {
		super(username, password, authorities);
		this.name = name;
	}
		
	public  String getName() {
		return name;
	}
		
}
