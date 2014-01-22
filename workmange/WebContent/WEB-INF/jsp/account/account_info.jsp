<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帐号资料修改</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
<style>
	.frame{ width:98%; height:auto; line-height:24px; color:#3333333}
	.frame .input_text240{background:url(static/images/news/bg_textInput.gif) no-repeat;width:237px;height:29px;line-height:29px; padding:3px 0 3px 3px;border:0px;}
	.frame_cont{ width:98%;margin:20px 10px 10px 10px; padding:20px 15px;border:1px solid #8398ad;border-top:2px solid #23879f; background:#f7fbfc}
	.frame_cont th{ text-align:right; border:0; font-weight:200; padding:4px 0 4px 0}
	.frame_cont td{ border:0; text-align:left;}
	.frame_button input{padding:0px 10px;margin-left:72px; background:url(static/images/news/bg_btn1.gif) repeat-x; border:1px solid #8398ac;color:#333;height:28px;line-height:28px;}
	.box355{float:left;width:355px;background:url(static/images/news/linebg.gif) repeat-y right;}
	.box_right{float:left;padding-left:22px; color:#787878;}
	.select{height: 29px;line-height: 29px;width: 240px;align:center;}
</style>
</head>
<body> 
<div class="frame">
	<div class="frame_title">操作员管理 &gt; <span id="titleSpan"></span></div>
	<input id="level" type="hidden" value="${userInfo.level }"/>
    <input id="unionCode" type="hidden" value="${userInfo.unionCode }"/>
	<div class="frame_cont">
		<div class="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			 <tr id="uidDiv">
			    <th width="25%"><img align="absmiddle" src="static/images/news/icon_xing.gif"/>帐号：</th>
			    <td> <input id=username type="text" class="input_text240" value="" maxlength="16"/>
		          	<span style="margin-left:5px;color: gray;">账号由数字、字母或下划线组成</span>
		                 <span id="uidMsgSpan" style="margin-left:5px;color:red;"></span></td>
			  </tr>
			  <tr>
			    <th width="25%"><img align="absmiddle" src="static/images/news/icon_xing.gif"/>密码：</th>
			    <td><input id="pwd" type="password" value="${userInfo.password }" class="input_text240"/>
			    <span class="frame_button"  style="margin-left:-65px;color: gray;">
				<input id="out_nav" type="button" value="初始密码" name="button" onclick="defaultPwd()" /> (初始为6个0)</span>
			    <span id="pwdMsgSpan" style="margin-left:5px; color:red;"></span>
			    </td>
			  </tr>
			  <tr width="25%">
			    <th><img align="absmiddle" src="static/images/news/icon_xing.gif"/>确认密码：</th>
			    <td><input id="conPwd" type="password" value="${userInfo.password }" class="input_text240"/>
			     <span id="cpwdMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
			  <tr>
			  	<th width="25%">姓名：</th>
			  	<td><input id="userName" type="text" value="${userInfo.userName }" class="input_text240"/>
		           <span id="userNameMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
			  <tr>
			  	<th width="25%"><img align="absmiddle" src="static/images/news/icon_xing.gif"/>所在部门：</th>
			  	<td><select id="depSel" class="select-company select">
			  		<c:forEach var="dep" items="${depList }">
			  			<option value="${dep.code }">${ dep.name}</option>
			  		</c:forEach>
			  	</select>
		           <span id="depNameMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
			  <tr>
			  	<th width="25%"><img align="absmiddle" src="static/images/news/icon_xing.gif"/>联系电话：</th>
			  	<td><input id="phone" type="text" value="${userInfo.userName }" class="input_text240"/>
		           <span id="phoneNameMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
			  <tr>
			  	<th width="25%"><img align="absmiddle" src="static/images/news/icon_xing.gif"/>权限类别：</th>
			  	<td><select id="authSel" class="select-company select">
			  		<c:forEach var="auth" items="${authList }">
			  			<option value="${auth.level }">${ auth.name}</option>
			  		</c:forEach>
			  	</select>
		           <span id="authLevelNameMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
			  <tr>
			  	<th width="25%"><img align="absmiddle" src="static/images/news/icon_xing.gif"/>微博账号：</th>
			  	<td><input id="weibo" type="text" value="${userInfo.userName }" class="input_text240"/>
		           <span id="weiboNameMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
			  <tr><th></th><td><div class="frame_button">
				  <input id="saveAcc" type="button" value="保存账号" onclick="addOrUpdate()"/>
			</table>
		</div>
		<!-- 
			<div class="box_right">
				<p><img src="static/images/news/title.gif" /></p>
				<p><img src="static/images/news/icon_dian.gif" class="mr5" />定期更换密码可以让您的帐户更加安全</p>
			</div>
		 -->
		<p class="cl"></p>
	</div>
</div>
<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="static/js/account/account-info.js"></script>
<script type="text/javascript" src="static/js/sha-1.js"></script>
<script type="text/javascript" src="static/js/common/json/json2.js"></script>
<script type="text/javascript" language="javascript">
function showDiv(){
document.getElementById('lgdiv').style.display='block';
}
var oldPwd = '${userInfo.password}';
var uid = '${userInfo.uid }';
var unionCode = '${unionCode}';
</script>
</body>
</html>
