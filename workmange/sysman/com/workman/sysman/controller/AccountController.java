package com.workman.sysman.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workman.commons.po.ResponseModel;
import com.workman.commons.util.SysLogUtils;
import com.workman.permission.util.SessionUtils;
import com.workman.sysman.dao.AccountDao;
import com.workman.sysman.dao.SysmanDao;
import com.workman.sysman.model.AccountModel;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	@Autowired
	private AccountDao dao;
	@Autowired
	private SysmanDao sysDao;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping("goAccountPage.do")
	public String goAccountPage(HttpServletRequest req,ModelMap model){
		SessionUtils.putMainUrlInSession(req, "/account/goAccountPage.do");
		model.addAttribute("depList",sysDao.getDepartmentList());
		model.addAttribute("posList",sysDao.getPositionList());
		return "account/account_list";
	}
	
	@RequestMapping("goAccountInfoPage.do")
	public String goAccountInfoPage(@RequestParam(required=false) Integer id,
			HttpServletRequest req,ModelMap model) throws Exception{
		String url = "/account/goAccountInfoPage.do";
		if(id != null){
			url += "?id=" + id;
		}
		SessionUtils.putMainUrlInSession(req, url);
		if(id != null){
			model.addAttribute("userInfo", mapper.writeValueAsString(dao.getAccount(id)));
		}
		model.addAttribute("posList",sysDao.getPositionList());
		model.addAttribute("depList",sysDao.getDepartmentList());
		return "account/account_info";
	}
	/**
	 * 获取帐号信息
	 * @param posCode
	 * @param depCode
	 * @param name
	 * @param page
	 * @param size
	 * @param req
	 * @return
	 */
	@RequestMapping("getAccountList.do")
	@ResponseBody
	public ResponseModel getAccountList(Integer posCode,
			Integer depCode,String name,
			Integer page,Integer size,HttpServletRequest req){
		if(page == null){
			page = 1;
		}
		if(size == null){
			size = 10;
		}
		ResponseModel result = null;
		try {
			result = dao.getAccountList(posCode, depCode, name, page, size);
		} catch (Exception e) {
			SysLogUtils.error(AccountController.class, e, "查询账号信息出错");
		}
		return result;
	}
	
	/**
	 * 通过部门代码查询帐号信息
	 * @param depCode
	 * @return
	 */
	@RequestMapping("getAccountInfos.do")
	@ResponseBody
	public List<AccountModel> getAccountInfos(Integer depCode,
			HttpServletRequest req){
		List<AccountModel> result = null;
		result = dao.getAccountByDep(depCode,SessionUtils.getUser(req).getId());
		return result;
	}

	
	/**
	 * 添加或更新账户信息
	 * @param type 1：添加  2：更新
	 * @param account
	 * @return
	 */
	@RequestMapping("addOrUpdateAccount.do")
	@ResponseBody
	public int addOrUpdate(@RequestBody AccountModel account){
		int result = 1;
		try {
			if (account.getId() == 0) {
				dao.insertAccount(account);
			} else {
				dao.updateAccount(account);
			}
		} catch (Exception e) {
			SysLogUtils.error(AccountController.class, e, "保存账号信息失败");
			result = -1;
		}
		return result;
	}
	@RequestMapping("delAccount.do")
	@ResponseBody
	public boolean delAccount(int id){
		boolean result = true;
		try {
			dao.delete(id);
		} catch (Exception e) {
			SysLogUtils.error(AccountController.class, e, "删除账号失败");
			result = false;
		}
		return result;
	}
}
