package com.workman.mission.dao;

import java.util.List;

import com.workman.mission.model.MissionModel;
import com.workman.mission.persistence.wrapper.MissionWrapper;

public interface MissionDao {
	List<MissionModel> getMissions(MissionWrapper wrapper);
	MissionModel getMission(int missionId);
	void create(MissionModel mission);
	void update(MissionModel mission);
	void commitMission(int missionId);
}
