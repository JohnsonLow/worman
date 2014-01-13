<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="keywords" content="工作任务分配 新浪微博">
<meta http-equiv="description" content="基于新浪微博的企业工作任务分配">
<link href="../static/css/elements.css" rel="stylesheet" type="text/css" />
<link href="../static/css/style.css" rel="stylesheet" type="text/css" />
