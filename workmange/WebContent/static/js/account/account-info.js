/**
 * 添加或修改二级账号
 */
var mobileReg = /^(13[0-9]|15[0-9]|18[0|2|3|5|6|7|8|9])\d{8}$/;
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
	if(username && $.trim(username)){
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
	var userName = $("#userName").val();
	var newInfos = {};
	newInfos.uid = newUid;
	if(oldPwd != pwd){
		newInfos.password = SHA1(pwd);
	} else {
		newInfos.password = pwd;
	}
	var level = $("#level").val();
	if(!level){
		level = "2";
	}
	newInfos.userName = $.trim(userName);
	newInfos.level = level;
	newInfos.createTime = $("#createTime").val();
	newInfos.updateTime = $("#updateTime").val();
	newInfos.unionCode = unionCode;
	var msg = "";
	if(uid){
		msg="修改账户";
	} else {
		msg="添加账户";
	}
	$.ajax({ cache:false,
			type : 'post',
			url : url,
			contentType:"application/json",
			data:   JSON.stringify(newInfos),
		    success:function(data){
		    	if(data == '-1'){
		    		alert(msg + "失败，请联系工作人员");
		    	} else if(data == '-2'){
		    		alert("该账号已存在");
		    		$("#uidInput").focus();
		    	}else{
		    		alert("成功" + msg);
		    		window.location.href="goAccountManagePage.do?sysUnionCode="+unionCode;
		    	}
		    }});
}