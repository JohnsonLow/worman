package com.workman.mission.constant;

public class MissionConstant {
	
	/**
	 * 任务处理类型：转发
	 */
	public static final int HANDLE_TYPE_TRAN = 1001;
	
	/**
	 * 任务处理类型：完成
	 */
	public static final int HANDLE_TYPE_COMMIT = 1002;
	
	/**
	 * 任务紧急程度：普通
	 */
	public static final int MISSION_TYPE_NORMAL = 2001;
	/**
	 * 任务紧急程度：中等
	 */
	public static final int MISSION_TYPE_MEDIUM = 2002;
	/**
	 * 任务紧急程度：紧急
	 */
	public static final int MISSION_TYPE_URGENCY = 2003;
	
	/**
	 * 查询类型：待处理的任务
	 */
	public static final int SEARCH_TYPE_PENDING = 1;
	
	/**
	 * 查询类型：我发起的任务
	 */
	public static final int SEARCH_TYPE_SPON = 2;
	
	/**
	 * 查询类型：我处理过的任务
	 */
	public static final int SEARCH_TYPE_HANDLED = 3;
}
