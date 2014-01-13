<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资料修改</title>
<link href="../static/css/style.css" rel="stylesheet" type="text/css" />
<link href="../static/css/elements.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../static/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="../static/js/internal/infoModify.js"></script>
<script type="text/javascript" language="javascript">
function showDiv(){
document.getElementById('lgdiv').style.display='block';
}
$(function(){
	var userId = "${intCompanyUser.userId}";
	var userName = "${intCompanyUser.userName}";
	var passWord = "${intCompanyUser.passWord}";
	var userIdentity = "${intCompanyUser.userIdentity}";
	sysUserInfo(userId);
	$("#btn-tj").click(function(){
		sysUserUpdate(userId,userName,passWord,userIdentity);
	});
});
</script>
</head>

<body> 
<div class="authority-top">
	<div class="info">
    	<div class="info-top">资料修改</div>
        <div class="info-content">
            <div class="infocontL"></div>
            <!--内容-->
            <div class="infocontR">
            	<div class="inform">
                	<div class="infoL">登录帐号：</div>
                    <div class="infoR">
                    	<span>${intCompanyUser.userName}</span>
                  	</div>
                </div>
                <div class="inform">
                	<div class="infoL">所属单位：</div>
                    <div class="infoR"><input type="text" class="txt-log-date" style="width:300px;" value="" /></div>
                </div>
                <div class="inform">
                	<div class="infoL">真实姓名：</div>
                    <div class="infoR"><input type="text" class="txt-log-date" style="width:160px;" value="" /></div>
                </div>
                <div class="inform">
                	<div class="infoL">联系电话：</div>
                    <div class="infoR"><input type="text" class="txt-log-date" style="width:160px;" /></div>
                </div>
                <div class="inform">
                	<div class="infoL">地址：</div>
                    <div class="infoR"><input type="text" class="txt-log-date" style="width:300px;" /></div>
                </div>
                <div class="inform">
                	<div class="infoL">邮编：</div>
                    <div class="infoR"><input type="text" class="txt-log-date" style="width:160px;" /></div>
                </div>
                <div class="inform">
                	<div class="infoL">电子邮箱：</div>
                    <div class="infoR"><input type="text" class="txt-log-date" style="width:160px;" /></div>
                </div>
                <div class="inform">
                	<div class="infoL">备注：</div>
                    <div class="infoR"><input type="text" class="txt-log-date" style="width:300px;" /></div>
                </div>
            </div><!--内容end-->
        </div>
        <div class="info-foot" style=" margin-top:30px;padding-top:10px; border-top:1px solid #ccc;">
            <span style="margin-left:180px;"><input type="button" id="btn-tj" class="btn-tj" value=" " /></span>
            
        </div>
    </div>
    <div style="clear:both;"></div>
</div>
</body>
</html>
