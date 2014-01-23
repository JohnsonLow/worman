/**
 * 添加或修改账号
 */
var type = 1;
var userNameReg = /^[a-zA-z0-9-_]+$/;
$(function(){
    
});
function defaultPwd(){
	$("#pwd").val("000000");
	$("#conPwd").val("000000");
}
function addOrUpdate(){
	var pwd = $("#pwd").val();
	var cpwd = $("#conPwd").val();
	var username = $("#username").val();
	if(username && $.trim(username) && userNameReg.test(username)){
		$("#uidMsgSpan").text("");
	} else {
		$("#uidMsgSpan").text("请输入正确的账号");
		return;
	}
	if(!pwd){
		$("#pwdMsgSpan").text("请输入密码并确认");
		$("#cpwdMsgSpan").text("请输入密码并确认");
		return;
	} else {
		$("#pwdMsgSpan").text("");
		$("#cpwdMsgSpan").text("");
	}
	if(!cpwd){
		$("#cpwdMsgSpan").text("请确认密码");
		return;
	}else{
		$("#cpwdMsgSpan").text("");
	}
	if(cpwd != pwd){
		$("#cpwdMsgSpan").text("两次输入密码不一致，请重新输入");
		return;
	} else {
		$("#cpwdMsgSpan").text("");
	}
	var weibo = $("#weibo").val();
	if(weibo && $.trim(weibo)){
	    $("#weiboMsgSpan").text("");
	}else{
	    $("#weiboMsgSpan").text("微博账号不可为空");
	    return;
	}
	var newInfos = {};
	if(pwd != oldPwd){
	    pwd = SHA1(pwd);
	}
	var level = $("#level").val();
	newInfos.userName = $.trim(username);
	newInfos.password = pwd;
	newInfos.auth = {'level':parseInt($("#authSel").val(),10)};
	newInfos.department = {'code':parseInt($("#depSel").val(),10)};
	newInfos.phone = $("#phone").val();
	newInfos.name = $("#name").val();
	newInfos.weibo = weibo;
	alert(JSON.stringify(newInfos));
	$.ajax({ cache:false,
			type : 'post',
			url : 'account/addOrUpdateAccount.do?type='+type,
			contentType:"application/json",
			data:   JSON.stringify(newInfos),
		    success:function(data){
		    	if(data == '-1'){
		    		alert("保存失败，请联系工作人员");
		    	} else if(data == '-2'){
		    		alert("该账号已存在");
		    		$("#uidInput").focus();
		    	}else{
		    		alert("保存成功");
		    		window.location.href = contextPath + "/account/goAccountPage.do";
		    	}
		    }});
}