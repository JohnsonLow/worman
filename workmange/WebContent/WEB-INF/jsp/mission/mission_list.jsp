<%@page import="com.workman.permission.util.SessionUtils"%>
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
    	<div class="frame_title"><p>任务管理  &gt; <span id="title"></span></p></div>
		<div class="cl"></div>
  	 	<div class="frame_cont">
    		<div class="cl"></div>
    		<c:if test="${searchType > 1 }">
    			<div class="frame_cont_list_input">
			      <table width="100%" border="0" cellspacing="0" cellpadding="0">
			        <tr>
			          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			              <tr>
			                <th>紧急程度：</th>
			                <td>
			                <select id="lelelSel" style="width:100px;">
			                		<option value="">全部</option>
							  		<option value="普通">普通</option>
							  		<option value="中等">中等</option>
							  		<option value="紧急">紧急</option>
							  	</select>
						  	</td>
			              </tr>
			            </table></td>
			            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
			              <tr>
			                <th>状态：</th>
			                <td>
			                <select id="staSel" style="width:100px;">
			                		<option value="">全部</option>
							  		<option value="1">待处理</option>
							  		<option value="2">处理中</option>
							  		<option value="3">已完成</option>
							  	</select>
						  	</td>
			              </tr>
			            </table></td>
			            <td>
			            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			              	<tr>
			                <th>创建时间：</th>
			                <td><input type="text" readonly="readonly" onclick="WdatePicker();"/><span style="margin:0 5px;">-</span><input type="text" readonly="readonly" onclick="WdatePicker();"/></td>
			                </tr>
			                </table>
			            </td>
		          <td width="30%" class="frame_button"><input id="search1" type="button" value="搜索" class="btn"/></td>
		        </tr>
		      </table>
		    </div>
    		</c:if>
            <div class=frame_table>
           		<div class="cl"></div>
           		<table id="missionList" width="100%" border="0" cellpadding="0"cellspacing="1" bgcolor="#CCCCCC" class="frame_table">
           			<thead>
           				<tr>
           					<th>编号</th><th>主题</th><th>状态</th><th>紧急程度</th><th>发起人</th><th>受理人</th>
           					<th>发起时间</th><th>受理时间</th><th>完成时间</th><th>管理</th>
           				</tr>
           			</thead>
           			<tbody>
           				<tr><td colspan="10">暂无数据</td></tr>
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
	<script type="text/javascript" src="static/js/common/date/WdatePicker.js"></script>
	<script type="text/javascript" src="static/js/mission/mission_list.js"></script>
	<script type="text/javascript" src="static/js/mission/mission_utils.js"></script>
	<script type="text/javascript" src="static/js/common/json/json2.js"></script>
	<script type="text/javascript" language="javascript">
		var currId = '${currUser.id}';
		var searchType = '${searchType}';
	</script>
</body>
</html>