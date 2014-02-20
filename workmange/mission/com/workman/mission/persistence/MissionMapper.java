package com.workman.mission.persistence;

import java.util.List;

import com.workman.mission.model.MissionModel;
import com.workman.mission.persistence.wrapper.MissionWrapper;

public interface MissionMapper {
	List<MissionModel> getMissions(MissionWrapper wrapper);
	List<MissionModel> getPendingMissions(int handlerId);
	MissionModel getMission(int missionId);
	void create(MissionModel mission);
	void update(MissionModel mission);
	void commitMission(int missionId);
	int getCount(MissionWrapper wrapper);
}
