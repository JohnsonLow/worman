package com.workman.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.workman.uitl.CookieUtil;
import com.workman.uitl.JSONUtils;
import com.workman.uitl.SysLogUtils;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthFilter() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		Cookie[] authCookies = req.getCookies();
		if (authCookies != null) {
			String cookieValue = null;
			for (Cookie ck : authCookies) {
				String name = ck.getName();
				if (CookieUtil.COOKIE_NAME_DOMAIN.equals(name)) {
					cookieValue = CookieUtil.Base64DecodeCookie(ck.getValue());
					break;
				}
			}

			HttpSession session = req.getSession(false);// 当前sesssion不存在返回空
			Map<String, String> userInfo = JSONUtils.getObject(cookieValue,Map.class);
			if (userInfo != null) {
				if (session == null) {
					try {
						CookieUtil.removeCookie(req, res);
					} catch (Exception e) {
						SysLogUtils.error(AuthFilter.class, e,
								"当session==null时，删除cookie失败!");
					}

				} else {

				}

			} else {
				if (session != null) {
					if (session.getAttribute("currentUser") != null)
						session.removeAttribute("currentUser");
				}
			}

		}

		// pass the request along the filter chain
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
