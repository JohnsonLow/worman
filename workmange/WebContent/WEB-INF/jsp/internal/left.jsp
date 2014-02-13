<%@page import="com.workman.permission.util.SessionUtils"%>
<%@page import="com.workman.sysman.model.AccountModel"%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript">
function showList(obj,index){
	if(!index){
		index = 0;
	}
	var clazz = $(obj).attr("class");
	var toToggle = $(obj).parent().parent().find("div[class='dlist']").eq(index);
	toToggle.toggle();
	if(clazz == "dv"){
		$(obj).attr("class","dv2");
	}else if(clazz == "dv2"){
		$(obj).attr("class","dv");
	}else{
		if(toToggle.css("display") != "none"){
			$(obj).parent().find("img").attr("src","static/images/news/folding.gif");
		}else{
			$(obj).parent().find("img").attr("src","static/images/news/expand.gif");
		}
	}
}
</script>

</head>

<body>
<div class="leftarea">
	<div class="sv3">
	<%AccountModel currAccount = SessionUtils.getUser(request); 
	String contextPath = request.getContextPath();
   	if(!currAccount.getUserName().equals("sysadmin")){ %>
     <div class="d1">
     	<div class="d2">
     		<div class="dv2" onclick="showList(this)">
            	<img align="absmiddle" src="static/images/news/menu_icon1.gif"/>个人信息</div>
       	</div>
        	<div class="dlist" style="display: none;"> 
        		<div class="d3">
                   <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/operation/goPwdModifyPage.do'"><div class="ds1">密码修改</div></a>
                </div>
                <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/operation/goInfoModifyPage.do'"><div class="ds1">资料修改</div></a>
                </div>
            </div>
       </div>
       <div class="d1">
     	<div class="d2">
     		<div class="dv2" onclick="showList(this)">
            	<img align="absmiddle" src="static/images/news/icon_weibo.png" width="32px"/>微博管理</div>
       	</div>
        	<div class="dlist" style="display: none;"> 
                 <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/weibo/goAccessPage.do'"><div class="ds1">微博绑定并授权</div></a>
                </div>
                 <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/weibo/goRevokeAccessPage.do'"><div class="ds1">授权收回</div></a>
                </div>
            </div>
       </div>  
        <div class="d1">
            <div class="d2">
                <div id="czygl" class="dv2" onclick="showList(this)">
                	<img align="absmiddle" src="static/images/news/menu_icon5.gif"/>任务管理</div>
            </div>
            <div class="dlist" style="display: none;">
            	 <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/mission/goAddMissionPage.do'"><div class="ds1">新建任务</div></a>
                </div>
            	 <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/ServiceInform/goAppPage.do'"><div class="ds1">待处理任务</div></a>
                </div>
            	<div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/ServiceInform/goMessagePage.do'"><div class="ds1">任务查看</div></a>
                </div>
            </div>
       	</div>
       	<%}else{%>
       	<div class="d1">
            <div class="d2">
                <div id="czygl" class="dv2" onclick="showList(this)">
                	<img align="absmiddle" src="static/images/news/menu_icon6.gif"/>系统管理</div>
            </div>
            <div class="dlist" style="display: none;">
                <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/sysMan/goDepartmentPage.do'"><div class="ds1">部门管理</div></a>
                </div>
                <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/sysMan/goPositionPage.do'"><div class="ds1">职位管理</div></a>
                </div>
                <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=contextPath%>/account/goAccountPage.do'"><div class="ds1">帐号管理</div></a>
                </div>
            </div>
        </div>
        <%} %>
    </div>
    <div style="clear:both;"></div>
</div>
</body>
</html>