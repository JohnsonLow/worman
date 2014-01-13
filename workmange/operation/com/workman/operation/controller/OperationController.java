package com.workman.operation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operation/*")
public class OperationController {
	@RequestMapping("goPwdModifyPage.do")
	public String goPasswordModifyPage(){
		return "operation/pwd_modify";
	}
	
	@RequestMapping("goInfoModifyPage.do")
	public String goInfoModifyPage(){
		return "operation/info_modify";
	}

}
