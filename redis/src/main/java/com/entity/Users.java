package com.entity;

import java.io.Serializable;

public class Users implements Serializable{
	private long id;
	private String username;
	private String pwd;
	
	public Users() {
		
	}
	
	public Users(long id, String username, String pwd) {
		this.id = id;
		this.username = username;
		this.pwd = pwd;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
