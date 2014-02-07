package com.workman.sysman.persistence.wrapper;

public class AccountWrapper {
	private int posCode;
	private int depCode;
	private String name;
	private int start;
	private int end;
	
	public int getPosCode() {
		return posCode;
	}
	public void setPosCode(int posCode) {
		this.posCode = posCode;
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

}
