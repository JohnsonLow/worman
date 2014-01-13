<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资料修改</title>
<link href="../static/css/style.css" rel="stylesheet" type="text/css" />
<link href="../static/css/elements.css" rel="stylesheet" type="text/css" />
<style>
.frame{ width:98%; height:auto; line-height:24px; color:#3333333}
.frame .input_text240{background:url(../static/images/news/bg_textInput.gif) no-repeat;width:237px;height:29px;line-height:29px; padding:3px 0 3px 3px;border:0px;}
.frame_cont{ width:98%;margin:20px 10px 10px 10px; padding:20px 15px;border:1px solid #8398ad;border-top:2px solid #23879f; background:#f7fbfc}
.frame_cont th{ text-align:right; border:0; font-weight:200; padding:4px 0 4px 0}
.frame_cont td{ border:0; text-align:left;}
.frame_button input{padding:0px 10px;margin-left:72px; background:url(../static/images/news/bg_btn1.gif) repeat-x; border:1px solid #8398ac;color:#333;height:28px;line-height:28px;}
.box355{float:left;width:355px;background:url(../static/images/news/linebg.gif) repeat-y right;}
.box_right{float:left;padding-left:22px; color:#787878;}
</style>
<script type="text/javascript" src="../static/js/jquery-1.4.2.js"></script>
</head>

<body> 
<div class="frame">
	<div class="frame_title">系统管理 &gt; 密码修改</div>
	<input id="level" type="hidden" value="${userInfo.level }"/>
    <input id="unionCode" type="hidden" value="${userInfo.unionCode }"/>
	<div class="frame_cont">
		<div class="">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<span id="uid" style="display: none;">${userInfo.uid }</span>
			<!-- 
			 <tr id="uidDiv">
			    <th width="25%"><img align="absmiddle" src="../static/images/news/icon_xing.gif"/>登录帐号：</th>
			    <td width="75%"><span id="uid">${userInfo.uid }</span></td>
			  </tr>
			 -->
			  <tr>
			    <th width="25%"><img align="absmiddle" src="../static/images/news/icon_xing.gif"/>当前密码：</th>
			    <td width="75%"><input id="pwd" class="input_text240" type="password" value="" />
			    <span id="pwdMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
			  <tr>
			    <th><img align="absmiddle" src="../static/images/news/icon_xing.gif"/>新密码：</th>
			    <td><input class="input_text240" id="npwd" type="password"/>
			    <span id="npwdMsgSpan" style="margin-left:5px; color:red;"></span>
			    </td>
			  </tr>
			  <tr>
			    <th><img align="absmiddle" src="../static/images/news/icon_xing.gif"/>确认新密码：</th>
			    <td><input class="input_text240" id="conPwd" type="password"/>
			     <span id="cpwdMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
			  <!-- 
			  <div id="timeInfo">
				  <tr>
				    <th>创建时间：</th>
				    <td>${ userInfo.createTime}</td>
				  </tr>
				  <tr>
				    <th>更新时间：</th>
				    <td>${userInfo.updateTime }</td>
				  </tr>
			  </div>
			   -->
			  <tr><th></th><td><div class="frame_button"><input id="updatepwd" type="button" value="提交保存" onclick="addOrUpdate()"/></div></td></tr>
			</table>
		</div>
		<p class="cl"></p>
	</div>
</div>
<script type="text/javascript" src="../static/js/operatorManage/user-info.js"></script>
<script type="text/javascript" src="../static/js/sha-1.js"></script>
<script type="text/javascript" language="javascript">
	var oldPwd = "${userInfo.password}";
</script>
</body>
</html>
