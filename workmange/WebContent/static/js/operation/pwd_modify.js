/**
 * 修改当前登录的用户信息
 */
var uid;
$(function(){
	 uid = $("#uid").text();
	if(uid){
		$("#titleSpan").text("密码修改");
	} else{
		$("#titleSpan").text("增加新帐号");
		$("#uidDiv").hide();
		$("#timeInfo").hide();
	}
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
	}
	
	if(!npwd){
		$("#npwdMsgSpan").text("请输入新密码并确认");
		$("#cpwdMsgSpan").text("请输入密码并确认");
		return;
	}
	if(!cpwd){
		$("#cpwdMsgSpan").text("请确认密码");
		return;
	}
	if(cpwd != npwd){
		$("#cpwdMsgSpan").text("两次输入密码不一致，请重新输入");
		return;
	}
	var userName = $("#userName").val();
	var newInfos = {};
	newInfos.uid = uid;
	newInfos.password = SHA1(npwd);
	newInfos.userName = $.trim(userName);
	newInfos.level = $("#level").val();
	newInfos.createTime = $("#createTime").val();
	newInfos.updateTime = $("#updateTime").val();
	var level = $("#unionCode").val();
	if(!level){
		level = "2";
	}
	var msg = "";
	if(uid){
		msg="修改账户";
	} else {
		msg="添加账户";
	}
	newInfos.unionCode = level;
	$.ajax({ cache:false,
			type : 'post',
			url : "updateAccountInfo.do",
			contentType:"application/json",
			data:   JSON.stringify(newInfos),
		    success:function(data){
		    	if(data){
		    		alert("修改成功");
		    		window.parent.location.href="../4s/enterprise.do?sysUnionCode=" + uid;
		    	} else{
		    		alert(msg + "失败，请联系工作人员");
		    	}
		    }});
}