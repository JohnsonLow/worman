package com.workman.commons.po;

import java.io.Serializable;
import java.util.List;

public class ResponseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5899889648273073715L;
	public int count;
	public List<?> data;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	
}
