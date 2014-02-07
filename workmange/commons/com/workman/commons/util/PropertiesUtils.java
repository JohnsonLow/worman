package com.workman.commons.util;

import java.util.ResourceBundle;

public class PropertiesUtils {
	private static ResourceBundle res;
	
	private static final String PRO_SYS_PATH = "sys";
	private static final String KEY_SYS_USERNAME = "sys.username";
	private static final String KEY_SYS_PWD = "sys.password";
	
	public static String getSysUserName(){
		return getValue(PRO_SYS_PATH,KEY_SYS_USERNAME);
	}
	public static String getSysPwd(){
		return getValue(PRO_SYS_PATH,KEY_SYS_PWD);
	}
	public static String getValue(String path , String key) {
		if(StringUtility.isNotBlank(path) && StringUtility.isNotBlank(key)){
			res = ResourceBundle.getBundle(path);
			return res.getString(key);
		}
		return null;
	}
	
	
}
