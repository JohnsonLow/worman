<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@page import="com.selfservice.permission.util.SessionUtil"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
</head>
<script type="text/javascript">
   var sysUnionCode = "<%=request.getAttribute("sysUnionCode")%>"
	var systemType = "<%=(session.getAttribute(SessionUtil.SYSTEM_TYPE+"_"+request.getAttribute("sysUnionCode")))%>";
	if("4s"==systemType)
	{
		document.title = "智驾4s服务系统";
		
	}else 	if("selfservice"==systemType)
	{
		document.title = "智驾自服务系统";
		
	}
	
	
</script>
<frameset rows="63,*,30" cols="*" frameborder="0" border="0" framespacing="0">
  <frame src="../internal/top.do?sysUnionCode=${sysUnionCode }" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
  <frameset rows="*" cols="200,*" framespacing="0" frameborder="0" border="0">
    <frame  src="../internal/left.do?sysUnionCode=${sysUnionCode }" name="leftFrame" scrolling="auto" noresize="noresize" id="leftFrame" />
    <frame src="<%=("4s".equals(session.getAttribute(SessionUtil.SYSTEM_TYPE+"_"+request.getAttribute("sysUnionCode")))?"../4s/main.do":"../internal/main.do")%>" name="mainFrame" scrolling="auto" id="mainFrame" />
  </frameset>
  <frame src="../internal/bottom.do?sysUnionCode=${sysUnionCode }" name="bottomFrame" id="bottomFrame" scrolling="no">
</frameset>
<noframes><body>
</body></noframes>
</html>
