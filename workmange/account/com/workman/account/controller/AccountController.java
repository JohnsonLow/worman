package com.workman.account.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	@RequestMapping("goAccountPage.do")
	public String goAccountPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/account/goAccountPage.do");
		return "account/account_list";
	}
	
	@RequestMapping("goAccountInfoPage.do")
	public String goAccountInfoPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/account/goAccountInfoPage.do");
		return "account/account_info";
	}

}
