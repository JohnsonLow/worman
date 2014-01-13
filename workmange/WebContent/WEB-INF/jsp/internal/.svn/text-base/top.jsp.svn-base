<%@page import="com.selfservice.permission.po.CompanyUser"%>
<%@page import="com.selfservice.permission.util.SessionUtil"%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>顶部</title>
<link href="../static/css/style.css" rel="stylesheet" type="text/css" />

</head>
<script type="text/javascript" src="../static/js/jquery-1.4.2.js"></script>
<body>
<form action="" style="display:none;">
	<input value="${sourceDomainName}" type="hidden"/>
</form>
<%
String sysUnionCode = request.getAttribute("sysUnionCode").toString();
Object typeObject = session.getAttribute(SessionUtil.SYSTEM_TYPE+"_" + sysUnionCode);
String type = null;
if(typeObject != null){
	 type = typeObject.toString();
}
CompanyUser cuser = SessionUtil.getCompanyUser(request);
%>
<div class="top">
	<div class="logoarea">
        	<div class="<%=SessionUtil.SYSTEM_TYPE_4S.equals(type)?"logol4s":"logol" %>"></div>
    </div>
	<div class="banner_text">
		<div class="btnarea">
			<img src="../static/images/news/btn_Exit.gif" style="cursor:pointer;"  onclick="inExitCompanyUser()"/>
		</div>
		<div style="margin-top:0px; margin-left:10px;width:140px;" class="btnarea"><span>登陆账号：</span><strong><%=cuser.getUser().getUID() %></strong><br></div>
		<%=cuser.getUnionName() %>
	</div>
</div>
<script type="text/javascript" language="javascript">
  function inExitCompanyUser(){
  	if(confirm("确定要退出系统吗?")){
        $.post('inExitCompanyUser.do',{sysUnionCode:<%=request.getAttribute("sysUnionCode")%>},function(data){
        	var logoClazz = $(".logoarea").find("div").attr("class");
        	var oldUrl = window.parent.location.href;
        	var url = "../internal/index.do";
        	if(oldUrl.indexOf("zfw.yesway.cn")>= 0 || oldUrl.indexOf("4s.yesway.cn")>= 0){
        		url="http://zfw.yesway.cn";
        		if(logoClazz == 'logol4s'){
        			url="http://4s.yesway.cn";
        		}
        	}else{
				if(logoClazz == 'logol4s'){
					url = '../4s/index.do';
				}
        	}
			window.parent.location=url;
		});
        return true;
    }
    return false;
	
 }
</script>
</body>
</html>
