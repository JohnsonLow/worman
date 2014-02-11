package com.workman.commons.util;


import weibo4j.Oauth;
import weibo4j.model.WeiboException;

public class WeiboUtils {
	public static String getAccessWeiboUrl(){
		String auth = null;
		try {
			Oauth oauth = new Oauth();
			auth = oauth.authorize("code", "","all");
		} catch (WeiboException e) {
			SysLogUtils.error(WeiboUtils.class, e, "获取微博授权地址出错");
		}
		return auth;
	}
}
