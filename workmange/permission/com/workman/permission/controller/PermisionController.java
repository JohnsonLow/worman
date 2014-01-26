package com.workman.permission.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;









import com.workman.commons.util.StringUtility;
import com.workman.commons.util.SysLogUtils;
import com.workman.permission.util.SessionUtils;
import com.workman.sysman.dao.AccountDao;
import com.workman.sysman.model.AccountModel;

import weibo4j.Oauth;
import weibo4j.model.WeiboException;

@Controller
@RequestMapping("/internal/*")
public class PermisionController {
	@Autowired
	private AccountDao accountDao;
	@RequestMapping("index.do")
	public String indexPage(String code,HttpServletRequest req){
		try {
			//TODO 绑定微博授权信息
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:login.do";
		}
		return "internal/index";
	}
	@RequestMapping("login.do")
	public String goLoginPage(ModelMap model){
		String auth;
		try {
			Oauth oauth = new Oauth();
			auth = oauth.authorize("code", "","");
			model.addAttribute("weiboUrl",auth);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return "internal/login";
	}
	@RequestMapping("sysLoginValidator.do")
	@ResponseBody
	public String sysLogin(@RequestParam String userName,
			@RequestParam String passWord,
			@RequestParam String verificationCode,
			HttpServletRequest req, HttpServletResponse res){
		String data = "";
		HttpSession session = req.getSession();
		if (!verificationCode.toUpperCase().equals(
				session.getAttribute("validation_code"))) {
			data = "-1";// 验证码错误
		}else{
			try {
				AccountModel account = accountDao.getAccount(userName);
				if(account == null){
					data = "-2";
				}else{
					if(account.getPassword().equals(passWord)){
						data = "1";
						SessionUtils.putUserInSession(req, account);
					}else{
						data = "-3";
					}
				}
			} catch (Exception e) {
				SysLogUtils.error(PermisionController.class, e, "查询账号信息出错");
			}
		}
		return data;
	}
	@RequestMapping("left.do")
	public String goLeftPage(){
		return "internal/left";
	}
	@RequestMapping("bottom.do")
	public String goBottomPage(){
		return "internal/bottom";
	}
	@RequestMapping("top.do")
	public String goTopPage(){
		return "internal/top";
	}
	@RequestMapping("main.do")
	public String goMainPage(HttpServletRequest req){
		String url = SessionUtils.getMainUrl(req);
		if(StringUtility.isNotBlank(url)){
			return "redirect:"+url;
		}
		return "internal/welcome";
	}
	@RequestMapping("logout.do")
	@ResponseBody
	public void logout(HttpServletRequest req){
		SessionUtils.destroyAtt(req);
	};
	
}
