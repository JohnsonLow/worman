<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>微博任务管理系统</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
</head>
<frameset rows="63,*,30" cols="*" frameborder="0" border="0" framespacing="0">
  <frame src="internal/top.do" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
  <frameset rows="*" cols="200,*" framespacing="0" frameborder="0" border="0">
    <frame  src="internal/left.do" name="leftFrame" scrolling="auto" noresize="noresize" id="leftFrame" />
    <frame src="internal/main.do" name="mainFrame" scrolling="auto" id="mainFrame" />
  </frameset>
  <frame src="internal/bottom.do" name="bottomFrame" id="bottomFrame" scrolling="no">
</frameset>
<noframes><body>
</body></noframes>
</html>
