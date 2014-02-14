package com.workman.mission.persistence;

import java.util.List;

import com.workman.mission.model.MissionModel;
import com.workman.mission.persistence.wrapper.MissionWrapper;

public interface MissionMapper {
	List<MissionModel> getMissions(MissionWrapper wrapper);
	MissionModel getMission(int missionId);
	int create(MissionModel mission);
	void update(MissionModel mission);
	void commitMission(int missionId);
}
