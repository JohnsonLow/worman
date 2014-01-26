/**
 * 修改当前登录的用户信息
 */
$(function(){
       
});
function defaultPwd(){
	$("#npwd").val("000000");
	$("#conPwd").val("000000");
}
function addOrUpdate(){
	var uid =$("#uid").text();
	var pwd = $("#pwd").val();
	var npwd = $("#npwd").val();
	var cpwd = $("#conPwd").val();
	if(SHA1(pwd) != oldPwd && pwd != oldPwd){
		$("#pwdMsgSpan").text("原密码不正确，请重新输入");
		return;
	}else{
	    $("#pwdMsgSpan").text("");
	}
	
	if(!npwd){
		$("#npwdMsgSpan").text("请输入新密码并确认");
		$("#cpwdMsgSpan").text("请输入密码并确认");
		return;
	}else{
	    $("#npwdMsgSpan").text("");
	    $("#cpwdMsgSpan").text("");
	}
	if(!cpwd){
		$("#cpwdMsgSpan").text("请确认密码");
		return;
	}else{
	    $("#cpwdMsgSpan").text("");
	}
	if(cpwd != npwd){
		$("#cpwdMsgSpan").text("两次输入密码不一致，请重新输入");
		return;
	}else{
	    $("#cpwdMsgSpan").text("");
	}
	var newInfos = {};
	newInfos.id = uid;
	newInfos.password = SHA1(npwd);
	$.get("operation/updatePwd.do?msg="+new Date().getTime(),
	   newInfos,function(data){
	    if(data){
	        alert("修改成功");
	        window.location.reload();
	    }else{
	        alert("修改失败，请联系工作人员");
	    }
	});
}