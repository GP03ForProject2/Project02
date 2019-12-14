package com.qst.project02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.project02.mapper.LoginMappper;
import com.qst.project02.pojo.LoginBean;

@Service
public class LoginService {

	@Autowired
	LoginMappper loginMappper;

	public LoginBean dologin(LoginBean loginBean) {
		loginBean = this.loginMappper.login(loginBean.getUsername(), loginBean.getPassword());
		return loginBean;
	}

	// 用户登录
	public LoginBean login(String userName, String passWord) {
		return loginMappper.login(userName, passWord);
	}

	public int register(LoginBean loginBean) {
		return loginMappper.register(loginBean);
	}
}