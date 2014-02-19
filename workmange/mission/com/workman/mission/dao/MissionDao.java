package com.workman.mission.dao;

import java.util.Date;
import java.util.Map;

import com.workman.commons.po.ResponseModel;
import com.workman.mission.model.MissionHandleModel;
import com.workman.mission.model.MissionModel;

public interface MissionDao {
	/**
	 * 根据id获取任务的相关信息
	 * @param missionId
	 * @return
	 */
	Map<String,Object> getMission(int missionId);
	/**
	 * 创建任务
	 * @param mission
	 */
	void create(MissionModel mission);
	/**
	 * 处理任务
	 * @param handel
	 */
	void handle(MissionHandleModel handel);
	/**
	 * 完成任务
	 * @param missionId
	 */
	void commitMission(int missionId);
	
	/**
	 * 获取任务列表
	 * @param endDate 
	 * @param startDate 
	 * @param wrapper
	 * @return
	 */

	ResponseModel getMissions(Integer sponsor, Integer handler,Integer status, String type,
			Date startDate, Date endDate, Integer id, int page, int size);
}
