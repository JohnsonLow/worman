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
								style="width: 400px;" /></span> <span
								style="margin-left: 5px; color: red;">*</span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">紧急程度：</div>
						<div class="infoR">
							<select class="select-company" style="width: 50px;"></select>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">账号开关：</div>
						<div class="infoR">
							<select name="select" class="select-company"
								style="width: 100px;">
								<option>开启</option>
								<option>关闭</option>
							</select>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">所属角色：</div>
						<div class="infoR">
							<span> <select name="select" class="select-company"
								style="width: 100px;">
									<option>高级操作员</option>
									<option>普通操作员</option>
							</select>
							</span> <span style="color: red;">*</span>
						</div>
					</div>
					<div class="inform">
						<div class="infoL">所属单位：</div>
						<div class="infoR">
							<input type="text" class="txt-log-date" style="width: 160px;" />
						</div>
					</div>
					<div class="inform">
						<div class="infoL">真实姓名：</div>
						<div class="infoR">
							<input type="text" class="txt-log-date" style="width: 160px;" />
						</div>
					</div>
					<div class="inform">
						<div class="infoL">联系电话：</div>
						<div class="infoR">
							<input type="text" class="txt-log-date" style="width: 160px;" />
						</div>
					</div>
					<div class="inform">
						<div class="infoL">通信地址：</div>
						<div class="infoR">
							<input type="text" class="txt-log-date" style="width: 300px;" />
						</div>
					</div>
					<div class="inform">
						<div class="infoL">邮编：</div>
						<div class="infoR">
							<input type="text" class="txt-log-date" style="width: 160px;" />
						</div>
					</div>
					<div class="inform">
						<div class="infoL">电子邮箱：</div>
						<div class="infoR">
							<input type="text" class="txt-log-date" style="width: 160px;" />
						</div>
					</div>
					<div class="inform">
						<div class="infoL">备注：</div>
						<div class="infoR">
							<input type="text" class="txt-log-date" style="width: 300px;" />
						</div>
					</div>
				</div>
				<!--内容end-->
			</div>
			<div class="info-foot"
				style="margin-top: 30px; padding-top: 10px; border-top: 1px solid #ccc;">
				<span style="margin-left: 200px;"><input type="button"
					class="btn-tj" value=" " /></span> <span style="margin-left: 20px;"><input
					type="button" class="btn-qx"
					style="background: url(static/images/btn_fh.gif) no-repeat;" value=" "
					onclick="location.href='account.html'" /></span>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
</body>
</html>