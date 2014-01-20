var dataList;
var flag = true;
$(function() {
    initInfos();
    $("#addAuthBtn").click(function() {
        var param = {
            name : $("#name").val(),
            description : $("#desc").val()
        };
        var code = $("#code").val();
        if (code) {
            param.code = code;
        }
        if (!param.name || !param.description) {
            alert("名称和描述不可为空！");
            return;
        }
        $.ajax({
            url : 'sysMan/addOrUpdateDep.do',
            type : 'post',
            contentType : 'application/json',
            data : JSON.stringify(param),
            success : function(data) {
                if (data && data === true) {
                    $('#insertDiv').mypopClose();
                    alert("保存成功！");
                    closeAddDiv();
                    initInfos();
                }else if(data == '401'){
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
    $.post("sysMan/getDepartmentList.do?msg=" + new Date().getTime(), function(data) {
        $("#depList").find("tbody").empty();
        if (data && data.length > 0) {
            if (data != '401') {
                $("#selectDiv").show();
                dataList = data;
                for (var i = 0, len = data.length; i < len; i++) {
                    var dt = data[i];
                    var man = '<a href="javascript:;" onclick="modifyInfo(' + i + ')">修 改</a><a href="javascript:;" style="margin: 0 10px;">/</a><a href="javascript:;" onclick="delInfo(\'' + dt.code + '\')">删 除</a>';
                    var res = '<tr><td><input name="cbox" style="border:0px;" type="checkbox" value="' + dt.code + '"/></td><td>' + dt.code + '</td><td>' + dt.name + '</td><td>' + dt.description + '</td><td>' + man + '</td></tr>';
                    $("#depList").find("tbody").append(res);
                }
            } else {
                goLoginPage();
            }
        } else {
            $("#depList").find("tbody").append('<tr><td colspan="5">暂无数据</td></tr>');
            $("#selectDiv").hide();
        }
        $("#preloadDiv").mypopClose();
    });
}

function modifyInfo(index) {
    $("#code").val(dataList[index].code);
    $("#name").val(dataList[index].name);
    $("#desc").val(dataList[index].description);
    $('#insertDiv').mypop();
}

function closeAddDiv() {
    $('#insertDiv').mypopClose();
    $("#code").val("");
    $("#name").val("");
    $("#desc").val("");
}

function checkAll() {
    $("#depList").find("input[type='checkbox']").attr("checked", flag);
    flag = !flag;
}

function batchDelInfos() {
    var arrChk = $("input[name='cbox']:checked");
    if (arrChk.length == 0) {
        alert("请选择至少一条记录");
        return;
    }
    //遍历得到每个checkbox的value值
    var ids = "";
    for (var i = 0; i < arrChk.length; i++) {
        var ck = arrChk.eq(i).val();
        ids += ck + ",";
    }
    ids = ids.substring(0, ids.length - 1);
    delInfo(ids);
}

function delInfo(ids) {
    if (!confirm("确定删除？")) {
        return;
    }
    var idArr = ids.split(",");
    $.ajax({
        url : "sysMan/delDep.do?msg=" + new Date().getTime(),
        type : 'post',
        contentType : 'application/json',
        data : JSON.stringify(idArr),
        success : function(data) {
            if (data) {
                if(data == '401'){
                    goLoginPage();
                }else{
                    alert("删除成功！");
                    initInfos();
                }
            } else {
                alert("删除失败！");
            }
        }
    });
}
