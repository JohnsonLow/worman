package com.workman.sysman.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workman.sysman.model.AuthModel;
import com.workman.sysman.persistence.AuthMapper;
/**
 * 系统管理
 *
 */
@Controller
@RequestMapping("/sysMan/*")
public class SysmanController {
	@Autowired
	private AuthMapper authMapper;
	@RequestMapping("goAuthPage.do")
	public String goAuthPage(HttpServletRequest req,
			ModelMap model){
		req.getSession().setAttribute("intMainFrameSrc", "/sysMan/goAuthPage.do");
		return "sysman/auth_list";
	}
	@RequestMapping("getAuthList.do")
	@ResponseBody
	public List<AuthModel> getAuthList(){
		return authMapper.getAuthList();
	}
	@RequestMapping("goAuthInfoPage.do")
	public String goAuthInfoPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/sysMan/goAuthInfoPage.do");
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
