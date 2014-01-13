<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>智驾4s服务系统</title>
<link href="../static/css/elements.css" rel="stylesheet" type="text/css" />
<link href="../static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../static/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="../static/js/sha-1.js"></script>
<script type="text/javascript" src="../static/js/internal/internal.js"></script>
<!--[if IE 6]>
        <script type="text/javascript" src="http://www.techweb.com.cn/img/newsite/DD_belatedPNG.js" ></script>
        <script type="text/javascript">
            DD_belatedPNG.fix('.logmcont-1');
            </script>
            <![endif]-->
<script language="javascript" type="text/javascript">
$(function(){
     $("#logform-2").click(function(){
     	getSysLoginValidator();
     });

});
 function loginSubmit(jumpurl){
    if('${returnUrl}'){
		location.href='${returnUrl}';
    }else
    {
        location.href=jumpurl;
    }
   
    	
}
</script>
<script type="text/javascript">
	
	function loginsubmit(event){
	  var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode; 
		  if (keyCode == 13) { 
		   //处理函数 
		  getSysLoginValidator();
		  } 
	
	}
</script>
</head>
<body onKeyDown="loginsubmit(event)">
	
                        	
<div class="bgpic4s" style="position:relative;">
	 <div class="i-tip"  style="left: 750px; top: 82px;display:none; "><p></p><span></span></div>
     <div class="i-tip"  style="left: 750px; top: 152px;display:none; "><p></p><span></span></div>
     <div class="i-tip"  style="left: 600px; top: 222px;display:none; "><p></p><span></span></div>
	 <div class="i-tip"  style="left: 650px; top: 82px;display:none; "><p></p><span></span></div>
	<p><input name="" type="text" id="txt-lg-1"  class="input_text420 fc" value="用户名"/></p>
	<p style="height:50px;">
		
	<input name="" type="text"  id="txt-lg-2"  class="input_text420 fc" value="密码"/>
	<input name="" type="password"  style="display:none;position:absolute;left:435px;top:185px;" id="txt-lg-22"  class="input_text420 fc" value="密码"/>
	
	</p>
  	<p>
  		<input name="" id="txt-lg-3" type="text" class="input_text270 fc" value="验证码"/> 
	  <a href="javascript:;"> <img  align="absmiddle" id="verificationCodeImg" style="border:0px;" src="../validateCodeServlet?code=enterprise" onclick="this.src='../validateCodeServlet?code=enterprise&yys='+new Date().getTime()"></a>
	</p>
  	<p class="btn_login" id="logform-2"><a href="javascript:;"></a></p>
</div>
	<p class="footer130819">北京九五智驾信息技术股份有限公司  ©版权所有 Version: V1.1.6</p>
</body>
</html>
