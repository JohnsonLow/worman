<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>新浪微博工作管理系统</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
<style type="text/css">
	tr{
		line-height: 50px;
		font-size: 14px;
	}
</style>
<jsp:include page="/WEB-INF/jsp/easyui.jsp"></jsp:include>
</head>
<body>
	<div id="loginDiv" class="easyui-panel" title="登陆" style="width:400px">
		<div style="padding:10px 0 10px 60px">
	    <form id="ff" method="post">
	    	<table>
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input class="easyui-validatebox" type="text" name="name" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td><input class="easyui-validatebox" type="password" name="password" data-options="required:true"></input></td>
	    		</tr>
	    	</table>
	    </form>
	    </div>
    </div>
    <script>
	   $("#loginDiv").dialog({
			modal : true,
			closable : false,
			buttons : [ {
				text : '登录',
				handler : function() {
					loginFun();
				}
			} ]
		});
	   function loginFun(){
			if ($("#ff").form('validate')) {
				$.messager.progress({
					title : '提示',
					text : '登陆中....'
				});
				var params = $("#ff").serialize();
				$.post('sysLogin.do',params,function(data){
					$.messager.progress('close');
					if(data == '1'){
						window.location.href="main.do";
					}
				});
			}
	   }
    </script>
</body>
</html>