var userNameReg = /^[a-zA-z0-9-_]+$/;
var mobileReg = /^(13[0-9]|15[0-9]|18[0|2|3|5|6|7|8|9])\d{8}$/;
var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
$(function(){
    initInfo();
});
function defaultPwd(){
	$("#pwd").val("000000");
	$("#conPwd").val("000000");
}
function initInfo(){
    if(userInfo){
        $("#userNameDiv").find("td").text(userInfo.userName);
        $("#pwd").val(userInfo.password);
        $("#conPwd").val(userInfo.password);
        $("#posSel").val(userInfo.pos.code);
        $("#depSel").val(userInfo.department.code);
        $("#weibo").val(userInfo.weibo);
        $("#name").val(userInfo.name);
        $("#phone").val(userInfo.phone);
        $("#titleSpan").text("修改账号");
    }else{
        userInfo = {};
        $("#titleSpan").text("添加账号");
    }
}
function addOrUpdate(){
	var pwd = $("#pwd").val();
	var cpwd = $("#conPwd").val();
	if(!userInfo || $.isEmptyObject(userInfo)){
	    var username = $("#username").val();
        if(username && $.trim(username) && userNameReg.test(username) && username.length<=20){
            $("#uidMsgSpan").text("");
            userInfo.userName = $.trim(username);
        } else {
            $("#uidMsgSpan").text("请输入正确的账号");
            return;
        }
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
	if(weibo && $.trim(weibo) && emailReg.test(weibo)){
	    $("#weiboMsgSpan").text("");
	}else{
	    $("#weiboMsgSpan").text("请输入正确的新浪微博账号");
	    return;
	}
	var name = $("#name").val();
	if(name && $.trim(name)){
	    $("#userNameMsgSpan").text("");
	}else{
	    $("#userNameMsgSpan").text("用户姓名不可为空");
	    return;
	}
	if(userInfo && !$.isEmptyObject(userInfo)){
    	if(pwd != userInfo.password){
    	    pwd = SHA1(pwd);
    	}
	}
    userInfo.department = {'code':parseInt($("#depSel").val(),10)};
	// var level = $("#level").val();
	userInfo.password = pwd;
	userInfo.pos = {'code':parseInt($("#posSel").val(),10)};
	userInfo.phone = $("#phone").val();
	userInfo.name = name;
	userInfo.weibo = weibo;
	$.ajax({ cache:false,
			type : 'post',
			url : 'account/addOrUpdateAccount.do',
			contentType:"application/json",
			data:   JSON.stringify(userInfo),
		    success:function(data){
		    	if(data == '1'){
		    		alert("保存成功");
		    		window.location.href = contextPath + "/account/goAccountPage.do";
		    	}else if(data =='-401'){
		    	    goLoginPage();
		    	}else{
		    	    alert("保存失败，可能已存在相同的用户名");
		    	}
		    }});
}