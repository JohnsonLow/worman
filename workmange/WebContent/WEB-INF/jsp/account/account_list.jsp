<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>帐号管理</title>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
<style>
	.btn{
		cursor:pointer;
	}
</style>
</head>

<body> 
<div class="frame" style="position: absolute;">
    	<div class="frame_title"><p>操作员管理  &gt; 帐号管理</p></div>
    	<div class="cl"></div>
        <div id="lgdiv" style="display:block;" class="frame_cont">
        	<div class="frame_cont_list_input">
		      <table width="100%" border="0" cellspacing="0" cellpadding="0">
		        <tr>
		          <td width="20%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <th>权限类别：</th>
		                <td><select id="authSel" style="width:100px;">
		                		<option value="">--请选择--</option>
						  		<c:forEach var="auth" items="${authList }">
						  			<option value="${auth.level }">${ auth.name}</option>
						  		</c:forEach>
						  	</select>
		                </td>
		              </tr>
		            </table></td>
		          <td width="20%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <th>所在部门：</th>
		                <td><select id="depSel" style="width:100px;">
		                		<option value="">--请选择--</option>
						  		<c:forEach var="dep" items="${depList }">
						  			<option value="${dep.code }">${ dep.name}</option>
						  		</c:forEach>
						  	</select></td>
		              </tr>
		            </table></td>
	          <td width="20%"><table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <th align="center">姓名：</th>
	                <td><input id="name"/></td>
	              </tr>
	            </table></td>
	          <td width="40%" class="frame_button"><input id="search" type="button" value="搜索" class="btn"/></td>
	        </tr>
	      </table>
	    </div>
        	<div style="background:none;" class="frame_title">
            	
	            <span style="float:right; margin-right:10px;"><a href="javascript:;" onclick="goAccountInfo(1);">添加新账号</a></span>
            </div>
            <div class=frame_table>
           		<div class="cl"></div>
           		<table id="userList" width="100%" border="0" cellpadding="0"cellspacing="1" bgcolor="#CCCCCC" class="frame_table">
           			<thead>
           				<tr>
           					<th>账号</th><th>姓名</th><th>权限</th><th>所在部门</th><th>联系电话</th><th>微博账号</th><th>管理</th>
           				</tr>
           			</thead>
           			<tbody>
           				<tr><td colspan="8">暂无数据</td></tr>
           			</tbody>
            	</table>
            </div>
            <!--分页-->
	           <div id="pager" class="pager"></div>
        </div>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<jsp:include page="/WEB-INF/jsp/inc/preload.jsp"></jsp:include>
	<%pageContext.include("/WEB-INF/jsp/inc/pager/pagination.jsp?skin=go&number=5");%>
	<script type="text/javascript" src="static/js/account/account-list.js"></script>
	<script type="text/javascript" src="static/js/common/json/json2.js"></script>
	<script type="text/javascript" language="javascript">
		var userList = '${userList}';
		var unionCode = "${unionCode}";
		function showDiv(){
			document.getElementById('lgdiv').style.display='block';
		}
	</script>
</body>
</html>