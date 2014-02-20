package com.workman.mission.model;

import java.io.Serializable;
import java.util.Date;

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
	private int handlerId;
	private String handlerName;
	private String handlerDep;
	private int toId;
	private String toName;
	private String toDep;
	private Date addTime;
	private Date handleTime;
	private int handleType;
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getHandleType() {
		return handleType;
	}
	public void setHandleType(int handleType) {
		this.handleType = handleType;
	}
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
	
	public int getHandlerId() {
		return handlerId;
	}
	public void setHandlerId(int handlerId) {
		this.handlerId = handlerId;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	public String getHandlerDep() {
		return handlerDep;
	}
	public void setHandlerDep(String handlerDep) {
		this.handlerDep = handlerDep;
	}
	public int getToId() {
		return toId;
	}
	public void setToId(int toId) {
		this.toId = toId;
	}
	public String getToName() {
		return toName;
	}
	public void setToName(String toName) {
		this.toName = toName;
	}
	public String getToDep() {
		return toDep;
	}
	public void setToDep(String toDep) {
		this.toDep = toDep;
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
