var rowCount;
var pageCount;
var size = 10;
var hPage;
$(function(){
	getInfo(1);
	$("#search").click(function(){
	    getInfo(1);
	});
});
var checkFlag = true;
function getInfo(page){
    var param = {
      page : page,
      size : size,
      msg : new Date().getTime()
    };
    if($("#authSel").val()){
        param.level = $("#authSel").val();
    }
    if($("#depSel").val()){
        param.depCode = $("#depSel").val();
    }
    if($("#name").val()){
        param.name = $("#name").val();
    }
    $("#preloadDiv").mypop();
    $.get('account/getAccountList.do',param,function(data){
        $("#preloadDiv").mypopClose();
        if(data){
            $("#userList").find("tbody").empty();
            if(data == '401'){
                 goLoginPage();
            }else{
                rowCount = data.rowCount;
                pageCount = data.pageCount;
                if(data.data && data.rowCount > 0){
                    for(var i=0,len=data.data.length;i<len;i++){
                        var user = data.data[i];
                        var editUrl = 'account/goAccountInfoPage.do?id='+user.id;
                        var res = '<tr>'+
                                    '<td>'+user.userName+'</td>'+
                                    '<td>'+user.name+'&nbsp;</td>'+
                                    '<td>'+user.auth.level+'</td>'+
                                    '<td>'+user.department.code+'</td>'+
                                    '<td>'+user.phone+'</td>'+
                                    '<td>'+user.weibo+'</td>'+
                                    '<td>'+
                                        '<span><a href="'+editUrl+'">编辑</a></span><span style="margin:0 10px; cursor:auto;">/</span>'+
                                        '<span><a href="javascript:;" onclick="delUser(\''+user.uid+'\')">删除</a></span>'+
                                        '<span style="width:65px; height:10px;"></span>'+
                                    '</td></tr>';
                         $("#userList").find('tbody').append(res);
                    }
                    setPage(page);
                    $("#pager").show();
                }else{
                    $("#selectDiv").hide();
                    $("#userList").find("tbody").empty();
                    $("#userList").find("tbody").append("<tr><td  colspan='8'>暂无数据</td></tr>");
                    $("#pager").hide();
                }
            }
        }else {
            $("#selectDiv").hide();
            $("#userList").find("tbody").empty();
            $("#userList").find("tbody").append("<tr><td  colspan='8'>暂无数据</td></tr>");
        }
    });
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
function setPage(currIndex){
    hPage = currIndex;
    $("#pager").pager({ pagenumber: hPage,
    pagecount: pageCount,
    datanumber:rowCount, 
    buttonClickCallback: PageClick });
}
PageClick = function(pageclickednumber) {
    getInfo(pageclickednumber);
};