package com.workman.mission.persistence.wrapper;

import java.util.Date;

public class MissionWrapper {
	private int sponsorId;//发布者id
	private int handlerId;//处理者id
	private int missionCode;//任务id
	private Date startTime;//起始时间
	private Date endTime;//结束时间
	private int start;
	private int end;
	
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getMissionCode() {
		return missionCode;
	}
	public void setMissionCode(int missionCode) {
		this.missionCode = missionCode;
	}
	public int getSponsorId() {
		return sponsorId;
	}
	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}
	public int getHandlerId() {
		return handlerId;
	}
	public void setHandlerId(int handlerId) {
		this.handlerId = handlerId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
