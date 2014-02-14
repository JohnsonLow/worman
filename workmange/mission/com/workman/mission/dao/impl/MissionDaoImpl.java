package com.workman.mission.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.mission.dao.MissionDao;
import com.workman.mission.model.MissionHandleModel;
import com.workman.mission.model.MissionModel;
import com.workman.mission.persistence.HandleMapper;
import com.workman.mission.persistence.MissionMapper;
import com.workman.mission.persistence.wrapper.MissionWrapper;
@Service
public class MissionDaoImpl implements MissionDao {
	@Autowired
	private MissionMapper missionMapper;
	@Autowired
	private HandleMapper handleMapper;
	@Override
	public List<MissionModel> getMissions(MissionWrapper wrapper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MissionModel getMission(int missionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(MissionModel mission) {
		return missionMapper.create(mission);
	}

	@Override
	public void commitMission(int missionId) {
		
	}

	@Override
	public void handle(MissionHandleModel handel) {
		
		
	}

}
