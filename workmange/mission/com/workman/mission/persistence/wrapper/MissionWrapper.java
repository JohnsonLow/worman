package com.workman.mission.persistence.wrapper;

import java.util.Date;

public class MissionWrapper {
	private Integer handler;//处理者id
	private Integer missionCode;//任务id
	private Date startTime;//起始时间
	private Date endTime;//结束时间
	private int start;
	private int end;
	private String type;
	private Integer status;
	
	public Integer getHandler() {
		return handler;
	}
	public void setHandler(Integer handler) {
		this.handler = handler;
	}
	public Integer getMissionCode() {
		return missionCode;
	}
	public void setMissionCode(Integer missionCode) {
		this.missionCode = missionCode;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
