package com.workman.sysman.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.workman.commons.util.SysLogUtils;
import com.workman.sysman.dao.SysmanDao;
import com.workman.sysman.model.DepartmentModel;
import com.workman.sysman.model.PositionModel;

/**
 * 系统管理
 *
 */
@Controller
@RequestMapping("/sysMan/*")
public class SysmanController {
	@Autowired
	private SysmanDao sysDao;
	/*@RequestMapping("goAuthPage.do")
	public String goAuthPage(HttpServletRequest req,
			ModelMap model){
		req.getSession().setAttribute("intMainFrameSrc", "/sysMan/goAuthPage.do");
		return "sysman/auth_list";
	}
	@RequestMapping("getAuthList.do")
	@ResponseBody
	public List<AuthModel> getAuthList(HttpServletRequest req){
		List<AuthModel> result = null;
		try {
			result = sysDao.getAuthList(SessionUtils.getUser(req).getAuth().getLevel());
		} catch (Exception e) {
			SysLogUtils.error(SysmanController.class, e, "查询权限信息出错");
		}
		return result;
	}
	@RequestMapping("addOrUpdateAuth.do")
	@ResponseBody
	public boolean insertAuth(@RequestBody AuthModel auth){
		try {
			sysDao.addOrUpdateAuth(auth);
			return true;
		} catch (Exception e) {
			SysLogUtils.error(SysmanController.class, e, "更改权限信息出错");
			return false;
		}
	}
	@RequestMapping("delAuth.do")
	@ResponseBody
	public boolean delAuth(@RequestBody String[] ids){
		try {
			sysDao.deleteAuth(ids);
			return true;
		} catch (Exception e) {
			SysLogUtils.error(SysmanController.class, e, "删除权限信息出错");
			return false;
		}
	}*/
	
	@RequestMapping("goDepartmentPage.do")
	public String goDepartmentPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/sysMan/goDepartmentPage.do");
		return "sysman/department";
	}
	@RequestMapping("getDepartmentList.do")
	@ResponseBody
	public List<DepartmentModel> getDepartmentList(){
		List<DepartmentModel> result = null;
		try {
			result = sysDao.getDepartmentList();
		} catch (Exception e) {
			SysLogUtils.error(SysmanController.class, e, "查询部门信息出错");
		}
		return result;
	}
	@RequestMapping("addOrUpdateDep.do")
	@ResponseBody
	public boolean insertDep(@RequestBody DepartmentModel dep){
		try {
			sysDao.addOrUpdateDep(dep);
			return true;
		} catch (Exception e) {
			SysLogUtils.error(SysmanController.class, e, "更改部门信息出错");
			return false;
		}
	}
	@RequestMapping("delDep.do")
	@ResponseBody
	public boolean delDep(@RequestBody String[] codes){
		try {
			sysDao.deleteDep(codes);
			return true;
		} catch (Exception e) {
			SysLogUtils.error(SysmanController.class, e, "删除部门信息出错");
			return false;
		}
	}
	@RequestMapping("goPositionPage.do")
	public String goPositionPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/sysMan/goPositionPage.do");
		return "sysman/position";
	}
	@RequestMapping("getPositionList.do")
	@ResponseBody
	public List<PositionModel> getPositionList(){
		List<PositionModel> result = null;
		try {
			result = sysDao.getPositionList();
		} catch (Exception e) {
			SysLogUtils.error(SysmanController.class, e, "查询职位信息出错");
		}
		return result;
	}
	@RequestMapping("addOrUpdatePos.do")
	@ResponseBody
	public boolean addOrUpdatePos(@RequestBody PositionModel pos){
		try {
			sysDao.addOrUpdatePos(pos);
			return true;
		} catch (Exception e) {
			SysLogUtils.error(SysmanController.class, e, "更改职位信息出错");
			return false;
		}
	}
	@RequestMapping("delPos.do")
	@ResponseBody
	public boolean delPos(@RequestBody String[] codes){
		try {
			sysDao.deletePos(codes);
			return true;
		} catch (Exception e) {
			SysLogUtils.error(SysmanController.class, e, "删除职位信息出错");
			return false;
		}
	}

}
