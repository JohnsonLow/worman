<%@ page language="java"  pageEncoding="utf-8"%>
<%

    if("small".equals(request.getParameter("skin")))
    {
    
    	%>
    	<link href="<%=request.getContextPath()%>/static/css/jquery-pager/Pager1.css" rel="stylesheet" type="text/css" />
    	<script id="pagerJS" src="<%=request.getContextPath()%>/static/js/common/jquery-pager/jquery.pager.js?number=<%=request.getParameter("number") %>&&glo_path=<%=request.getContextPath()%>" type="text/javascript"></script>
    	
    	<%
    }else if("go".equals(request.getParameter("skin")))
    {
       %>
        <link href="<%=request.getContextPath()%>/static/css/jquery-pager/Pager_go.css" rel="stylesheet" type="text/css" />
        <script id="pagerJS" src="<%=request.getContextPath()%>/static/js/common/jquery-pager/jquery.pager.go.js?number=<%=request.getParameter("number") %>&&glo_path=<%=request.getContextPath()%>" type="text/javascript"></script>
   <%}else if("arrow".equals(request.getParameter("skin")))
    {
       %>
        <link href="<%=request.getContextPath()%>/static/css/jquery-pager/Pager2.css" rel="stylesheet" type="text/css" />
        <script id="pagerJS" src="<%=request.getContextPath()%>/static/js/common/jquery-pager/jquery.pager.2.js?number=<%=request.getParameter("number") %>&&glo_path=<%=request.getContextPath()%>" type="text/javascript"></script>
   <%}else { %>

        <link href="<%=request.getContextPath()%>/static/css/jquery-pager/Pager.css" rel="stylesheet" type="text/css" />
        <script id="pagerJS" src="<%=request.getContextPath()%>/static/js/common/jquery-pager/jquery.pager.js?number=<%=request.getParameter("number") %>&&glo_path=<%=request.getContextPath()%>" type="text/javascript"></script>
         
  <%}%>
