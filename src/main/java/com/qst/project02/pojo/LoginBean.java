package com.qst.project02.pojo;

/**
 * 登录接口封装对象
 * 
 */
public class LoginBean {

	private Integer id;

	// 用户名
	private String username;
//		密码
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}