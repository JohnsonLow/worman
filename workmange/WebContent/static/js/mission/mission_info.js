var lastToId;//最后一个受理人的id
var lastHandleId;
var lastMHid;
$(function() {
    initHandleInfo();
    if (status == 3) {
        $("#handleDiv").remove();
    } else if (status == 1 && currId == handlerId) {
        $("#handleDiv").show();
        initPeoSel();
    }else if(status == 2 && currId == lastToId){
        $("#handleDiv").show();
        initPeoSel();
    }else{
        $("#handleDiv").remove();
    }
    if(status == 1 && currId == sponsorId){
        $("#sendWbBtn").show();
    }else if(status == 2 && currId == lastHandleId){
        $("#sendWbBtn").show();
    }else{
        $("#sendWbBtn").remove();
    }
    $("#confirmHanBtn").click(function(){
        var handleType = $("input[name='handType']:checked").val();
        var content = $("#content").val();
        if(!content){
            alert("处理意见不可为空");
            return;
        }
        if(handleType == 1001){
            if($("#peoSel").val() == -1){
                alert("转发人员不可为空");
                return;
            }
            if($("#peoSel").val() == fqId){
                alert("不可转发给发起人");
                return;
            }
        }
        handleMission();
    });
    $("#sendWbBtn").find("a").click(function(){
        var url = contextPath + '/mission/goMissionInfoPage.do?id=' + currId;
        sendWeiboInfo(currId,missionId,handlerId,url);
    });
    
});
function handleMission(){
    var handleType = $("input[name='handType']:checked").val();
    var handleInfo = {
        handleType : handleType,
        handlerId : currId,
        handlerName : currName,
        handlerDep : currDep,
        content : $("#content").val(),
        missionId : missionId
    };
    if(handleType == 1002){
        handleInfo.toId = fqId;
        handleInfo.toName = fqName;
        handleInfo.toDep = fqDep;
    }else if(handleType == 1001){
        handleInfo.toId = $("#peoSel").val();
        handleInfo.toName = $("#peoSel").find("option:selected").text();
        handleInfo.toDep = $("#depSel").find("option:selected").text();
    }
    $.ajax({url : "mission/handleMission.do",
            type : "POST",
            contentType:"application/json",
            data : JSON.stringify(handleInfo),
            success : function(data){
                if(data == -401){
                    goLoginPage();
                }else if(data == -1){
                    alert("处理失败，请联系管理员");
                }else{
                    sendWeiboInfo(currId,missionId,data);
                }
            }});
}
function initHandleInfo(){
    if(handleInfos && handleInfos.length>0){
        for(var i=0,len=handleInfos.length;i<len;i++){
            var dt = handleInfos[i];
            var res = '<tr><td>'+dt.handlerDep+'</td><td>'+dt.handlerName+'</td><td>'+dt.content+
            '</td><td>'+dt.addTime+'</td><td>'+dt.toDep+'</td><td>'+dt.toName+'</td><td>'+dt.handleTime+'</td></tr>';
            $("#handleTable").find("tbody").append(res);
            if(i == len-1){
                lastToId = dt.toId;
                lastHandleId = dt.handlerId; 
                lastMHid = dt.id;
            }
        }
        $("#handleListDiv").show();
    }else{
        $("#handleListDiv").hide();
    }
}
function initPeoSel() {
    $(".preload").mypop();
    $.get('sysMan/getDepartmentList.do', function(data) {
        $(".preload").mypopClose();
        if (data && data.length > 0) {
            if (data == -401) {
                goLoginPage();
            } else {
                $("#depSel").empty();
                $("#depSel").append("<option value='-1'>--请选择--</option>");
                for (var i = 0, len = data.length; i < len; i++) {
                    $("#depSel").append("<option value='" + data[i].code + "'>" + data[i].name + "</option>");
                }
            }
        } else {
            $("#depSel").append("<option value='-1'>暂无数据</option>");
        }
    });
    $("#depSel").change(function(){
        var depCode = $(this).val();
        if(depCode != '-1'){
            $("#preloadDiv").mypop();
            $.get('account/getAccountInfos.do?msg=' + new Date().getTime(),
            {depCode : depCode},function(data){
                $("#preloadDiv").mypopClose();
                $("#peoSel").empty();
                if(data && data.length>0){
                    if(data == '-401'){
                        goLoginPage();
                    }else{
                        for(var i=0,len=data.length;i<len;i++){
                            $("#peoSel").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
                        }
                    }
                }else{
                    $("#peoSel").append("<option value='-1'>暂无数据</option>");
                }
            });
        } else{
            $("#peoSel").empty();
            $("#peoSel").append("<option value='-1'>--请选择部门--</option>");
        }
    });
}