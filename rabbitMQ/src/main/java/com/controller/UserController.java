package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Users;
import com.service.UserService;

@Controller("UserController")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@RequestMapping("isLogin")
	public String isLogin(String username,String pwd,HttpServletRequest request) {
		Users u2=us.selectIsLogin(username, pwd);
		if(u2!=null) {
			request.setAttribute("user", u2.getUsername());
			return "chat";
		}else {
			return "login";
		}
	}
}
