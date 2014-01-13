<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	/* 设为首页 */
	function setMyHome() {  
		  if (document.all) {  
		    document.body.style.behavior='url(#default#homepage)';  
		    document.body.setHomePage('http://www.yesway.cn/partner/internal/enterprise.do');  
		  } else if (window.sidebar) {  
		    if(window.netscape) {  
		        try {
		            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");    
		        } catch (e) {    
		            alert( "该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true" );
		        }
		    }   
		    var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components. interfaces.nsIPrefBranch);  
		    prefs.setCharPref('browser.startup.homepage','http://www.yesway.cn/partner/internal/enterprise.do');
		  }
	}  
	/* 添加收藏  */  
	function addCookie() {  
	    if (document.all) {  
	        window.external.addFavorite('http://www.yesway.cn/partner/internal/enterprise.do', '智驾网企业信息管理系统');  
	    } else if (window.sidebar) {  
	        window.sidebar.addPanel('智驾网企业信息管理系统', 'http://www.yesway.cn/partner/internal/enterprise.do', "");  
	    }  
	} 
</script>
</head>

<body>

<div class="bottom">
    <p>北京九五智驾信息技术股份有限公司  © 版权所有 Version: V1.1.6</p>
</div>
</body>
</html>