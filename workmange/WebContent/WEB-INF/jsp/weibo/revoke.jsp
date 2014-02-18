<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>微博授权</title>
	<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
	<style type="text/css">
		.alert {
		padding: 8px 35px 8px 14px;
		margin-top: 5px;
		text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);
		background-color: #fcf8e3;
		border: 1px solid #fbeed5;
		-webkit-border-radius: 4px;
		-moz-border-radius: 4px;
		border-radius: 4px;
		color: #c09853;
		font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
		font-size: 14px;
		width:300px;
	}
	.alert h4 {
		color: #c09853;
		font-size: 18px;
		font-family: inherit;
		margin : 10px 0;
		text-align : cent;
		font-weight: bold;
		line-height: 20px;
	}
	.alert a{
		font-size: 14px;
		color: #c09853;
	}
	.alert span{
		margin: 20px 20px;
	}
	</style>
</head>
<body style="">
	<div class="alert" style="display:none;">
	       	提示
	       	<h4>确认取消授权？</h4> 
	       	<span><a href="javascript:;" onclick="revokeAccess()">确定</a></span><span><a href="javascript:;" onclick="goWelcomePage()">取消</a></span></div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".alert").mypop();
		});
		function goWelcomePage(){
			window.parent.location.href = contextPath + '/internal/index.do';
		}
		function revokeAccess(){
			$.get('weibo/revoke.do', function(data){
				if(data == 1){
					alert("成功收回授权！");
				} else if(data == -1){
					alert("当前为未授权状态！");
				}else if(data == -2){
					alert("收回授权异常，请联系管理员！");
				} else {
					alert("收回授权失败");
				}
				window.location.href = contextPath + '/internal/welcome.do';
			}); 
		};
	</script>
</body>
</html>