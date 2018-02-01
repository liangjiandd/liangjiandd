package com.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.entity.Users;

@Repository("UserDao")
public interface UserDao {
	Users selectIsLogin(@Param("username")String username,@Param("pwd")String pwd);
}
