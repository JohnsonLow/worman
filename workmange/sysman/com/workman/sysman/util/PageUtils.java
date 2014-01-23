package com.workman.sysman.util;

public class PageUtils {
	
	public static int getPageCount(int rowCount ,int pageSize){
		int pageCount = rowCount/pageSize;
		if(rowCount % pageSize != 0){
			pageCount ++;
		}
		return pageCount;
	}

	public static int getStart(int page, int size) {
		
		return (page-1) * size;
	}
	public static int getEnd(int page, int size) {
		
		return page * size;
	}

}
