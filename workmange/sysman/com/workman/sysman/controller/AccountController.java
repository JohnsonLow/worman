package com.workman.sysman.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workman.commons.po.ResponseModel;
import com.workman.commons.util.SysLogUtils;
import com.workman.sysman.dao.AccountDao;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	private AccountDao dao;
	
	@RequestMapping("goAccountPage.do")
	public String goAccountPage(HttpServletRequest req,ModelMap model){
		req.getSession().setAttribute("intMainFrameSrc", "/account/goAccountPage.do");
//		model.addAttribute("userList", dao.getAccountList(null, null, null, 1, 10));
		return "account/account_list";
	}
	
	@RequestMapping("goAccountInfoPage.do")
	public String goAccountInfoPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/account/goAccountInfoPage.do");
		return "account/account_info";
	}
	@RequestMapping("getAccountList.do")
	@ResponseBody
	public ResponseModel getAccountList(Integer level,
			String department,String name,
			Integer page,Integer size){
		if(page == null){
			page = 1;
		}
		if(size == null){
			size = 10;
		}
		ResponseModel result = null;
		try {
			result = dao.getAccountList(level, department, name, page, size);
		} catch (Exception e) {
			SysLogUtils.error(AccountController.class, e, "查询账号信息出错");
		}
		return result;
	}

}
