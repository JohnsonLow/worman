package com.workman.mission.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workman.permission.util.SessionUtils;

@Controller
@RequestMapping("/mission/*")
public class MissionController {
	@RequestMapping("goAddMissionPage.do")
	public String goAddMissionPage(HttpServletRequest req){
		SessionUtils.putMainUrlInSession(req, "/mission/goAddMissionPage.do");
		return "mission/add_mission";
	}
	
}
