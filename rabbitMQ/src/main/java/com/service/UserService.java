package com.service;

import com.entity.Users;

public interface UserService {
	Users selectIsLogin(String username,String pwd);
}
