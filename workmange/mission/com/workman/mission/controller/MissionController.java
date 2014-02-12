package com.workman.mission.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workman.mission.dao.MissionDao;
import com.workman.mission.model.MissionModel;
import com.workman.permission.util.SessionUtils;

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
	@RequestMapping("createMission")
	public String createMission(MissionModel mission){
		mDao.create(mission);//创建任务
		//发送私信
		return "1";
	}
}
