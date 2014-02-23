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
		<div class="info">
			<div class="info-top">任务信息 <span id="sendWbBtn" style="float:right;display:none;"><a href='javascript:;'>发送微博通知受理人</a></span></div>
			<div class="cl"></div>
			<div class="info-content">
				<table class="table" width="100%" cellspacing="1" cellpadding="3" border="0" align="center">
					<thead><tr><td colspan="8" align="center" class="bg_c">任务内容</td></tr></thead>
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
				<div class="cl"></div>
				<div id="handleListDiv" style="display:none;">
					<table id="handleTable" class="table" width="100%" cellspacing="1" cellpadding="3" border="0" align="center">
						<thead><tr><td colspan="8" align="center" class="bg_c">处理记录</td></tr>
						<tr><td>处理部门</td><td>处理人</td><td>处理意见</td><td>处理时间</td>
						<td>受理部门</td><td>受理人</td><td>受理时间</td></tr></thead>
						<tbody></tbody>
					</table>
				</div>
				<div class="cl" style="height:10px;"></div>
				<div id="handleDiv" style="display:none;">
					<table class="table" width="100%" cellspacing="1" cellpadding="3" border="0" align="center">
						<thead><tr><td colspan="8" align="center" class="bg_c">工单处理</td></tr></thead>
						<tbody>
							<tr><td class="bg_c" width="10%">处理方式：</td>
							<td width="6%"class="no_rborder" align="left">
								<span style="float:left;"><input type="radio" checked="checked" value="1002" name="handType"/><span style="margin-left:5px;">完成</span></span></td>
							<td style="align:left;" class="no_rborder" width="10%" >
							<span style="float:left;"><input value="1001" type="radio" name="handType"/><span style="margin-left:5px;">转给其他人</span></span>
							</td>
							<td><span style="margin-left:10px;"> 
							 <select class="select-company" id="depSel" style="width:120px;">
							 </select> <select class="select-company" style="width:120px;" id="peoSel">
							 	<option value="-1">--请选择部门--</option>
							 </select></span></td></tr>
							 <tr><td class="bg_c" width="10%">处理意见：</td>
							 <td colspan="8"><textarea id="content" rows="5" cols="200" style="text-log-data"></textarea></td></tr>
							 <tr><td colspan="8"><input class="btn-n" type="button" value="确认处理" id="confirmHanBtn"/></td></tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="info-foot"
				style="margin-top: 30px; padding-top: 10px; border-top: 1px solid #ccc;">
				<span style="margin-left: 200px;">
				<input style="display:none;" id="send" type="button" class="btn-n" value="发送微博通知"/></span>
			</div>
			</div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<jsp:include page="/WEB-INF/jsp/inc/preload.jsp"></jsp:include>
	<script type="text/javascript" src="static/js/mission/mission_info.js"></script>
	<script type="text/javascript" src="static/js/mission/mission_utils.js"></script>
	<script type="text/javascript" src="static/js/mission/weibo.js"></script>
	<script type="text/javascript">
		var status = '${missionInfo.status }'; 
		var fqId = '${missionInfo.sponsorId}';
		var fqName = '${missionInfo.sponsorName}';
		var fqDep = '${missionInfo.sponsorDep}';
		var missionId = '${missionInfo.id}';
		var currId = '${currUser.id}';
		var currName = '${currUser.name}';
		var currDep = '${currUser.department.name}';
		var handlerId = '${missionInfo.handlerId}';
		var sponsorId = '${missionInfo.sponsorId}';
		var handleInfoStr = '${handleInfo}';
		if(handleInfoStr){
			var handleInfos = JSON.parse(handleInfoStr);
		}
		$("#statusTd").text(getStatus(status));
	</script>
</body>
</html>