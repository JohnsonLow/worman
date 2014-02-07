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
	private Date handlerTime;
	private Date commitTime;
	private int missionType;
	
	public int getMissionType() {
		return missionType;
	}
	public void setMissionType(int missionType) {
		this.missionType = missionType;
	}
	private List<MissionHandleModel> handls;
	
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
	public Date getHandlerTime() {
		return handlerTime;
	}
	public void setHandlerTime(Date handlerTime) {
		this.handlerTime = handlerTime;
	}
	public Date getCommitTime() {
		return commitTime;
	}
	public void setCommitTime(Date commitTime) {
		this.commitTime = commitTime;
	}

}
