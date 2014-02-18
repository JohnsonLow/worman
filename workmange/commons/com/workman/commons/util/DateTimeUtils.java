package com.workman.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

public class DateTimeUtils {
	/**
	 * Return current datetime string.
	 * 
	 * @return current datetime, pattern: "yyyy-MM-dd HH:mm:ss".
	 */
	public static String getDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = sdf.format(new Date());
		return dt;
	}

	public static String getDateTime(Calendar c1) {
		return getDateTime(c1,"yyyy-MM-dd HH:mm:ss");
	}
	public static String getDateTime(Calendar c1,String pattern) {
		if(c1 != null){
			return getDateTime(pattern, c1.getTime());
		}
		return null;
	}

	/**
	 *  两时间之间的 -- 差值
	 * 
	 * @param a
	 *            Date
	 * @param b
	 *            Date
	 * @return String
	 */
	public static String getTimeSpace(Date a, Date b) {

		long quot = a.getTime() - b.getTime();
		long quot2 = quot / 1000 / 60;
		long hour = quot2 / 60;
		long minute = quot2 - hour * 60;
		long nextminute = (quot - (hour * 60 * 60 * 1000) - (minute * 60 * 1000)) / 1000;

		String nowstr = "";
		if (hour > 0) {
			nowstr += hour + " 小时 ";
		}
		nowstr += minute + " 分钟 " + nextminute + "秒";
		return nowstr;
	}

	/**
	 * Return current datetime string.
	 * 
	 * @param pattern
	 *            format pattern
	 * @return current datetime
	 */
	public static String getDateTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dt = sdf.format(new Date());
		return dt;
	}

	public static String getUtcDateTime(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String dt = sdf.format(new Date());
		return dt;
	}

	/**
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String getDateTime(String pattern, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dt = sdf.format(date);
		return dt;
	}

	/**
	 * Return short format datetime string.
	 * 
	 * @param date
	 *            java.util.Date
	 * @return short format datetime
	 */
	public static String shortFmt(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		return sdf.format(date);
	}

	/**
	 * Parse a datetime string to Calendar.
	 * 
	 * @param param
	 *            date string
	 * @param pattern
	 *            "yyyy-MM-dd"
	 * @return Calendar
	 */
	public static Calendar parseToCalendar(String param, String pattern) {
		Calendar c = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			if(StringUtils.isNotBlank(param)){
				Date date = sdf.parse(param);
				c = Calendar.getInstance();
				c.setTime(date);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return c;
	}
	public static Calendar parseToCalendar(String param) {
		return parseToCalendar(param, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * Parse a datetime string.
	 * 
	 * @param param
	 *            datetime string, pattern: "yyyy-MM-dd HH:mm:ss".
	 * @return java.util.Date
	 */
	public static Date parse(String param) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(param);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return date;
	}

	/**
	 * Parse a datetime string.
	 * 
	 * @param param
	 *            date string, pattern: "yyyy-MM-dd".
	 * @return java.util.Date
	 */
	public static Date parseDate(String param) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(param);
		} catch (ParseException ex) {
		}
		return date;
	}

	/**
	 * Converse date to Numeric
	 * 
	 * @param date
	 * @return long
	 */
	public static long numericFmt(Date date) {
		long numeric = Long.parseLong("19000000000000");
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		numeric = Long.parseLong(fillStr(year) + fillStr(month) + fillStr(day)
				+ fillStr(hour) + fillStr(minute) + fillStr(second));
		return numeric;
	}

	/**
	 * 
	 * @param numeric
	 * @return
	 */
	public static String numericParse(long numeric) {
		String dateStr = Long.toString(numeric);
		String year = dateStr.substring(0, 4);
		String month = dateStr.substring(4, 6);
		String day = dateStr.substring(6, 8);
		String hour = dateStr.substring(8, 10);
		String minute = dateStr.substring(10, 12);
		String second = dateStr.substring(12, 14);
		return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":"
				+ second;
	}

	public static String numericParse(long numeric, String pattern) {
		return getDateTime(pattern, parse(numericParse(numeric)));
	}

	public static String getHour() {
		Calendar c = Calendar.getInstance();
		// c.setTime(new Date());
		return Integer.toString(c.get(Calendar.HOUR_OF_DAY));
	}

	public static String getMinute() {
		Calendar c = Calendar.getInstance();
		return Integer.toString(c.get(Calendar.MINUTE));
	}

	public static String getSecond() {
		Calendar c = Calendar.getInstance();
		return Integer.toString(c.get(Calendar.SECOND));
	}

	private static String fillStr(int str) {
		String returnStr = "";
		if (str < 10)
			returnStr = "0" + Integer.toString(str);
		else
			returnStr = Integer.toString(str);
		return returnStr;
	}

	public static Calendar getNowCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal;
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static int getDistanceYear(Calendar c1) {
		int result = 0;
		if (c1 != null) {
			Calendar c2 = Calendar.getInstance();
			result = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
		}
		return result;
	}

	public static String TimeSpaceOnMinutes(Date a, Date b) {
		long quot = a.getTime() - b.getTime();
		long quot2 = quot / 1000 / 60;
		long hour = quot2 / 60;
		long minute = quot2 - hour * 60;
		long nextminute = (quot - (hour * 60 * 60 * 1000) - (minute * 60 * 1000)) / 1000;

		String nowstr = "";
		if (hour > 0) {
			nowstr += hour + " 小时 ";
		}
		nowstr += minute + " 分钟 " + nextminute + "秒";
		return nowstr;
	}

	public static String TimeSpaceOnMinutes1(Date a, Date b) {
		String nowstr = (a.getTime() - b.getTime()) / 1000 + "";
		return nowstr;
	}

	public static void main(String[] args) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss:SS");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			System.out.println("SimpleDateFormat format:"
					+ sdf.format(new Date()));
			Calendar c1 = parseToCalendar("2013-06-12 18:05:06", "yyyy-MM-dd");
			Calendar c2 = parseToCalendar("2013-06-13 18:05:06", "yyyy-MM-dd HH:mm:ss");
			System.out.println(c1.getTime());
			System.out.println(c2.getTime());
			System.out.println(getDateTime(c1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
