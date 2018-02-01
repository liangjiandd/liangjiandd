package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.UserDao;
import com.entity.Users;
import com.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	
	@RequestMapping("selectIsLogin")
	public Users selectIsLogin(String username, String pwd) {
		return dao.selectIsLogin(username, pwd);
	}
}
