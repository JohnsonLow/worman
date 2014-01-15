package com.workman.sysman.model;
/**
 * 权限
 * @author
 *
 */
public class AuthModel {
	
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
