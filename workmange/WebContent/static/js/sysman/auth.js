var flag = true;
$(function() {
    initInfos();
    $("#addAuthBtn").click(function() {
        var auth = {
            name : $("#name").val(),
            description : $("#desc").val()
        };
        $.ajax({
            url : 'sysMan/insertAuth.do',
            type : 'post',
            contentType : 'application/json',
            data : JSON.stringify(auth),
            success : function(data) {
                if (data && data === true) {
                    $('#insertDiv').mypopClose();
                    alert("添加成功！");
                    initInfos();
                } else {
                    alert("添加失败");
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
                for (var i = 0, len = data.length; i < len; i++) {
                    var dt = data[i];
                    var man = '<a href="javascript:;" onclick="modifyInfo('+i+')">修 改</a><a href="javascript:;" style="margin: 0 10px;">/</a><a href="javascript:;" onclick="delInfo('+i+')">删 除</a>';
                    var res = '<tr><td><input type="checkbox" value="'+i+'"/></td><td>' + dt.level + '</td><td>' + 
                    dt.name + '</td><td>' + dt.description + '</td><td>'+man+'</td></tr>';
                    $("#authList").find("tbody").append(res);
                }
            } else {
                window.parent.location.href = contextPath + "/internal/login.do";
            }
        } else {
            $("#authList").find("tbody").append('<tr><td colspan="5">暂无数据</td></tr>');
            $("#selectDiv").hide();
        }
        $("#preloadDiv").mypopClose();
    });
}
function closeAddDiv(){
    $('#insertDiv').mypopClose();
    $("#name").val("");
    $("#desc").val("");
}
function checkAll(){
    $("#authList").find("input[type='checkbox']").attr("checked",flag);
    flag = !flag;
}

