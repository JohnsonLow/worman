package com.workman.mission.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.workman.sysman.model.AccountModel;
/**
 * 任务处理记录
 *
 */
public class MissionHandleModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5144910907551545906L;
	private int id;
	private int missionId;
	private String content;
	private AccountModel handlePeople;
	private AccountModel toPeople;
	private Date addTime;
	private Date handleTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public AccountModel getHandlePeople() {
		return handlePeople;
	}
	public void setHandlePeople(AccountModel handlePeople) {
		this.handlePeople = handlePeople;
	}
	public AccountModel getToPeople() {
		return toPeople;
	}
	public void setToPeople(AccountModel toPeople) {
		this.toPeople = toPeople;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public Date getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

}
