package com.qst.project02.service;

import com.qst.project02.pojo.User;

public interface LoginService {
	public User login(String userName, String passWord);

	public int regist(User user);

	public User dologin(User user);
}