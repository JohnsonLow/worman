package com.workman.account.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/*")
public class AuthController {
	@RequestMapping("goAuthPage.do")
	public String goAuthPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/auth/goAuthPage.do");
		return "auth/auth_list";
	}
	@RequestMapping("goAuthInfoPage.do")
	public String goAuthInfoPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/auth/goAuthInfoPage.do");
		return "auth/auth_list";
	}

}
