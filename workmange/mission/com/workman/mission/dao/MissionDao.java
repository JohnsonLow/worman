package com.workman.mission.dao;

import java.util.List;

import com.workman.mission.model.MissionHandleModel;
import com.workman.mission.model.MissionModel;
import com.workman.mission.persistence.wrapper.MissionWrapper;

public interface MissionDao {
	/**
	 * 获取任务列表
	 * @param wrapper
	 * @return
	 */
	List<MissionModel> getMissions(MissionWrapper wrapper);
	/**
	 * 根据id获取任务的相关信息
	 * @param missionId
	 * @return
	 */
	MissionModel getMission(int missionId);
	/**
	 * 创建人物
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
}
