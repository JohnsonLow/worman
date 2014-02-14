<%@page import="com.workman.permission.util.SessionUtils"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>新建任务</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
</head>
<body>
	<div class="authority-top">
		<div class="info">
			<div class="info-top">新建任务</div>
			<div class="info-content">
				<div class="infocontL"></div>
				<!--内容-->
				<div class="infocontR">
					<div class="inform">
						<div class="infoL">任务主题：</div>
						<div class="infoR">
							<span><input id='mTitle' type="text" class="txt-log-date"
								style="width: 445px;" /></span> 
							<span style="margin-left: 5px; color: red;">*</span><span id="titleMsgSpan"></span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">紧急程度：</div>
						<div class="infoR">
							<span><select id="type" class="select-company" style="width: 80px;">
								<option value="普通">普通</option>
								<option value="中等">中等</option>
								<option value="紧急">紧急</option>
							</select></span><span style="margin-left: 5px; color: red;">*</span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">任务内容：</div>
						<div class="infoR">
							<span><textarea id="content" rows="10" cols="80"></textarea></span>
							<span style="margin-left: 5px; color: red;">*</span><span id="contentMsgSpan"></span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">备注：</div>
						<div class="infoR">
							<span><input id="notes" type="text" class="txt-log-date" style="width: 445px;" /></span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">受理人：</div>
						<div class="infoR">
							<span>受理部门：</span><span><select id="slDep" class="select-company" style="width: 140px;"></select></span>
							<span style="margin-left:20px;">受理人：</span>
							<span><select id="slPeo" class="select-company" style="width: 140px;">
							<option value="-1">--请选择部门--</option></select></span><span style="margin-left: 5px; color: red;">*</span>
							<span id="peoMsgSpan"></span>
						</div>
					</div>
				</div>
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
	<script type="text/javascript" src="static/js/mission/add_mission.js"></script>
	<script type="text/javascript">
		var accessUrl = '${accessUrl}';
		var currId = '<%=SessionUtils.getUser(request).getId()%>';
	</script>
</body>
</html>