package com.workman.permission.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.workman.commons.util.StringUtility;
import com.workman.permission.util.SessionUtils;

public class AuthSessionFilter implements Filter {
	private String pageUrl; 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;			
		String contentURL = req.getContextPath();
		String currentURL = req.getRequestURI(); 
		String shortURL = currentURL.replace(contentURL, "");
		String ajaxHeader= req.getHeader("x-requested-with");
		if(SessionUtils.getUser(req) == null){
			if(StringUtility.isNotBlank(ajaxHeader)){			
				if(pageUrl.indexOf(shortURL)>-1){
					chain.doFilter(request, response);
				}else{
					res.setCharacterEncoding("utf-8");
					res.setContentType("text/html; charset=UTF-8");
					res.getWriter().print("-401");	
					return ;
				}
			}else{			
				if(pageUrl.indexOf(shortURL)>-1){
					chain.doFilter(request, response);
				}else{
					res.setCharacterEncoding("utf-8");
					res.setContentType("text/html; charset=UTF-8");
					res.getWriter().print("<script type=\"text/javascript\">alert('您还未登录或登录已过期,请重新登录!');window.parent.location.href='../internal/login.do';</script>");	
					
					return;
				}
			}
			
			
		}else{
			chain.doFilter(request, response);
		}	

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		pageUrl = arg0.getInitParameter("validityUrl");
		
	}

}
