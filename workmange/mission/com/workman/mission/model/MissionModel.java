package com.workman.mission.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.workman.sysman.model.AccountModel;

public class MissionModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6508467153044598589L;
	private int code;
	private String title;
	private String content;
	private AccountModel sponsor;
	private AccountModel handler;
	private Date createTime;
	private Date handleTime;
	private Date commitTime;
	private String type;
	private int status;
	private String notes;
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	private List<MissionHandleModel> handls;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<MissionHandleModel> getHandls() {
		return handls;
	}
	public void setHandls(List<MissionHandleModel> handls) {
		this.handls = handls;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public AccountModel getSponsor() {
		return sponsor;
	}
	public void setSponsor(AccountModel sponsor) {
		this.sponsor = sponsor;
	}
	public AccountModel getHandler() {
		return handler;
	}
	public void setHandler(AccountModel handler) {
		this.handler = handler;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}
	public Date getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}

}
