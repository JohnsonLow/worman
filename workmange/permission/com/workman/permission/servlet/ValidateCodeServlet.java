package com.workman.permission.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.workman.permission.util.ValidateCode;

public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest reqeust,
			HttpServletResponse response) throws ServletException, IOException {
		int w=127,h=55,n=5,l=10;
		String code=reqeust.getParameter("code");
		if(code !=null&&code.equals("enterprise")){
			w=140;h=50;
		}else if(code !=null&&code.equals("codefind")){
			w=96;h=26;
		}else{
			
		}
		//设置响应的类型格式为图片格式
		response.setContentType("image/jpeg");
		//禁止图像缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		HttpSession session = reqeust.getSession();
		
		ValidateCode vCode = new ValidateCode(w,h,n,l);
		session.setAttribute("validation_code", vCode.getCode());
		vCode.write(response.getOutputStream());
	}
}