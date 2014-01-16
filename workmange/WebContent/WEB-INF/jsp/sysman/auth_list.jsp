<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>帐号管理</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
</head>

<body> 
<div class="frame" style="position: absolute;">
    	<div class="frame_title"><p>操作员管理  &gt; 权限管理</p></div>
    	<div class="cl"></div>
        <div id="lgdiv" style="display:block;" class="frame_cont">
        	<div style="background:none;" class="frame_title">
            	<span style="float:left;">帐号列表</span>
	            <span style="float:right; margin-right:10px;"><a href="javascript:;" onclick="goAccountInfo(1);">添加权限</a></span>
            	<span id="selectDiv" style="float:right;">
	            	<span><a href="javascript:void(0)" onclick="checkAll()">全选</a></span>
                    <span style="margin-left: 10px;"><a href="javascript:;" onclick="delSysUser()">删除</a></span>
	            	<span style="color:#404040; margin:0 10px;"><a href="javascript:;">|</a></span>
	             </span>
            </div>
            <div class=frame_table>
           		<div class="cl"></div>
           		<table id="authList" width="100%" border="0" cellpadding="0"cellspacing="1" bgcolor="#CCCCCC" class="frame_table">
           			<thead>
           				<tr>
           				<th>选中</th><th>权限等级</th><th>权限描述</th><th>管理</th>
           				</tr>
           			</thead>
           			<tbody>
           				<tr><td colspan="4">暂无数据</td></tr>
           			</tbody>
            	</table>
            </div>
            <!--分页-->
	           <div id="pager" class="pager"></div>
        </div>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<%pageContext.include("/WEB-INF/jsp/inc/pager/pagination.jsp?skin=go&number=5");%>
	<jsp:include page="/WEB-INF/jsp/inc/preload.jsp"></jsp:include>
	<script type="text/javascript" src="static/js/sysman/auth.js"></script>
	<script type="text/javascript" src="static/js/common/json/json2.js"></script>
	<script type="text/javascript" language="javascript">
		function showDiv(){
			document.getElementById('lgdiv').style.display='block';
		}
	</script>
</body>
</html>