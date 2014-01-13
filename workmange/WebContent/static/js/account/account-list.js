$(function(){
	if(userList){
		userList = JSON.parse(userList);
		initInfos();
	} else {
		$("#selectDiv").hide();
	}
});
var checkFlag = true;
function initInfos(){
	if(userList.length == 0){
		$("#selectDiv").hide();
		$("#userList").empty();
		$("#userList").append("<tr><th>暂无数据</th></tr>");
	}
	for(var i=0,len=userList.length;i<len;i++){
		var user = userList[i];
		var editUrl = '../OperatorManagement/goAccountInfoPage.do?uid='+user.uid+'&sysUnionCode='+unionCode;
		var res = '<tr>'+
                	'<td><input name="cbox" type="checkbox" style="margin-top:10px;border:0px;" value="'+user.uid+'"/></td>'+
                   	'<td>'+user.username+'</td>'+
                   	'<td>'+user.name+'&nbsp;</td>'+
                   	'<td>'+user.level+'</td>'+
                   	'<td>'+user.department+'</td>'+
                   	'<td>'+user.phone+'</td>'+
                   	'<td>'+user.weibo+'</td>'+
                    '<td>'+
                    	'<span><a href="'+editUrl+'">编辑</a></span><span style="margin:0 10px; cursor:auto;">/</span>'+
                        '<span><a href="javascript:;" onclick="delUser(\''+user.uid+'\')">删除</a></span>'+
                        '<span style="width:65px; height:10px;"></span>'+
                    '</td>'+
                '</tr>';
         $("#userList").find('tbody').append(res);
	}
}
function goAccountInfo(type) {
	window.location = "account/goAccountInfoPage.do?type="+type;
}
function delUser(uid){
	var msg = '成功删除';
	if(uid.charAt(",") < 0){
		msg = msg+ uid;
	} else {
		msg = msg + "选定的账号";
	}
	if(confirm("确定删除账号?")){
		$.get("delAccount.do?uid=" + uid +'&dt='+new Date().getTime(),
			function(data){
				if(data){
					alert(msg);
					window.location = "../OperatorManagement/goAccountManagePage.do?sysUnionCode="+unionCode;;
				} else {
					alert("执行删除操作出错，请联系工作人员");
				}
			});
	}
}
function checkAll(){
    if(checkFlag){
        checkMore();
        checkFlag = false;
    }else{
        checkNone();
        checkFlag = true;
    }
}
function checkMore() {
	$("input[name='cbox']").attr("checked", true);
}
function checkNone() {
	$("input[name='cbox']").attr("checked", false);
}
function delSysUser() {
	var arrChk = $("input[name='cbox']:checked");
	//遍历得到每个checkbox的value值
	var userIds = "";
	for (var i = 0; i < arrChk.length; i++) {
		userIds += arrChk[i].value + ",";
	}
	if (userIds == "") {
		alert("请选择一条记录");
	} else {
		userIds = userIds.substring(0, userIds.length - 1);
		delUser(userIds);
	}
}