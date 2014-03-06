package com.workman.mission.controller;

import java.util.Date;
import java.util.HashMap;
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

import com.workman.commons.util.DateTimeUtils;
import com.workman.commons.util.JSONUtils;
import com.workman.commons.util.ObjectToMapUtils;
import com.workman.commons.util.StringUtility;
import com.workman.commons.util.SysLogUtils;
import com.workman.mission.constant.MissionConstant;
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
	@RequestMapping("goMissionInfoPage.do")
	public String goMissionInfoPage(int id,
			HttpServletRequest req,ModelMap model){
		SessionUtils.putMainUrlInSession(req, "/mission/goMissionInfoPage.do?id="+id);
		try {
			MissionModel mission = mDao.getMission(id);
			model.addAttribute("missionInfo", ObjectToMapUtils.toMap(mission));
			List<MissionHandleModel> handleInfo = mDao.getMissionHandles(id);
			if(handleInfo != null && handleInfo.size()>0){
				model.addAttribute("handleInfo",JSONUtils.getJSONString(ObjectToMapUtils.listToMap(handleInfo)));
			}
		} catch (Exception e) {
			SysLogUtils.error(MissionController.class, e, "查询任务信息出错");
		}
		return "mission/mission_info";
	}
	@RequestMapping("getMission.do")
	@ResponseBody
	public Map<String,Object> getMission(int id){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MissionModel mission = mDao.getMission(id);
			result.put("missionInfo", ObjectToMapUtils.toMap(mission));
			List<MissionHandleModel> handleInfo = mDao.getMissionHandles(id);
			if(handleInfo != null && handleInfo.size()>0){
				result.put("handleInfo",ObjectToMapUtils.listToMap(handleInfo));
			}else{
				result.put("handleInfo","{}");
			}
		} catch (Exception e) {
			SysLogUtils.error(MissionController.class, e, "查询任务信息出错");
		}
		return result;
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
	public String goMissionsPage(int searchType,HttpServletRequest req,ModelMap model){
		SessionUtils.putMainUrlInSession(req, "/mission/goMissionListPage.do?searchType="+searchType);
		model.addAttribute("searchType", searchType);
		return "mission/mission_list";
	}
	/**
	 * 
	 * @param handler 要查询者的id 
	 * @param searchType 可选值为1 2 3 
	 * @see MissionDao#getMissions(java.lang.Integer)
	 * @see MissionDao#getMissions(int, Integer, String, Date, Date, Integer, int, int, int)
	 * @return
	 */
	@RequestMapping("getMissionList.do")
	@ResponseBody
	public Object getMissionList(Integer handler,int searchType,
			@RequestParam(required=false)Integer status,
			@RequestParam(required=false)String type,
			@RequestParam(required=false) String startTime,
			@RequestParam(required=false) String endTime,
			@RequestParam(required=false) Integer id,
			@RequestParam(required=false)Integer page,
			@RequestParam(required=false)Integer size){
			Date startDate = null;
			Date endDate = null;
			Object result = null;
			try {
				if (searchType == MissionConstant.SEARCH_TYPE_PENDING) {
					result = mDao.getMissions(handler);
				}else{
					if(StringUtility.isNotBlank(startTime)){
						startTime += " 00:00:00";
						startDate = DateTimeUtils.parse(startTime);
					}
					if(StringUtility.isBlank(endTime)){
						endDate = new Date();
					}else{
						endDate = DateTimeUtils.parse(endTime + " 23:59:59");
					}
					if(StringUtility.isBlank(type)){
						type = null;
					}
					result = mDao.getMissions(handler,status,type,
							startDate,endDate,id,searchType,page,size);
				}
			} catch (Exception e) {
				SysLogUtils.error(MissionController.class, e, "查询任务列表出错");
			}
		return result;
	}
	@RequestMapping("handleMission.do")
	@ResponseBody
	public Integer handleMission(@RequestBody MissionHandleModel handleInfo){
		int type = handleInfo.getHandleType();
		Date d = new Date();
		handleInfo.setAddTime(d);
		int missionId = handleInfo.getMissionId();
		if(handleInfo.getHandleTime() == null){
			mDao.updateHandTime(handleInfo.getMissionId());
		}
		try {
			switch (type) {
			case MissionConstant.HANDLE_TYPE_TRAN:
				handleInfo.setStatus(0);
				mDao.handle(handleInfo);
				break;
			case MissionConstant.HANDLE_TYPE_COMMIT:
				handleInfo.setStatus(1);
				handleInfo.setHandleTime(d);
				mDao.commitMission(missionId);
				mDao.handle(handleInfo);
				break;
			}
				
			return handleInfo.getId();
		} catch (Exception e) {
			SysLogUtils.error(MissionController.class, e, "处理任务失败");
			return -1;
		}
	}
}
