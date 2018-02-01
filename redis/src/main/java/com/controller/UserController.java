package com.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Users;
import com.service.UserService;

@Controller("UserController")
public class UserController {
		
	@Autowired
	private UserService us;
	
	@RequestMapping("selectAll")
	public String selectAll(HttpServletRequest request) {
		List<Users> userslist=us.selectAll();
		request.setAttribute("userslist", userslist);
		return "show";
	}
	
	@RequestMapping("updateUsers")
	public String updateUsers(HttpServletResponse response,long id,String pwd) throws Exception{
		PrintWriter out=response.getWriter();
		int line=us.updateUsers(pwd, id);
		out.print(line);
		out.flush();
		out.close();
		return null;
	}
}
