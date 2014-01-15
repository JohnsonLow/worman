package com.workman.sysman.model;

import java.io.Serializable;

public class AccountModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4154305009097499409L;
	private String username;
	private String password;
	private String name;
	private String phone;
	private AuthModel auth;
	public AuthModel getAuth() {
		return auth;
	}
	public void setAuth(AuthModel auth) {
		this.auth = auth;
	}
	public PositionModel getPostion() {
		return postion;
	}
	public void setPostion(PositionModel postion) {
		this.postion = postion;
	}
	private PositionModel postion;
	private String department;
	private String weibo;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}
