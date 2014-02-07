<%@ page contentType="text/html;charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>职位管理</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
</head>

<body>
	<div id="insertDiv" class="out"
		style="height: 258px; background: #22879E; display: none">
		<table width="98%" border="0" cellpadding="0" cellspacing="1"
			bgcolor="#cccccc">
			<tr>
				<th style="text-align: right">职位编号：</th>
				<td style="text-align: left"><input class="out_input" id="code" /></td>
			</tr>
			<tr>
				<th style="text-align: right">职位名称：</th>
				<td style="text-align: left"><input class="out_input" id="name" /></td>
			</tr>
			<tr>
				<th style="text-align: right">职位描述：</th>
				<td style="text-align: left"><textarea rows="5" cols="40"
						id="desc"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><table width="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="46%" class="frame_button" style="text-align: right"><input
								id="addAuthBtn" name="button2" type="button" value="确定" /></td>
							<td width="8%" class="frame_button">&nbsp;</td>
							<td width="46%" class="frame_button" style="text-align: left"><input
								name="button22" type="button" value="取消" id="out_close"
								onclick="closeAddDiv();" /></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>
	<div class="frame" style="position: absolute;">
		<div class="frame_title">
			<p>操作员管理  &gt; 职位管理</p>
		</div>
		<div class="cl"></div>
		<div id="lgdiv" style="display: block;" class="frame_cont">
			<div style="background: none;" class="frame_title">
				<span style="float: left;">职位列表</span> <span
					style="float: right; margin-right: 10px;"><a
					href="javascript:;" onclick="$('#insertDiv').mypop();">添加职位</a></span> <span
					id="selectDiv" style="float: right;"> <span><a
						id="checkAll" href="javascript:void(0);" onclick='checkAll();'>全选</a></span> <span
					style="margin-left: 10px;"><a href="javascript:;"
						onclick="batchDelInfos();">删除</a></span> <span
					style="color: #404040; margin: 0 10px;"><a
						href="javascript:;">|</a></span>
				</span>
			</div>
			<div>
				<div class="cl"></div>
				<table id="posList" width="100%" border="0" cellpadding="0"
					cellspacing="1" bgcolor="#CCCCCC" class="frame_table">
					<thead>
						<tr>
							<th>选中</th>
							<th>职位编号</th>
							<th>职位名称</th>
							<th>职位描述</th>
							<th>管理</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="5">暂无数据</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--分页-->
			<div id="pager" class="pager"></div>
		</div>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<%
		pageContext
				.include("/WEB-INF/jsp/inc/pager/pagination.jsp?skin=go&number=5");
	%>
	<jsp:include page="/WEB-INF/jsp/inc/preload.jsp"></jsp:include>
	<script type="text/javascript" src="static/js/sysman/position.js"></script>
	<script type="text/javascript" src="static/js/common/json/json2.js"></script>
	<script type="text/javascript" language="javascript">
		function showDiv() {
			document.getElementById('lgdiv').style.display = 'block';
		}
	</script>
</body>
</html>