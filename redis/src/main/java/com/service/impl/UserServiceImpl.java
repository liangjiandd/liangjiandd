package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.Users;
import com.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{
	
		@Autowired
		private UserDao dao;
	
		public List<Users> selectAll() {
			return dao.selectAll();
		}
		
		public int updateUsers(String pwd, long id) {
			return dao.updateUsers(pwd, id);
		}
}
