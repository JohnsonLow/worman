package com.workman.mission.model;

import java.io.Serializable;
import java.util.Date;

public class MissionModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6508467153044598589L;
	private int id;
	private String title;
	private String content;
	private int sponsorId;
	private String sponsorName;
	private String sponsorDep;
	private int handlerId;
	private String handlerName;
	private String handlerDep;
	private Date createTime;
	private Date handleTime;
	private Date commitTime;
	private String type;
	private int status;
	private String notes;
	
	public int getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}
	public String getSponsorName() {
		return sponsorName;
	}
	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}
	public String getSponsorDep() {
		return sponsorDep;
	}
	public void setSponsorDep(String sponsorDep) {
		this.sponsorDep = sponsorDep;
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
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
