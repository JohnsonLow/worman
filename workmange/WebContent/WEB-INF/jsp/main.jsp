<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>微博工作管理</title>
	<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'',split:true" style="height:100px;">
    	北
    </div>
    <div data-options="region:'west',title:'',split:true" style="width:200px;">
    	西
    </div>
    <div data-options="region:'center',title:''" style="padding:5px;background:#eee;">
    	中
    </div>
    <jsp:include page="/WEB-INF/jsp/easyui.jsp"></jsp:include>
</body>
</html>