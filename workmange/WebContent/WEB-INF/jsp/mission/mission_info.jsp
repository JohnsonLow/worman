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
	<td width="180px" class="bg_4">3354</td>
  	<td width="100px" class="bg_c">主题：</td>
	<td class="bg_4" colspan="1">智驾商城“支付方式说明处”将2、电话支付删除</td>
  	<td width="100px" class="bg_c">状态：</td>
	<td width="180px" class="bg_4">处理中</td>
  	<td width="100px" class="bg_c">紧急程度：</td>
	<td width="180px" class="no_rborder">普通</td>
  </tr>
  <tr>
  	<td class="bg_c">发起部门：</td>
	<td class="bg_4">网站运营部</td>
  	<td class="bg_c">发起人：</td>
	<td title="" class="bg_4">张军</td>
  	<td class="bg_c">受理部门：</td>
	<td class="bg_4">质保部</td>
  	<td class="bg_c">受理人：</td>
	<td title="" class="no_rborder">唐丽华</td>
  </tr>
  <tr>
    <td class="bg_c">发起时间：</td>
	<td class="bg_4">2013-12-16 08:52:51</td>
    <td class="bg_c">开始受理时间：</td>
	<td class="bg_4">2013-12-16 09:00:21</td>
    <td class="bg_c">完成时间：</td>
	<td class=""></td>
  </tr>		
  
  <tr>
  	<td class="bg_c">内容：</td>
	<td height="80" colspan="7" class="no_rborder">智驾商城“支付方式说明处”将2、电话支付删除。<br><br>检证环境链接地址http://111.207.170.16/shop_pay_later.html?oid=1312161000066</td>
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
	<script type="text/javascript">
		
	</script>
</body>
</html>