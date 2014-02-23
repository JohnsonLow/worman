package com.workman.mission.persistence;

import java.util.List;
import java.util.Map;

import com.workman.mission.model.MissionModel;
import com.workman.mission.persistence.wrapper.MissionWrapper;

public interface MissionMapper {
	/**
	 * 我发起的任务的条数
	 * @param wrapper
	 * @return
	 */
	int getSponCount(MissionWrapper wrapper);
	List<MissionModel> getSponMissions(MissionWrapper wrapper);
	
	int getHanCount (MissionWrapper wrapper);
	
	List<MissionModel> getHanMissions(MissionWrapper wrapper);
	
	List<MissionModel> getPendingMissions(int handlerId);
	
	MissionModel getMission(int missionId);
	
	void create(MissionModel mission);
	
	void commit(Map<String,Object> map);
	void updateMissionStatu(Map<String,Object> map);
}
