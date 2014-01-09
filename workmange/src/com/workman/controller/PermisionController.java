package com.workman.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import weibo4j.Oauth;
import weibo4j.model.WeiboException;

@Controller
public class PermisionController {
	@RequestMapping("index")
	public String indexPage(){
		return "index";
	}
	@RequestMapping("login")
	public String goLoginPage(ModelMap model){
		Oauth oauth = new Oauth();
		String auth;
		try {
			auth = oauth.authorize("code", "","");
			model.addAttribute("weiboUrl",auth);
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return "login";
	}
}
