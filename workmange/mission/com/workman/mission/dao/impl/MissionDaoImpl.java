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
			List<Object> missionList = parsetDate(missions);
			response.setData(missionList);
		}
		response.setPageCount(PageUtils.getPageCount(count, size));
		response.setRowCount(count);
		return response;
	}
	
	private List<Object> parsetDate(List<MissionModel> missions) throws Exception {
		List<Object> missionList = new ArrayList<Object>();
		for(int i=0,len=missions.size();i<len;i++){
			missionList.add(ObjectToMapUtils.toMap(missions.get(i)));
		}
		return missionList;
	}

	@Override
	public List<Object> getMissions(Integer handlerId) throws Exception {
		List<MissionModel> missions =missionMapper.getPendingMissions(handlerId);
		return parsetDate(missions);
	}
	

}
