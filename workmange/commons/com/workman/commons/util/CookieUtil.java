package com.workman.commons.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class CookieUtil {

	public static final String COOKIE_NAME_DOMAIN = "uc_workass";
	public static final String COOKIE_KEY_USERNAME = "username";
	public static final String COOKIE_KEY_NICKNAME = "nickname";
	public static final String SITE_DOMAIN = ".yesway.cn";
	public static final String COOKIE_KEY_PRICE = "price";
	public static final String COOKIE_KEY_PICURL = "picurl";
	public static final String COOKIE_KEY_COMMID = "commid";
	public static final String COOKIE_KEY_COMMNAME = "commname";
	public static final String COOKIE_KEY_SHOPNAME = "shopname";

	/**
	 * cookie 用BASE64编码后保存购物最近浏览信息
	 * 
	 * @param cookieName
	 * @param cookieValue
	 * @param auto
	 * @param res
	 */
	public static void saveShoppingCookie(String cookieName,
			String cookieValue, String auto, HttpServletResponse res) {
		try {

			res.addHeader(
					"P3P",
					"CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
			String save = it.sauronsoftware.base64.Base64.encode(cookieValue,
					"UTF-8");
			String save_utf8 = URLEncoder.encode(save, "utf-8");
			Cookie cookie = new Cookie(cookieName, save_utf8);
			if (auto != null) {
				if ("3".equals(auto)) {
					cookie.setMaxAge(604800);
				}

			}
			res.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			SysLogUtils.error(CookieUtil.class, e, "保存uc_yesway的cookie失败!");

		}
	}

	/**
	 * cookie 用BASE64编码后保存
	 * 
	 * @param cookieName
	 * @param cookieValue
	 * @param auto
	 * @param res
	 */
	public static void saveCookie(String cookieName, String cookieValue,
			String auto, HttpServletResponse res) {
		try {

			res.addHeader(
					"P3P",
					"CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
			String save = it.sauronsoftware.base64.Base64.encode(cookieValue,
					"UTF-8");
			String save_utf8 = URLEncoder.encode(save, "utf-8");
			Cookie cookie = new Cookie(cookieName, save_utf8);
			if (auto != null) {
				if ("1".equals(auto)) {
					cookie.setMaxAge(622080000);
				}

			}
			res.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			SysLogUtils.error(CookieUtil.class, e, "保存uc_yesway的cookie失败!");

		}

	}

	/**
	 * BASE64 解码后取出cookie
	 * 
	 * @param res
	 * @param userName
	 * @param nickName
	 * @param uid
	 * @return
	 */
	public static String Base64DecodeCookie(String cookie) {
		try {
			String name_de_bm = URLDecoder.decode(cookie, "utf-8");
			String cookieValue = it.sauronsoftware.base64.Base64.decode(
					name_de_bm, "UTF-8");

			return cookieValue;
		} catch (UnsupportedEncodingException e) {
			SysLogUtils.error(CookieUtil.class, e, "获取uc_yesway的cookie值失败!");

		}

		return "";
	}

	/**
	 * 根据cookie的Key获取Value
	 * 
	 * @param cookieKey
	 * @param req
	 * @return
	 */
	public static String getCookieValue(String cookieKey, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		String cookieValue = "";
		for (Cookie c : cookies) {
			if (cookieKey.equals(c.getName())) {
				cookieValue = c.getValue();
				if (StringUtils.isNotBlank(cookieValue)) {
					cookieValue = CookieUtil.Base64DecodeCookie(cookieValue);
				}
				break;
			}
		}
		return cookieValue;
	}

	/**
	 * 删除cookie
	 */

	public static boolean removeCookie(HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		try {
			req.getSession().removeAttribute("currentUser");
			req.getSession().removeAttribute("userProductStatus");
			req.getSession().removeAttribute("goURL");
			res.addHeader(
					"P3P",
					"CP=\"CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR\"");
			Cookie[] cookies = req.getCookies();
			for (Cookie ck : cookies) {
				if (ck.getName() != null) {
					if (ck.getName().equals(CookieUtil.COOKIE_NAME_DOMAIN)) {
						ck.setValue(null);
						ck.setMaxAge(0);
						res.addCookie(ck);
						break;
					}
				}
			}

		} catch (Exception e) {
			SysLogUtils.error(CookieUtil.class, e, "删除cookie异常");
			throw e;
		}
		return true;
	}
}
