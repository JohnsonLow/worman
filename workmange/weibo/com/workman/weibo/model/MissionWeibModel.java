package com.workman.weibo.model;

/**
 * 创建或处理任务发送的微博内容
 * @author lyw
 *
 */
public class MissionWeibModel {
	private int missionId;
	private int handleId;
	private String weiboId;
	public int getMissionId() {
		return missionId;
	}
	public void setMissionId(int missionId) {
		this.missionId = missionId;
	}
	public int getHandleId() {
		return handleId;
	}
	public void setHandleId(int handleId) {
		this.handleId = handleId;
	}
	public String getWeiboId() {
		return weiboId;
	}
	public void setWeiboId(String weiboId) {
		this.weiboId = weiboId;
	}

}
