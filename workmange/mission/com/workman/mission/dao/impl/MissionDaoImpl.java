package com.workman.mission.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.commons.po.ResponseModel;
import com.workman.commons.util.ObjectToMapUtils;
import com.workman.mission.constant.MissionConstant;
import com.workman.mission.dao.MissionDao;
import com.workman.mission.model.MissionHandleModel;
import com.workman.mission.model.MissionModel;
import com.workman.mission.persistence.HandleMapper;
import com.workman.mission.persistence.MissionMapper;
import com.workman.mission.persistence.wrapper.MissionWrapper;
import com.workman.sysman.util.PageUtils;
@Service
public class MissionDaoImpl implements MissionDao {
	@Autowired
	private MissionMapper missionMapper;
	@Autowired
	private HandleMapper handleMapper;

	
	@Override
	public MissionModel getMission(int missionId) {
		return  missionMapper.getMission(missionId);
	}

	public List<MissionHandleModel> getMissionHandles(int missionId) {
		return handleMapper.getList(missionId);
	}

	@Override
	public void create(MissionModel mission) {
		missionMapper.create(mission);
	}

	@Override
	public void commitMission(int missionId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", missionId);
		map.put("currDt", new Date());
		missionMapper.commit(map);
	}

	@Override
	public void handle(MissionHandleModel handle) {
		handleMapper.commitHandle(handle.getMissionId());
		handleMapper.add(handle);
	}

	@Override
	public ResponseModel getMissions(int handler,Integer status,
			String type,Date startDate, Date endDate, Integer id,
			int searchType, int page, int size) throws Exception {
		MissionWrapper wrapper = new MissionWrapper();
		wrapper.setHandler(handler);
		wrapper.setStart(PageUtils.getStart(page, size));
		wrapper.setEnd(PageUtils.getEnd(page, size));
		wrapper.setMissionCode(id);
		wrapper.setStatus(status);
		wrapper.setType(type);
		wrapper.setStartTime(startDate);
		wrapper.setEndTime(endDate);
		ResponseModel response = new ResponseModel();
		int count = 0;
		List<MissionModel> missions = null;
		switch (searchType) {
		case MissionConstant.SEARCH_TYPE_SPON:
			count = missionMapper.getSponCount(wrapper);
			missions = missionMapper.getSponMissions(wrapper);;
			break;

		case MissionConstant.SEARCH_TYPE_HANDLED:
			count = missionMapper.getHanCount(wrapper);
			missions = missionMapper.getHanMissions(wrapper);;
			break;
		}
		if(count > 0){
			List<Map<String,Object>> missionList = ObjectToMapUtils.listToMap(missions);
			response.setData(missionList);
		}
		response.setPageCount(PageUtils.getPageCount(count, size));
		response.setRowCount(count);
		return response;
	}
	

	@Override
	public List<Map<String,Object>> getMissions(Integer handlerId) throws Exception {
		List<MissionModel> missions =missionMapper.getPendingMissions(handlerId);
		return ObjectToMapUtils.listToMap(missions);
	}

	@Override
	public void updateHandTime(int missionId) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", missionId);
		map.put("currDt", new Date());
		missionMapper.updateMissionStatu(map);
	}

	@Override
	public MissionHandleModel getMissionHandle(int handleId) {
		return handleMapper.get(handleId);
	}

}
