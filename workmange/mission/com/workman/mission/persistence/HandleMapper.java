package com.workman.mission.persistence;

import java.util.List;

import com.workman.mission.model.MissionHandleModel;

public interface HandleMapper {
	
	void add(MissionHandleModel handle);
	
	List<MissionHandleModel> getList(int missionId);

	void commitHandle(int missionId);

	MissionHandleModel get(int id);

}
