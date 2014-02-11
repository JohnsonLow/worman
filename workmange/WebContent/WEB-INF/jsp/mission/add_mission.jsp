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
							<span style="margin-left: 5px; color: red;">*</span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">紧急程度：</div>
						<div class="infoR">
							<span><select class="select-company" style="width: 80px;">
								<option value="普通">普通</option>
								<option value="中等">中等</option>
								<option value="紧急">紧急</option>
							</select></span><span style="margin-left: 5px; color: red;">*</span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">任务内容：</div>
						<div class="infoR">
							<span><textarea rows="10" cols="80"></textarea></span>
							<span style="margin-left: 5px; color: red;">*</span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">备注：</div>
						<div class="infoR">
							<span><input type="text" class="txt-log-date" style="width: 445px;" /></span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">受理人：</div>
						<div class="infoR">
							<span>受理部门：</span><span><select id="slDep" class="select-company" style="width: 140px;"></select></span>
							<span style="margin-left:20px;">受理人：</span>
							<span><select id="slPeo" class="select-company" style="width: 140px;">
							<option value="-1">--请选择部门--</option></select></span><span style="margin-left: 5px; color: red;">*</span>
						</div>
					</div>
				</div>
				<!--内容end-->
			</div>
			<div class="info-foot"
				style="margin-top: 30px; padding-top: 10px; border-top: 1px solid #ccc;">
				<span style="margin-left: 200px;">
				<input id="createAndSend" type="button" class="btn-n" value="创建并发送私信"/></span>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<jsp:include page="/WEB-INF/jsp/inc/preload.jsp"></jsp:include>
	<script type="text/javascript" src="static/js/mission/add_mission.js"></script>
	<script type="text/javascript">
		var accessUrl = '${accessUrl}';
	</script>
</body>
</html>