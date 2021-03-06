package com.workman.weibo.model;

import java.io.Serializable;

/**
 * 本地Token实体类
 * @author lyw
 *
 */
public class AccessTokenModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5558415653995636144L;
	private String weiboName;
	private String token;
	private int accountId;
	private String uid;
	
	
	public String getWeiboName() {
		return weiboName;
	}
	public void setWeiboName(String weiboName) {
		this.weiboName = weiboName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
}
