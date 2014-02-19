package com.workman.mission.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workman.commons.po.ResponseModel;
import com.workman.commons.util.DateTimeUtils;
import com.workman.commons.util.JSONUtils;
import com.workman.commons.util.ObjectToMapUtils;
import com.workman.commons.util.StringUtility;
import com.workman.commons.util.SysLogUtils;
import com.workman.mission.dao.MissionDao;
import com.workman.mission.model.MissionHandleModel;
import com.workman.mission.model.MissionModel;
import com.workman.permission.util.SessionUtils;
import com.workman.sysman.model.AccountModel;

@Controller
@RequestMapping("/mission/*")
public class MissionController {
	@Autowired
	private MissionDao mDao;
	@RequestMapping("goAddMissionPage.do")
	public String goAddMissionPage(HttpServletRequest req,ModelMap model){
		SessionUtils.putMainUrlInSession(req, "/mission/goAddMissionPage.do");
		return "mission/add_mission";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("goMissionInfoPage.do")
	public String goMissionInfoPage(int id,
			HttpServletRequest req,ModelMap model){
		SessionUtils.putMainUrlInSession(req, "/mission/goMissionInfoPage.do?id="+id);
		try {
			Map<String,Object> result = mDao.getMission(id);
			model.addAttribute("missionInfo", ObjectToMapUtils.toMap(result.get("missionInfo")));
			Object handleInfo = result.get("handleInfo");
			if(handleInfo != null){
				List<MissionHandleModel> handles = (List<MissionHandleModel>)handleInfo;
				if(handles.size()>0){
					List<Object> handleMaps = new ArrayList<Object>();
					for(int i=0,len=handles.size();i<len;i++){
						handleMaps.add( ObjectToMapUtils.toMap(handles.get(i)));
					}
					model.addAttribute("handleInfo",JSONUtils.getJSONString(handleMaps));
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mission/mission_info";
	}
	@RequestMapping("createMission")
	@ResponseBody
	public int createMission(@RequestBody MissionModel mission,HttpServletRequest req){
		mission.setCreateTime(new Date());
		int code = 0;
		try {
			AccountModel curr = SessionUtils.getUser(req);
			mission.setStatus(1);
			mission.setSponsorId(curr.getId());
			mission.setSponsorName(curr.getName());
			mission.setSponsorDep(curr.getDepartment().getName());
			mDao.create(mission);
			code = mission.getId();
		} catch (Exception e) {
			SysLogUtils.error(getClass(), e, "创建任务失败");
			code = -1;
		}
		return code;
	}
	@RequestMapping("goMissionListPage.do")
	public String goMissionsPage(HttpServletRequest req,ModelMap model){
		SessionUtils.putMainUrlInSession(req, "/mission/goMissionListPage.do");
		return "mission/mission_list";
	}
	
	@RequestMapping("getMissionList.do")
	@ResponseBody
	public ResponseModel getMissionList(@RequestParam(required=false)Integer sponsor,
			@RequestParam(required=false)Integer handler,
			@RequestParam(required=false)Integer status,
			@RequestParam(required=false)String type,
			@RequestParam(required=false) String startTime,
			@RequestParam(required=false) String endTime,
			@RequestParam(required=false) Integer id,
			int page,int size){
		if(sponsor == null && handler == null){
			return null;
		}else{
			Date startDate = null;
			Date endDate = null;
			if(StringUtility.isNotBlank(startTime)){
				startTime += " 00:00:00";
				startDate = DateTimeUtils.parse(startTime);
			}
			if(StringUtility.isBlank(endTime)){
				endDate = new Date();
			}else{
				endDate = DateTimeUtils.parse(endTime);
			}
			ResponseModel result = mDao.getMissions(sponsor,handler,status,type,
					startDate,endDate,id,page,size);
			return result;
		}
	}
}
