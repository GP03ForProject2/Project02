package com.qst.project02.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qst.project02.pojo.User;
import com.qst.project02.service.LoginService;

@Controller
@RequestMapping("/")
public class LoginController {
	/**
	 * 登录接口
	 */
	@Autowired
	LoginService loginService;

	// 跳转首页（登录页）
	@RequestMapping("/")
	public String index() {
		return "LoginRegist/assets/login";
	}

	// 登录操作
	@ResponseBody
	@RequestMapping("/loginUser")
	// HttpServletRequest对象代表客户端的请求
	public String login(User user, HttpServletRequest request) {

		String usename = user.getUsername();
		String password = user.getPassword();
		User u1 = loginService.login(usename, password);
		if (u1 == null) {
			return "用户名或密码错误";
		} else {
			// 登录成功后将用户放入session中，用于拦截
			request.getSession().setAttribute("session_user", user);
			return "登录成功";
		}
	}

	// 跳转注册页
	@RequestMapping("/toRegist")
	public String toRegister() {
		return "regist";
	}

//	// 注册操作
//	@RequestMapping("/register")
//	public String register(LoginBean loginBean) {
//		int su = loginService.register(loginBean);
//		if (su == 0) {
//			System.out.println("----");
//		}
//		return "regist";
//	}
}
