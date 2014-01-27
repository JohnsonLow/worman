package com.workman.sysman.model;

import java.io.Serializable;

/**
 * 权限 此类弃用
 * @author
 *
 */
@Deprecated
public class AuthModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1965504758321248993L;
	private int level;
	private String name;
	private String description;
	/**
	 * 权限等级
	 * @return
	 */
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * 权限名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 权限描述
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
