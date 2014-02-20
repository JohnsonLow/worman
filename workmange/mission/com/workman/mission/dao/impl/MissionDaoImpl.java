package com.workman.mission.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workman.commons.po.ResponseModel;
import com.workman.commons.util.ObjectToMapUtils;
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
	public Map<String,Object> getMission(int missionId) {
		// TODO Auto-generated method stub
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("missionInfo", missionMapper.getMission(missionId));
		result.put("handleInfo", handleMapper.getList(missionId));
		return result;
	}

	@Override
	public void create(MissionModel mission) {
		missionMapper.create(mission);
	}

	@Override
	public void commitMission(int missionId) {
		
	}

	@Override
	public void handle(MissionHandleModel handel) {
		
		
	}

	@Override
	public ResponseModel getMissions(Integer sponsor, Integer handler,Integer status,
			String type,Date startDate, Date endDate, Integer id, int page, int size) throws Exception {
		MissionWrapper wrapper = new MissionWrapper();
		wrapper.setSponsorId(sponsor);
		wrapper.setHandlerId(handler);
		wrapper.setStart(PageUtils.getStart(page, size));
		wrapper.setEnd(PageUtils.getEnd(page, size));
		wrapper.setMissionCode(id);
		wrapper.setStatus(status);
		wrapper.setType(type);
		wrapper.setStartTime(startDate);
		wrapper.setEndTime(endDate);
		ResponseModel response = new ResponseModel();
		int count = missionMapper.getCount(wrapper);
		if(count > 0){
			List<MissionModel> missions = missionMapper.getMissions(wrapper);
			List<Object> missionList = new ArrayList<Object>();
			for(int i=0,len=missions.size();i<len;i++){
				missionList.add(ObjectToMapUtils.toMap(missions.get(i)));
			}
			response.setData(missionList);
		}
		response.setPageCount(PageUtils.getPageCount(count, size));
		response.setRowCount(count);
		return response;
	}
	
	@Override
	public List<MissionModel> getMissions(Integer handlerId) {
		return missionMapper.getPendingMissions(handlerId);
	}
	

}
