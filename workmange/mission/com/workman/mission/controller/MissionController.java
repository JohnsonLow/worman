package com.workman.mission.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workman.commons.util.SysLogUtils;
import com.workman.mission.dao.MissionDao;
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
	public String goMissionInfoPage(@RequestParam(required=false) Integer id,
			HttpServletRequest req,ModelMap model){
		SessionUtils.putMainUrlInSession(req, "/mission/goAddMissionPage.do");
		if(id != null){
			try {
				MissionModel mission = mDao.getMission(id);
				model.addAttribute("missionInfo", mission);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			code = mDao.create(mission);
		} catch (Exception e) {
			SysLogUtils.error(getClass(), e, "创建任务失败");
			code = -1;
		}
		return code;
	}
}
