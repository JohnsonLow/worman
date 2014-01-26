package com.workman.operation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workman.commons.util.SysLogUtils;
import com.workman.permission.util.SessionUtils;
import com.workman.sysman.dao.AccountDao;
import com.workman.sysman.dao.SysmanDao;
import com.workman.sysman.model.AccountModel;

@Controller
@RequestMapping("/operation/*")
public class OperationController {
	@Autowired
	private SysmanDao sysDao;
	@Autowired
	private AccountDao accountDao;
	
	@RequestMapping("goPwdModifyPage.do")
	public String goPasswordModifyPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/operation/goPwdModifyPage.do");
		return "operation/pwd_modify";
	}
	
	@RequestMapping("goInfoModifyPage.do")
	public String goInfoModifyPage(HttpServletRequest req,ModelMap model){
		req.getSession().setAttribute("intMainFrameSrc", "/operation/goInfoModifyPage.do");
		model.addAttribute("depList",sysDao.getDepartmentList());
		return "operation/info_modify";
	}
	@RequestMapping("updateInfo.do")
	@ResponseBody
	public boolean updateInfo(String name,String phone,
			int depCode,String weibo,HttpServletRequest req){
		boolean result = true;
		AccountModel curr = SessionUtils.getUser(req);
		try {
			accountDao.updateAccount(name,phone,depCode,weibo,curr.getId());
			SessionUtils.putUserInSession(req, accountDao.getAccount(curr.getId()));
		} catch (Exception e) {
			SysLogUtils.error(OperationController.class, e, "操作账号表失败");
			result = false;
		}
		return result;
	}
	
	@RequestMapping("updatePwd.do")
	@ResponseBody
	public boolean updatePwd(int id,String password,HttpServletRequest req){
		boolean result = true;
		try {
			accountDao.updatePwd(id,password);
			SessionUtils.putUserInSession(req, accountDao.getAccount(id));
		} catch (Exception e) {
			SysLogUtils.error(OperationController.class, e, "操作账号表失败");
			result = false;
		}
		return result;
	}

}
