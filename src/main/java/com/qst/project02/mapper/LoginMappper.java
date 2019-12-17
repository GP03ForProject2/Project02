package com.qst.project02.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qst.project02.pojo.User;

/**
 * Mapper:映射
 * 
 * Mapper则是对应mybatis的mapper.xml
 */

@Mapper
@Repository
public interface LoginMappper {
	User Sel(int id);

	/**
	 * 用户登录
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @return UserInfo 用户信息
	 */
	User login(String username, String password);

	/**
	 * 通过用户名与密码查询用户信息
	 * 
	 */
	//User selectByNameAndPwd(User record);

	int regist(User user);

}
