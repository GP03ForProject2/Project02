package com.qst.project02.service.impl;

import com.qst.project02.mapper.LoginMappper;
import com.qst.project02.pojo.User;
import com.qst.project02.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMappper loginMappper;

    public User dologin(User user) {
        user = this.loginMappper.login(user.getUsername(), user.getPassword());
        return user;
    }

    // 用户登录
    public User login(String userName, String passWord) {
        return loginMappper.login(userName, passWord);
    }

    public int regist(User user) {
        return loginMappper.regist(user);
    }
}
