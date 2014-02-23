package com.workman.commons.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectToMapUtils {
	
	public static Map<String,Object> toMap(Object obj,boolean superFiled) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		if(obj != null){
			Class<?> clazz = obj.getClass();
			List<Field> fields = getFieldList(clazz.getDeclaredFields());
			List<Field> list = new ArrayList<Field>();
			list.addAll(fields);
			if(superFiled){
				List<Field> sFields = getFieldList(clazz.getSuperclass().getDeclaredFields());
				list.addAll(sFields);
			}
			for(Field field : list){
				field.setAccessible(true);
				String fieldName = field.getName();
				map.put(fieldName, getFieldValue(field,obj));
			}
		} 
		return map;
	}
	
	private static List<Field> getFieldList(Field[] fields) {
		List<Field> fieldList = new ArrayList<Field>();
		for(int i=0,len=fields.length;i<len;i++){
			if(!Modifier.isStatic(fields[i].getModifiers())){
				fieldList.add(fields[i]);
			}
		}
		return fieldList;
	}

	private static Object getFieldValue(Field field, Object obj) throws Exception {
		Object value =  field.get(obj);;
		Class<?> clazz = field.getType();
		if(value != null){
			if(clazz == Calendar.class || clazz.getSuperclass() == Calendar.class ){
				Calendar tmp = (Calendar) value;
				value =  DateTimeUtils.getDateTime(tmp);
			}else if (clazz == Date.class || clazz.getSuperclass() == Date.class){
				Date tmp = (Date)value;
				value = DateTimeUtils.getDateTime("yyyy-MM-dd HH:mm:ss", tmp);
			}else if(clazz.isArray()){
				int len = Array.getLength(value);
				List<Object> list = new ArrayList<Object>(len);
				for(int i=0;i<len;i++){
					list.add(toMap(Array.get(value, i), true));
				}
				value = list;
			}
		} else {
			value = "";
		}
		return value;
	}

	public static Map<String,Object> toMap(Object obj) throws Exception{
		return toMap(obj,false);
	}
	
	public static <T>T toObject(Map<String,Object> map,Class<T> clazz) throws Exception{
		T t = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			field.setAccessible(true);
			String fieldName = field.getName();
			Object value = map.get(fieldName);
			if(value != null){
				if(field.getType() == Calendar.class && value.getClass() == String.class){
					Calendar tmp = DateTimeUtils.parseToCalendar(value.toString());
					field.set(t, tmp);
				} else {
					field.set(t, value);
				}
			}
		}
		return t;
	}
	public static List<Map<String,Object>> listToMap(List<?> list) throws Exception {
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		for(int i=0,len=list.size();i<len;i++){
			mapList.add(toMap(list.get(i)));
		}
		return mapList;
	}

}
