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
	}
	.alert h4 {
		color: #c09853;
		font-size: 18px;
		font-family: inherit;
		font-weight: bold;
		line-height: 20px;
	}
	.alert strong a{
		font-size: 14px;
		color: #c09853;
	}
	</style>
</head>
<body style="">
	<div class="alert" style="display:none;">
	       	<h4>提示</h4>
	       	你已进行授权！如果要更改授权账号，请先进行  <strong><a href="weibo/goRevokeAccessPage.do">授权收回</a></strong> 操作！</div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		var id = '${currUser.id}';
		var accessUrl = '${accessUrl}';
		$(function(){
			$.get('weibo/sysWeibo.do?msg=' + new Date().getTime(),{
				id : id
			},function(data){
				if(data == -1){
					window.location.href = accessUrl;
	            }else if(data == -2){
	                alert("微博授权已过期，请重新授权");
	                window.location.href = accessUrl;
	            } else if(data == -3){
	            	alert("不存在的微博账号，请重新授权");
	            	window.location.href = accessUrl;
	            }else if(data == 1){
	            	$(".alert").mypop();
	            }
			});
		});
	</script>
</body>
</html>