<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="/WEB-INF/jsp/meta.jsp"></jsp:include>
<script type="text/javascript">
	/* 设为首页 */
	function setMyHome() {  
		  if (document.all) {  
		    document.body.style.behavior='url(#default#homepage)';  
		    document.body.setHomePage('http://workman.duapp.com');  
		  } else if (window.sidebar) {  
		    if(window.netscape) {  
		        try {
		            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");    
		        } catch (e) {    
		            alert( "该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true" );
		        }
		    }   
		    var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components. interfaces.nsIPrefBranch);  
		    prefs.setCharPref('browser.startup.homepage','http://workman.duapp.com');
		  }
	}  
	/* 添加收藏  */  
	function addCookie() {  
	    if (document.all) {  
	        window.external.addFavorite('http://workman.duapp.com', '微博任务管理系统');  
	    } else if (window.sidebar) {  
	        window.sidebar.addPanel('微博任务管理系统', 'http://workman.duapp.com', "");  
	    }  
	} 
</script>
</head>

<body>

<div class="bottom">
    <p> 刘雨薇© 版权所有 Version: V1.0 | <a href="mailto::237728565@qq.com" style="color: #0079CA;text-decoration: none;">联系我</a></p>
</div>
</body>
</html>