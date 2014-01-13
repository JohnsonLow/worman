package com.workman.permission.util;

import org.apache.log4j.Logger;


/**
 * 日志统一工具类
*   
 */
public class SysLogUtils {

	private static String application = "企业微博任务管理系统";
	private static StringBuffer strBuffer = new StringBuffer();
	 
	/**
	 * 
	 * @param m 模块
	 * @param clazz 异常发生时来源类
	 * @param exception 异常类
	 * @param exceptionContent 异常内容
	 */
    public static void error(Class<?> source,Exception exception,String exceptionContent)
    {
    	Logger log = Logger.getLogger(source);
		systemException(log, exception, exceptionContent);
    }
    
    
    /**
	 * 
	 * @param m 模块
	 * @param clazz 异常发生时来源页面
	 * @param exception 异常类
	 * @param exceptionContent 异常内容
	 */
    public static void error(String source,Exception exception,String exceptionContent)
    {
    	Logger log = Logger.getLogger(source);
    	
		systemException( log, exception, exceptionContent);
        	
    
    }
    /**
     * 
     * @param m 模块
     * @param d 动作
     * @param clazz 所属类
     * @param sourceIP 访客IP
     * @param remark 备注
     */
    public static void info(Class<?> clazz,String sourceIP,String remark)
    {
    	Logger log = Logger.getLogger(clazz);
    	strBuffer.append("【系统操作日志】项目:").append(application).append(
    			",访客IP:").append(sourceIP).append(",class类:").append(",备注:").append(remark);
    	log.info(strBuffer.toString());
    	strBuffer.delete(0, strBuffer.length());
    }
    
    
    
    /**
     * 
     * @param m 打印信息所属模块
     * @param clazz 信息发生所在类
     * @param info 信息内容
     */
    public static void info(Class<?> clazz,String info)
    {
    	Logger log = Logger.getLogger(clazz);
    	log.info("========================信息打印开始==========================");
    	
    	log.info("项目:"+application);
    	log.info("来源:"+clazz.getName());
    	log.info("信息内容:"+info);
    	log.info("========================信息打印开始==========================");
    }
    private static  void systemException(Logger log,Exception exception,String exceptionContent)
    {
    	log.error("========================异常(系统)打印开始==========================");
    	log.error("项目:"+application);
    	log.error("异常来源:"+log.getName());
    	log.error("异常类型:"+exception.getClass().getName());
    	log.error("异常内容:"+exceptionContent);
    	log.error("异常消息:"+exception.getMessage());
    	log.error("堆栈跟踪:");
    	StackTraceElement[] stacks = exception.getStackTrace();
    	for(int i=0;i<stacks.length;i++)
    	{
    		log.error("     "+stacks[i].toString());
    	}
    	log.error("========================异常(系统)打印结束=========================");
    }
	
}
