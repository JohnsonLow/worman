package com.workman.permission.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.workman.sysman.model.AccountModel;
import com.workman.weibo.model.AccessTokenModel;
/**
 * 对session进行相关操作
 * 当前登录用户的存取
 * 当前访问URL的存取
 * @author lyw
 *
 */
public class SessionUtils {
	
	public static final String KEY_USER = "currUser";
	
	public static final String KEY_MAIN_FRAME = "intMainFrameSrc";
	public static final String KEY_TOKEN = "currAccessToken";
	
	public static void putUserInSession(HttpServletRequest req,AccountModel account){
		req.getSession().setAttribute(KEY_USER, account);
	}
	public static void putMainUrlInSession(HttpServletRequest req,String url){
		req.getSession().setAttribute(KEY_MAIN_FRAME, url);
	}
	/**
	 * 获取当前登录的用户
	 * @param req
	 * @return
	 */
	public static AccountModel getUser(HttpServletRequest req){
		Object obj = req.getSession().getAttribute(KEY_USER);
		if( obj != null){
			return (AccountModel) obj;
		}
		return null;
	}
	
	public static  String getMainUrl(HttpServletRequest req){
		Object obj = req.getSession().getAttribute(KEY_MAIN_FRAME);
		if( obj != null){
			return obj.toString();
		}
		return null;
	}
	
	public static void destroyAtt(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.removeAttribute(KEY_USER);
		session.removeAttribute(KEY_MAIN_FRAME);
		session.removeAttribute(KEY_TOKEN);
	}
	public static void putAccessToken(HttpServletRequest req,
			AccessTokenModel tokenModel) {
		req.getSession().setAttribute(KEY_TOKEN, tokenModel);
	}
	public static AccessTokenModel getAccessToken(HttpServletRequest req){
		Object obj = req.getSession().getAttribute(KEY_TOKEN);
		if(obj != null){
			return (AccessTokenModel) obj;
		}else{
			return null;
		}
	}
	public static void removeAccessToken(HttpServletRequest req){
		req.getSession().removeAttribute(KEY_TOKEN);
	}
	public static void removeMainUrl(HttpServletRequest req) {
		req.getSession().removeAttribute(KEY_MAIN_FRAME);
		
	}
}
