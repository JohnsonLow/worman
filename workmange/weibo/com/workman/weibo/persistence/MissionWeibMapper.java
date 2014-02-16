package com.workman.weibo.persistence;

import com.workman.weibo.model.MissionWeibModel;

public interface MissionWeibMapper {
	
	void insert(MissionWeibModel weibo);
	
	void delete(int missionId, Integer handleId);
	
	MissionWeibModel get(int missionId, Integer handleId);

}
