<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="IE=EmulateIE7" http-equiv="X-UA-Compatible">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="工作任务分配 新浪微博">
<meta http-equiv="description" content="基于新浪微博的企业工作任务分配">
<link href="static/css/elements.css" rel="stylesheet" type="text/css" />
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<script>
	var contextPath = '<%=contextPath%>';
	function goLoginPage(){
		 alert("您还未登录或登录已过期,请重新登录!");
         window.parent.location.href = contextPath + "/internal/login.do";
	}
</script>