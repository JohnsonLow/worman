<%@page import="org.apache.commons.configuration.tree.UnionCombiner"%>
<%@page import="com.selfservice.permission.util.SessionUtil"%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.selfservice.permission.po.CompanyUser"%>
<%@page import="com.selfservice.agent.soap.union.UserModel"%>
<%@page import="com.selfservice.agent.soap.union.UnionChildModel"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.net.URLEncoder"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../static/js/jquery-1.4.2.js"></script>
<script type="text/javascript" language="javascript">
function showList(obj,index){
	if(!index){
		index = 0;
	}
	var clazz = $(obj).attr("class");
	var toToggle = $(obj).parent().parent().find("div[class='dlist']").eq(index);
	toToggle.toggle();
	if(clazz == "dv"){
		$(obj).attr("class","dv2");
	}else if(clazz == "dv2"){
		$(obj).attr("class","dv");
	}else{
		if(toToggle.css("display") != "none"){
			$(obj).parent().find("img").attr("src","../static/images/news/folding.gif");
		}else{
			$(obj).parent().find("img").attr("src","../static/images/news/expand.gif");
		}
	}
}
</script>

</head>

<body>
<div class="leftarea">
	<div class="sv3">
		<%
	        String sysUnionCode = request.getAttribute("sysUnionCode").toString();
			String typeParam = SessionUtil.SYSTEM_TYPE + "_" + sysUnionCode;
	        String type = null;
	        Object typeObj = session.getAttribute(typeParam);
	        if(typeObj == null){
	        	type = SessionUtil.SYSTEM_TYPE_SELF;
	        }else{
	        	type = typeObj.toString();
	        }
	        CompanyUser cuser = SessionUtil.getCompanyUser(request);
	       	UserModel user = cuser.getUser();
	       	Map<String, List<UnionChildModel>> children = cuser.getChildCompany();
		%>
		 <%List<UnionChildModel> childs = children.get("12");
    if(childs != null){ %>
    <!-- 销售用户管理 -->
     <div class="d1">
        	<%if(childs.size()==1){ %>
        		<div class="d2">
                <div class="dv2" onclick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/SalesManagement/goSalesManagementPage.do?channelPk=", childs.get(0)) %>'">
                	<img align="absmiddle" src="../static/images/news/menu_icon1.gif"/>用户管理</div>
            </div>
        	<%}else{ %>
            <div class="d2">
                <div class="dv2" onclick="showList(this)">
                	<img align="absmiddle" src="../static/images/news/menu_icon1.gif"/>用户管理</div>
            </div>
            <div class="dlist" style="display: none;">
            <%for(UnionChildModel child: childs){
            		String comName = child.getObjectName();
	                if(comName.length()>8){
	                	comName = comName.substring(0,8) +"...";
	                }%>
                <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/SalesManagement/goSalesManagementPage.do?channelPk=", child) %>'"><div class="ds1"><%=comName %></div></a>
                </div>
             <%} %>
            </div>
       <%}%>
       </div>  
       <!-- 维修保养 -->
   	 <div class="d1">
            <div class="d2">
                <div class="dv2" onclick="showList(this)">
                	<img align="absmiddle" src="../static/images/news/menu_icon2.gif"/>维修保养</div>
            </div>
            <div class="dlist" style="display: none;">
            <% if(childs.size() == 1){
            	UnionChildModel child = childs.get(0);
            %>
            	<div class="d3">
	                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/Maintenance/goMaintenancePage.do?channelPk=",  child) %>'"><div class="ds1">保养临期车辆</div></a>
	               	 </div>
	               	 <div class="d3">
	                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/Maintenance/goMaintenanceCarPage.do?channelPk=",  child) %>'"><div class="ds1">当前故障车辆</div></a>
	               	</div>
	               	<div class="d3">
	                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/Maintenance/goAppointmentPage.do?channelPk=",  child) %>'"><div class="ds1">保养预约车辆</div></a>
	                </div>
            <% }else{
            	for(int i=0;i<childs.size();i++){
            		UnionChildModel child = childs.get(i);
            		String comName = child.getObjectName();
	                if(comName.length()>8){
	                	comName = comName.substring(0,8) +"...";
	                }%>
                <div class="d3"">
                   <div class="ds1" onclick="showList(this,'<%=i%>')" style="cursor: pointer;">
                   <img align="absmiddle" src="../static/images/news/expand.gif"/>
                   <%=comName %></div>
                </div>
                 <div class="dlist" style="display: none;">
	                 <div class="d3">
	                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/Maintenance/goMaintenancePage.do?channelPk=",  child) %>'"><div class="ds2">保养临期车辆</div></a>
	               	 </div>
	               	 <div class="d3">
	                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/Maintenance/goMaintenanceCarPage.do?channelPk=",  child) %>'"><div class="ds2">当前故障车辆</div></a>
	               	 </div>
               	 	<div class="d3">
	                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/Maintenance/goAppointmentPage.do?channelPk=",  child) %>'"><div class="ds2">保养预约车辆</div></a>
	                </div>
                 </div>
                <%}}%>
            </div>
       </div>
       <%}%>
    	<div class="d1">
            <div class="d2">
                <div class="dv2" onclick="showList(this)">
                	<img align="absmiddle" src="../static/images/news/menu_icon3.gif"/>车辆诊断</div>
            </div>
            <div class="dlist" style="display: none;">
                <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/Diagnosis/goDiagnosisPage.do?",  null) %>'"><div class="ds1">车况检测</div></a>
                </div>
                <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/Diagnosis/goDiagnosisCarPage.do?",  null) %>'"><div class="ds1">故障诊断</div></a>
                </div>
            </div>
       </div>   
       	<!-- 智驾救援 -->
        <%List<UnionChildModel> resChilds = children.get("10");
        if(resChilds != null){ %>
       		<div class="d1">
       		<%if(resChilds.size() == 1){ 
       		%>
       			<div class="d2">
                	<div class="dv2" onclick="window.parent.mainFrame.location='<%= SessionUtil.getMenuUrl(request, "/rescueInfoMsg/goRescueSearchPage.do?agencyId=",  resChilds.get(0)) %>'">
                	<img align="absmiddle" src="../static/images/news/menu_icon4.gif"/>车辆救援</div>
            	</div>
       		<%}else{ %>
		        <div class="d2">
                	<div class="dv2" onclick="showList(this)">
                	<img align="absmiddle" src="../static/images/news/menu_icon4.gif"/>车辆救援</div>
            	</div>
            	<div class="dlist" style="display: none;">
            		<%for(UnionChildModel child : resChilds){
	            		String comName = child.getObjectName();
		                if(comName.length()>8){
		                	comName = comName.substring(0,8) +"...";
		                }%>
	                <div class="d3">
	                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/rescueInfoMsg/goRescueSearchPage.do?agencyId=", child) %>'"><div class="ds1"><%=comName %></div></a>
	                </div>
	                <%} %>
           		</div>
           		<%} %>
        	</div>
    <% }%>   
      <!-- 获取智驾商城商户菜单 -->
    <%List<UnionChildModel> shopChilds = children.get("8");
        if(shopChilds != null){%>
       		<div class="d1">
           		<% if(shopChilds.size() == 1){%>
           			<div class="d2">
                	<div class="dv2" onclick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/shopOrder/goShoppingOrderListPage.do?shopId=",  shopChilds.get(0))%>'">
                		<img align="absmiddle" src="../static/images/news/menu_icon2.gif"/>智驾商城</div>
           			</div>
           		<%}else{ %>
		        <div class="d2">
                	<div class="dv2" onclick="showList(this)">
                		<img align="absmiddle" src="../static/images/news/menu_icon2.gif"/>智驾商城</div>
           		</div>
           		<div class="dlist" style="display: none;">
           			<%for(UnionChildModel child : shopChilds){
           			String comName = child.getObjectName();
		                if(comName.length()>8){
		                	comName = comName.substring(0,8) +"...";
		                }%>
	                <div class="d3">
	                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/shopOrder/goShoppingOrderListPage.do?shopId=",  child) %>'"><div class="ds1"><%=comName %></div></a>
	                </div>
	                <%} %>
           		</div>
           		<%} %>
        	</div>
        <%}%> 
        <div class="d1">
            <div class="d2">
                <div id="czygl" class="dv2" onclick="showList(this)">
                	<img align="absmiddle" src="../static/images/news/menu_icon5.gif"/>服务通知</div>
            </div>
            <div class="dlist" style="display: none;">
            	<div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/ServiceInform/goMessagePage.do?", null)%>'"><div class="ds1">短信通知</div></a>
                </div>
                <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/ServiceInform/goAppPage.do?", null)%>'"><div class="ds1">APP通知</div></a>
                </div>
            </div>
       	</div>
       	<div class="d1">
            <div class="d2">
                <div id="czygl" class="dv2" onclick="showList(this)">
                	<img align="absmiddle" src="../static/images/news/menu_icon6.gif"/>系统管理</div>
            </div>
            <div class="dlist" style="display: none;">
            <!-- 
          		<div class="d3">
                    <a href="javascript:void(0)" target="mainFrame"><div class="ds1">权限设置</div></a>
                </div>
             -->
                <%
               	if(user.getLevel() !=null && user.getLevel() == 1){
                %>
                <div class="d3">
                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/OperatorManagement/goAccountManagePage.do?", null) %>'"><div class="ds1">二级帐号管理</div></a>
                </div>
                <%}%>
                <div class="d3">
                   <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/OperatorManagement/goInfoModifyPage.do?", null) %>'"><div class="ds1">密码修改</div></a>
                </div>
                <% if(type.equals(SessionUtil.SYSTEM_TYPE_4S)){%>
	                <div class="d3">
	                    <a href="javascript:void(0)" onClick="window.parent.mainFrame.location='<%=SessionUtil.getMenuUrl(request, "/OperatorManagement/goSInfoModifyPage.do?", null)%>'"><div class="ds1">资料修改</div></a>
	                </div>
                <%} %>
            </div>
        </div>
    </div>
    <div style="clear:both;"></div>
</div>
</body>
</html>