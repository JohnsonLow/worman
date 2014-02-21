package com.workman.mission.persistence;

import java.util.List;

import com.workman.mission.model.MissionModel;
import com.workman.mission.persistence.wrapper.MissionWrapper;

public interface MissionMapper {
	int getSponCount(MissionWrapper wrapper);
	List<MissionModel> getSponMissions(MissionWrapper wrapper);
	
	int getHanCount (MissionWrapper wrapper);
	List<MissionModel> getHanMissions(MissionWrapper wrapper);
	
	List<MissionModel> getPendingMissions(int handlerId);
	
	MissionModel getMission(int missionId);
	
	void create(MissionModel mission);
	
	void update(MissionModel mission);
	
	void commitMission(int missionId);
}
