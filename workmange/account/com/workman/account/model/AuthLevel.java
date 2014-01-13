package com.workman.account.model;

import java.io.Serializable;

/**
 * 用户权限
 * @author liuyw
 *
 */
public class AuthLevel implements Serializable {
	private int id;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
