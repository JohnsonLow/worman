<%@ page contentType="text/html;charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>4s店资料修改</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
<style>
.frame{ width:98%; height:auto; line-height:24px; color:#3333333}
.frame .input_text550{background:url(static/images/news/bg_textInput550.gif) no-repeat;width:547px;height:29px; line-height:29px;padding:3px 0 3px 3px;border:0px;}
.frame .input_text240{background:url(static/images/news/bg_textInput.gif) no-repeat;width:237px;height:29px; line-height:29px; padding:3px 0 3px 3px;border:0px;}
.frame_cont{ width:98%;margin:20px 10px 10px 10px; padding:5px 0 5px 0;border:1px solid #8398ad;border-top:2px solid #23879f; background:#f7fbfc}
.frame_cont th{ text-align:right; border:0; font-weight:200; padding:4px 0 4px 0}
.frame_cont td{ border:0; text-align:left;}
.frame_button input{padding:0px 10px;margin-left:72px; background:url(static/images/news/bg_btn1.gif) repeat-x; border:1px solid #8398ac;color:#333;height:28px;line-height:28px;}
</style>
</head>

<body>
	<div class="frame">
		<div class="frame_title">系统管理 &gt; 资料修改</div>
		<div class="frame_cont" id="infos">
			<div class="">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					  <tr id="depDiv">
					  	<th width="25%">所在部门：</th>
					  	<td>${currUser.department.name }
				           <span id="depNameMsgSpan" style="margin-left:5px; color:red;"></span></td>
					  </tr>
					  <tr id="posDiv">
					  	<th width="25%">职位类别：</th>
					  	<td>${currUser.pos.name }</td>
					 </tr>
					<tr>
					  	<th width="25%">姓名：</th>
					  	<td><input id="name" type="text" value="${currUser.name }" class="input_text240"/>
			           <span id="userNameMsgSpan" style="margin-left:5px; color:red;"></span></td>
				  	</tr>
			  
			  <tr>
			  	<th width="25%">联系电话：</th>
			  	<td><input id="phone" type="text" value="${currUser.phone }" class="input_text240"/>
		           <span id="phoneMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
			  
			  <tr>
			  	<th width="25%"><img align="absmiddle" src="static/images/news/icon_xing.gif"/>微博账号：</th>
			  	<td><input id="weibo" type="text" value="${currUser.weibo }" class="input_text240"/>
		           <span id="weiboMsgSpan" style="margin-left:5px; color:red;"></span></td>
			  </tr>
					<tr>
						<th></th>
						<td><div class="frame_button">
								<input id="saveBtn" type="button" value="提交" />
							</div></td>
					</tr>
				</table>
			</div>
			
			<p class="cl"></p>
		</div>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<script type="text/javascript" src="static/js/operation/info.js"></script>
	<script type="text/javascript" src="static/js/common/json/json2.js"></script>
	<script type="text/javascript">
		var userName = '${currUser.userName}';
	</script>
</body>
</html>
