package com.workman.sysman.model;

import java.io.Serializable;

public class DepartmentModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6432259793271949520L;
	
	private int code;
	private String name;
	private String description;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
