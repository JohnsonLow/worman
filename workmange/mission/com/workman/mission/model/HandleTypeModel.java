package com.workman.mission.model;

import java.io.Serializable;
/**
 * 处理类型
 *
 */
public class HandleTypeModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2758141759106234429L;
	private int code;
	private String name;
	/**
	 * 处理类型代码
	 * @return
	 */
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * 处理类型
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
