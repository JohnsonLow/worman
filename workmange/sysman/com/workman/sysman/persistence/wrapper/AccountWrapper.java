package com.workman.sysman.persistence.wrapper;

public class AccountWrapper {
	private Integer authLevel;
	private Integer  depCode;
	private String name;
	private int start;
	private int end;
	public int getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(Integer authLevel) {
		this.authLevel = authLevel;
	}
	public int getDepCode() {
		return depCode;
	}
	public void setDepCode(Integer depCode) {
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

}
