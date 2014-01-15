package com.workman.sysman.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.workman.sysman.dao.AuthDao;
import com.workman.sysman.persistence.AuthMapper;
/**
 * 系统管理
 *
 */
@Controller
@RequestMapping("/sysMan/*")
public class SysmanController {
	@Autowired
	private AuthMapper authDao;
	@RequestMapping("goAuthPage.do")
	public String goAuthPage(HttpServletRequest req,
			ModelMap model){
		req.getSession().setAttribute("intMainFrameSrc", "/auth/goAuthPage.do");
		model.addAttribute("authList", authDao.getAuthList());
		return "sysman/auth_list";
	}
	@RequestMapping("goAuthInfoPage.do")
	public String goAuthInfoPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/auth/goAuthInfoPage.do");
		return "sysman/auth_list";
	}
	
	@RequestMapping("goDepartmentPage.do")
	public String goDepartmentPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/sysMan/goDepartmentPage.do");
		return "sysman/department";
	}
	@RequestMapping("goPositionPage.do")
	public String goPositionPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/sysMan/goDepartmentPage.do");
		return "sysman/position";
	}

}
