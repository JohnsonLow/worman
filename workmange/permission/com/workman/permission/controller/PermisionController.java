package com.workman.permission.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import weibo4j.Oauth;
import weibo4j.model.WeiboException;

@Controller
@RequestMapping("/internal/*")
public class PermisionController {
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
			//TODO 权限认证
			data = "1";
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
	public String goMainPage(){
		return "internal/welcome";
	}
	@RequestMapping("logout.do")
	@ResponseBody
	public void logout(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.removeAttribute("intUser");
		session.removeAttribute("intMainFrameSrc");
	};
	
}
