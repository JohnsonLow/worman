package com.workman.permission.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


import org.codehaus.jackson.map.ObjectMapper;

public class JSONUtils {
	private static ObjectMapper mapper = new ObjectMapper();
	/**
	 * 将普通对象转换为JSON字符串
	 * @param obj
	 * @return
	 */
	public static String getJSONString(Object obj){
		String str = null;
		if(obj != null){
			try {
				str = mapper.writeValueAsString(obj);
			} catch (Exception e) {
				SysLogUtils.error(JSONUtils.class, e, "将对象转换为JSON字符串时出错");
			}
		}
		return str;
	}
	
	public static <T>T getObject(String jsonStr,Class<T> valueType){
		if(StringUtility.isNotBlank(jsonStr)){
			try {
				return mapper.readValue(jsonStr, valueType);
			} catch (Exception e) {
				SysLogUtils.error(JSONUtils.class, e, "将JSON字符串转换为对象时出错");
			}
		}
		return null;
	}
	public static void writeJson(Object arg,HttpServletResponse res){
		if(arg != null){
			String val = "";
			Class<?> clazz = arg.getClass();
			if(clazz == String.class || clazz == Integer.class || clazz == int.class ||
					clazz == Boolean.class || clazz == boolean.class){
				res.setContentType("application/text;charset=utf-8");
				val = arg.toString();
			}else{
				try {
					val = getJSONString(arg);
				} catch (Exception e) {
					SysLogUtils.error(JSONUtils.class, e, "初始化ObjectMapper失败");
				}
				res.setContentType("application/json;charset=utf-8");
			}
			PrintWriter writer = null;
			try {
				writer = res.getWriter();
				writer.write(val);
				writer.flush();
			} catch (Exception e) {
				SysLogUtils.error(JSONUtils.class, e, "操作HttpServletResponse失败");
			}finally{
				StreamUtils.closeStream(writer);
			}
		}
	}

}
