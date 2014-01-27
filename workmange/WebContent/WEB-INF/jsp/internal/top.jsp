<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>顶部</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
</head>
<body>
<div class="top">
	<div class="logoarea">
        	<div class="logol"></div>
    </div>
	<div class="banner_text">
		<div class="btnarea">
			<img src="static/images/news/btn_Exit.gif" style="cursor:pointer;"  onclick="inExitCompanyUser()"/>
		</div>
		<div style="margin-top:0px; margin-left:10px;width:270px;word-wrap:break-word; " class="btnarea">
			<span>登陆账号：</span><strong>${currUser.userName }</strong>
			<span>(${currUser.name })</span></div>
		微博任务管理系统
	</div>
</div>
<script type="text/javascript" language="javascript">
  function inExitCompanyUser(){
  	if(confirm("确定要退出系统吗?")){
        $.post('internal/logout.do',function(data){
			window.parent.location='internal/login.do';
		});
        return true;
    }
    return false;
	
 }
</script>
</body>
</html>
