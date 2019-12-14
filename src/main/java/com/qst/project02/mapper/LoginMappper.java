package com.qst.project02.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qst.project02.pojo.LoginBean;

/**
 * Mapper:映射
 * 
 * @Mapper则是对应mybatis的mapper.xml
 */

@Mapper
@Repository
public interface LoginMappper {
	LoginBean Sel(int id);

	/**
	 * 用户登录
	 * 
	 * @param userName 用户名
	 * @param password 密码
	 * @return UserInfo 用户信息
	 */
	LoginBean login(String username, String password);

	/**
	 * 通过用户名与密码查询用户信息
	 * 
	 */
	LoginBean selectByNameAndPwd(LoginBean record);

	int register(LoginBean loginBean);

}
