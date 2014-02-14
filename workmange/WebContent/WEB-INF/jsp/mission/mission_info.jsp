<%@page import="com.workman.permission.util.SessionUtils"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>任务信息</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
</head>
<body>
	<div class="authority-top">
		<div class="info">
			<div class="info-top">任务信息</div>
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
						<table width="100%" cellspacing="1" cellpadding="3" border="0" align="center">
  <tbody><tr> 
  	<td width="100px" bgcolor="#999999">编号：</td>
	<td width="180px" class="bg_4">3354</td>
  	<td width="100px" bgcolor="#999999">主题：</td>
	<td class="bg_4">智驾商城“支付方式说明处”将2、电话支付删除</td>
  	<td width="100px" bgcolor="#999999">状态：</td>
	<td width="180px" class="bg_4">处理中</td>
  	<td width="100px" bgcolor="#999999">紧急程度：</td>
	<td width="180px" class="bg_4">普通</td>
  </tr>
  <tr>
  	<td bgcolor="#999999">发起部门：</td>
	<td class="bg_4">网站运营部</td>
  	<td bgcolor="#999999">发起人：</td>
	<td title="" class="bg_4">张军</td>
  	<td bgcolor="#999999">受理部门：</td>
	<td class="bg_4">质保部</td>
  	<td bgcolor="#999999">受理人：</td>
	<td title="" class="bg_4">唐丽华</td>
  </tr>
  <tr>
    <td bgcolor="#999999">发起时间：</td>
	<td class="bg_4">2013-12-16 08:52:51</td>
    <td bgcolor="#999999">开始受理时间：</td>
	<td class="bg_4">2013-12-16 09:00:21</td>
    <td bgcolor="#999999">要求完成时间：</td>
	<td class="bg_4"></td>
  	<td bgcolor="#999999">预计完成时间：</td>
	<td class="bg_4"></td>
  </tr>		
  <tr>
    <td bgcolor="#999999">大类：</td>
	<td class="bg_4">产品&amp;项目问题</td>
    <td bgcolor="#999999">小类：</td>
	<td class="bg_4">需求改善</td>
    <td bgcolor="#999999">是否要求回复</td>
	<td class="bg_4">需要</td>
  	<td bgcolor="#999999">实际完成时间：</td>
	<td class="bg_4"></td>
  </tr>
  <tr>
    <td bgcolor="#999999">产品：</td>
	<td class="bg_4">智驾行</td>
    <td bgcolor="#999999">模块：</td>
	<td class="bg_4">智驾网</td>
    <td bgcolor="#999999">版本：</td>
	<td class="bg_4">1.2.2</td>
    <td bgcolor="#999999">预计修复版本</td>
	<td class="bg_4">1.2.3</td>
  </tr>		
  
  <tr>
  	<td bgcolor="#999999">内容：</td>
	<td height="80" colspan="7" class="bg_4">智驾商城“支付方式说明处”将2、电话支付删除。<br><br>检证环境链接地址http://111.207.170.16/shop_pay_later.html?oid=1312161000066</td>
  </tr>		
  <tr> 
	<td bgcolor="#999999">附件：</td>
    <td colspan="7" class="bg_4">
    
    </td>
  </tr>
  <tr>
  	<td bgcolor="#999999">备注：</td>
	<td colspan="7" class="bg_4"></td>
  </tr>		
</tbody></table>
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