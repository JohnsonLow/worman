<%@page import="com.workman.permission.util.SessionUtils"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>任务信息</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
<style type="text/css">
	.table{
		background-color: #F7F7F7;
		border:  1px solid #CCCCCC;
	}
	.no_rborder {
		border-right: none;
	}
	.bg_c {
		background-color: #CCCCCC;
	}
</style>
</head>
<body>
	<div class="authority-top">
		<div class="info">
			<div class="info-top">任务信息</div>
			<div class="info-content">
<table class="table" width="100%" cellspacing="1" cellpadding="3" border="0" align="center">
  <tbody><tr> 
  	<td width="100px" class="bg_c">编号：</td>
	<td width="180px" class="bg_4">${missionInfo.id }</td>
  	<td width="100px" class="bg_c">主题：</td>
	<td class="bg_4" colspan="1">${missionInfo.title }</td>
  	<td width="100px" class="bg_c">状态：</td>
	<td width="180px" class="bg_4" id="statusTd"></td>
  	<td width="100px" class="bg_c">紧急程度：</td>
	<td width="180px" class="no_rborder">${missionInfo.type }</td>
  </tr>
  <tr>
  	<td class="bg_c">发起部门：</td>
	<td class="bg_4">${missionInfo.sponsorDep }</td>
  	<td class="bg_c">发起人：</td>
	<td title="" class="bg_4">${missionInfo.sponsorName }</td>
  	<td class="bg_c">受理部门：</td>
	<td class="bg_4">${missionInfo.handlerDep }</td>
  	<td class="bg_c">受理人：</td>
	<td title="" class="no_rborder">${missionInfo.handlerName }</td>
  </tr>
  <tr>
    <td class="bg_c">发起时间：</td>
	<td class="bg_4">${missionInfo.createTime }</td>
    <td class="bg_c">开始受理时间：</td>
	<td class="bg_4">${missionInfo.handleTime }</td>
    <td class="bg_c">完成时间：</td>
	<td class="">${missionInfo.commitTime }</td>
  </tr>		
  
  <tr>
  	<td class="bg_c">内容：</td>
	<td height="80" colspan="7" class="no_rborder">${missionInfo.content }</td>
  </tr>		
  <tr>
  	<td class="bg_c">备注：</td>
	<td style="border-bottom: none;" colspan="7" class="no_rborder"></td>
  </tr>		
</tbody></table>
				<!--内容end-->
			</div>
			<div class="info-foot"
				style="margin-top: 30px; padding-top: 10px; border-top: 1px solid #ccc;">
				<span style="margin-left: 200px;">
				<!-- <input id="createAndSend" type="button" class="btn-n" value="创建并发送微博通知"/> -->
				<input id="create" type="button" class="btn-n" value="创建任务"/>
				<input style="display:none;" id="send" type="button" class="btn-n" value="发送微博通知"/></span>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<jsp:include page="/WEB-INF/jsp/inc/preload.jsp"></jsp:include>
	<script type="text/javascript" src="static/js/mission/mission_info.js"></script>
	<script type="text/javascript" src="static/js/mission/mission_utils.js"></script>
	<script type="text/javascript">
		var status = '${missionInfo.status }'; 
		$("#statusTd").text(getStatus(status));
	</script>
</body>
</html>