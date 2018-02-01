package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.entity.Users;

@Repository("UserDao")
public interface UserDao {
	List<Users> selectAll();
	int updateUsers(@Param("pwd")String pwd,@Param("id")long id);
}
