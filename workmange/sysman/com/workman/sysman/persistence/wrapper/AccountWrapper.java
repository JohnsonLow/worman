package com.workman.sysman.persistence.wrapper;

public class AccountWrapper {
	private int authLevel;
	private int  depCode;
	private String name;
	private int start;
	private int end;
	private int currId;
	public int getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(int authLevel) {
		this.authLevel = authLevel;
	}
	public int getDepCode() {
		return depCode;
	}
	public void setDepCode(int depCode) {
		this.depCode = depCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getCurrId() {
		return currId;
	}
	public void setCurrId(int currId) {
		this.currId = currId;
	}

}
