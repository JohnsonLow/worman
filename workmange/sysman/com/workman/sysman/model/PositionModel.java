package com.workman.sysman.model;

import java.io.Serializable;

/**
 * 职位表
 * @author 
 *
 */
public class PositionModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5293967145685871475L;
	private int code;
	private String name;
	private String description;
	/**
	 * 职位代码
	 * @return
	 */
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * 职位名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 职位描述
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
