package com.service;

import java.util.List;

import com.entity.Users;

public interface UserService {
	List<Users> selectAll();
	int updateUsers(String pwd,long id);
}
