package com.workman.operation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operation/*")
public class OperationController {
	@RequestMapping("goPwdModifyPage.do")
	public String goPasswordModifyPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/operation/goPwdModifyPage.do");
		return "operation/pwd_modify";
	}
	
	@RequestMapping("goInfoModifyPage.do")
	public String goInfoModifyPage(HttpServletRequest req){
		req.getSession().setAttribute("intMainFrameSrc", "/operation/goInfoModifyPage.do");
		return "operation/info_modify";
	}

}
