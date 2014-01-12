package com.workman.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import weibo4j.Account;
import weibo4j.Oauth;
import weibo4j.Users;
import weibo4j.http.AccessToken;
import weibo4j.model.User;
import weibo4j.model.WeiboException;
import weibo4j.org.json.JSONArray;
import weibo4j.org.json.JSONObject;

@Controller
public class PermisionController {
	@RequestMapping("auth.do")
	public String indexPage(String code,HttpServletRequest req){
		try {
			//TODO 绑定微博授权信息
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:login.do";
		}
		return "main";
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
		return "login";
	}
	@RequestMapping("sysLogin.do")
	@ResponseBody
	public String sysLogin(String name,String password){
		System.out.println(name);
		System.out.println(password);
		return "1";
	}
}
