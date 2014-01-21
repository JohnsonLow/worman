var flag = true;
var authList;
$(function() {
    initInfos();
    $("#addAuthBtn").click(function() {
        var auth = {
            name : $("#name").val(),
            description : $("#desc").val()
        };
        var level = $("#level").val();
        if(level){
            auth.level = level;
        }
         if(!auth.name || !auth.description){
            alert("名称和描述不可为空！");
            return;
        }
        $.ajax({
            url : 'sysMan/addOrUpdateAuth.do',
            type : 'post',
            contentType : 'application/json',
            data : JSON.stringify(auth),
            success : function(data) {
                if (data && data === true) {
                    $('#insertDiv').mypopClose();
                    alert("保存成功！");
                    closeAddDiv();
                    initInfos();
                } else if(data == '401'){
                    goLoginPage();
                } else {
                    alert("保存失败");
                }
            }
        });
    });
});
function initInfos() {
    $("#preloadDiv").mypop();
    $.post("sysMan/getAuthList.do?msg=" + new Date().getTime(), function(data) {
        $("#authList").find("tbody").empty();
        if (data && data.length > 0) {
            if (data != '401') {
                $("#selectDiv").show();
                authList = data;
                $("#selectDiv").show();
                for (var i = 0, len = data.length; i < len; i++) {
                    var dt = data[i];
                    var man = '<a href="javascript:;" onclick="modifyInfo('+i+')">修 改</a><a href="javascript:;" style="margin: 0 10px;">/</a><a href="javascript:;" onclick="delInfo(\''+dt.level+'\')">删 除</a>';
                    var res = '<tr><td><input name="cbox" style="border:0px;" type="checkbox" value="'+dt.level+'"/></td><td>' + dt.level + '</td><td>' + 
                    dt.name + '</td><td>' + dt.description + '</td><td>'+man+'</td></tr>';
                    $("#authList").find("tbody").append(res);
                }
            } else {
                goLoginPage();
            }
        } else {
            $("#authList").find("tbody").append('<tr><td colspan="5">暂无数据</td></tr>');
            $("#selectDiv").hide();
        }
        $("#preloadDiv").mypopClose();
    });
}
function modifyInfo(index){
    $("#level").val(authList[index].level);
    $("#name").val(authList[index].name);
    $("#desc").val(authList[index].description);
    $('#insertDiv').mypop();
}
function closeAddDiv(){
    $('#insertDiv').mypopClose();
     $("#level").val("");
    $("#name").val("");
    $("#desc").val("");
}
function checkAll(){
    $("#authList").find("input[type='checkbox']").attr("checked",flag);
    flag = !flag;
}
function delSysAuth() {
    var arrChk = $("input[name='cbox']:checked");
    //遍历得到每个checkbox的value值
    var authIds = "";
    for (var i = 0; i < arrChk.length; i++) {
        var ck = arrChk.eq(i).val();
        authIds += ck + ",";
    }
    authIds = authIds.substring(0,authIds.length-1);
    if (authIds.length == 0) {
        alert("请选择一条记录");
    } else {
        delInfo(authIds);
    }
}
function delInfo(ids){
    if(!confirm("确定删除？")){
        return;
    }
    var idArr = ids.split(",");
    $.ajax({
        url : "sysMan/delAuth.do?msg="+new Date().getTime(),
        type : 'post',
        contentType : 'application/json',
        data : JSON.stringify(idArr),
        success : function(data){
            if(data){
                if(data == '401'){
                    goLoginPage();
                }else{
                    alert("删除成功！");
                    initInfos();
                }
            }else{
                alert("删除失败！");
            }
        }
    });
}

