package com.workman.sysman.model;

import java.io.Serializable;

public class AccountModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7654521026852196295L;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String userName;
	private String password;
	private String name;
	private String phone;
	private PositionModel pos;
	private DepartmentModel department;
	
/*	private AuthModel auth;
	public AuthModel getAuth() {
		return auth;
	}
	public void setAuth(AuthModel auth) {
		this.auth = auth;
	}*/
	
	
	public String getUserName() {
		return userName;
	}
	public PositionModel getPos() {
		return pos;
	}
	public void setPos(PositionModel pos) {
		this.pos = pos;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String weibo;
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
	public DepartmentModel getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentModel department) {
		this.department = department;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}
