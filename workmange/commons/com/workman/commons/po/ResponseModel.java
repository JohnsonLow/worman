package com.workman.commons.po;

import java.io.Serializable;
import java.util.List;

public class ResponseModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5899889648273073715L;
	private int rowCount;
	private int pageCount;
	private List<?> data;
	
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	
}
