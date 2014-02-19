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
    	<div class="frame_title"><p>任务管理  &gt; 任务列表</p></div>
    	<div class="cl"></div>
	  <div class="frame_cont_nav">
	    <ul>
	      <li class="frame_cont_nav_li1" id="tab_nav1" style="cursor:pointer;">
	        <p>我处理过的任务</p>
	      </li>
	      <li class="frame_cont_nav_li" id="tab_nav2" style="cursor:pointer;">
	        <p>我发起的任务</p>
	      </li>
	    </ul>
	  </div>
		<div class="cl"></div>
  	 	<div class="frame_cont" id="tab1">
    		<div class="cl"></div>
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
		                <td><input type="text" readonly="readonly" onclick="WdatePicker();"/></td>
		                <td>-</td>
		                 <td><input type="text" readonly="readonly" onclick="WdatePicker();"/></td>
		                </tr>
		                </table>
		            </td>
	          <td width="40%" class="frame_button"><input id="search1" type="button" value="搜索" class="btn"/></td>
	        </tr>
	      </table>
	    </div>
            <div class=frame_table>
           		<div class="cl"></div>
           		<table id="missionList1" width="100%" border="0" cellpadding="0"cellspacing="1" bgcolor="#CCCCCC" class="frame_table">
           			<thead>
           				<tr>
           					<th>编号</th><th>主题</th><th>状态</th><th>紧急程度</th><th>发起人</th><th>受理人</th><th>现处理人</th>
           					<th>发起时间</th><th>受理时间</th><th>完成时间</th><th>管理</th>
           				</tr>
           			</thead>
           			<tbody>
           				<tr><td colspan="11">暂无数据</td></tr>
           			</tbody>
            	</table>
            </div>
            <!--分页-->
	           <div id="pager1" class="pager"></div>
        </div>
        <div class="frame_cont" id="tab2" style="display:none;">
        	<div class="cl"></div>
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
		                <td><input type="text" readonly="readonly" onclick="WdatePicker();"/></td>
		                <td>-</td>
		                 <td><input type="text" readonly="readonly" onclick="WdatePicker();"/></td>
		                </tr>
		                </table>
		            </td>
	          <td width="40%" class="frame_button"><input id="search2" type="button" value="搜索" class="btn"/></td>
	        </tr>
	      </table>
	    </div>
            <div class=frame_table>
           		<div class="cl"></div>
           		<table id="missionList2" width="100%" border="0" cellpadding="0"cellspacing="1" bgcolor="#CCCCCC" class="frame_table">
           			<thead>
           				<tr>
           					<th>编号</th><th>主题</th><th>状态</th><th>紧急程度</th><th>发起人</th><th>受理人</th><th>现处理人</th>
           					<th>发起时间</th><th>受理时间</th><th>完成时间</th><th>管理</th>
           				</tr>
           			</thead>
           			<tbody>
           				<tr><td colspan="11">暂无数据</td></tr>
           			</tbody>
            	</table>
            </div>
            <!--分页-->
	           <div id="pager2" class="pager"></div>
        </div>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.4.2.js"></script>
	<jsp:include page="/WEB-INF/jsp/inc/preload.jsp"></jsp:include>
	<%pageContext.include("/WEB-INF/jsp/inc/pager/pagination.jsp?skin=go&number=5");%>
	<script type="text/javascript" src="../static/js/common/date/WdatePicker.js"></script>
	<script type="text/javascript" src="static/js/account/mission_list.js"></script>
	<script type="text/javascript" src="static/js/common/json/json2.js"></script>
	<script type="text/javascript" language="javascript">
		var currId = '<%= SessionUtils.getUser(request).getId()%>';
		$("#tab_nav1").click(function() {
			$("#tab_nav1").attr("class", 'frame_cont_nav_li1');
			$("#tab_nav2").attr("class", 'frame_cont_nav_li');
			$("#tab1").css("display", "block");
			$("#tab2").css("display", "none");
		});

		$("#tab_nav2").click(function() {
			$("#tab_nav2").attr("class", 'frame_cont_nav_li1');
			$("#tab_nav1").attr("class", 'frame_cont_nav_li');
			$("#tab2").css("display", "block");
			$("#tab1").css("display", "none");
		});
	</script>
</body>
</html>