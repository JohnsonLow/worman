$(function(){
    initInfos();
    $("#create").click(function(){
        var mission = checkAllInput();
        if(mission){
            mission.sponsor = {id : currId};
            $.ajax({url : "mission/createMission.do?msg=" + new Date().getTime(),
                type : "POST",
                contentType:"application/json",
                data : JSON.stringify(mision),
                success : function(data){
                    if(data == '-401'){
                        goLoginPage();
                    }else if(data != -1){
                            window.location.href = contextPath + '/mission/goMissionInfoPage.do?id' + data;
                    }else{
                        alert("创建任务失败，请联系管理员！");
                    }
                // if(data == -1){
                     // window.location.href = accessUrl;
                // }else if(data == -2){
                    // alert("获取微博授权失败");
                    // window.location.href = contextPath + "internal/main.do";
                // } else if(data == -3){
                    // alert("不存在的微博账号，请重新授权");
                    // window.location.href = contextPath + "internal/main.do";
                // }else if(data == 1){
                    // //创建任务，发送私信
                // }
            }});
        }
    });
});
function checkAllInput(){
    var flag = true;
    var title = $("#mTitle").val();
    if(title && $.trim(title)){
        flag &= true;
        $("#titleMsgSpan").css("color","green");
        $("#titleMsgSpan").text("√");
    }else{
        flag &= false;
        $("#titleMsgSpan").css("color","red");
        $("#titleMsgSpan").text("任务主题不可为空");
    }
    var type = $("#type").val();
    var content = $("#content").val();
    if(content && $.trim(content)){
        flag &= true;
        $("#contentMsgSpan").css("color","green");
        $("#contentMsgSpan").text("√");
    }else{
        flag &= false;
        $("#contentMsgSpan").css("color","red");
        $("#contentMsgSpan").text("任务内容不可为空");
    }
    var handlerId = $("#slPeo").val();
    if(handlerId != '-1'){
        flag &= true;
        $("#peoMsgSpan").css("color","green");
        $("#peoMsgSpan").text("√");
    }else{
        flag &= false;
        $("#peoMsgSpan").css("color","red");
        $("#peoMsgSpan").text("受理人不可为空");
    }
    if(flag){
        var mision = {
          title : title,
          type : type,
          content : content,
          handler : {id : handlerId},
          notes : $("#notes").val(),
          sponsor : {"id" : currId}
        };
        return mission;
    }
}
function initInfos(){
    $("#preloadDiv").mypop();
    $.get('sysMan/getDepartmentList.do?msg=' + new Date().getTime(),function(data){
        $("#preloadDiv").mypopClose();
        $("#slDep").empty();
        if(data && data.length>0){
            if(data == '-401'){
                goLoginPage();
            }else{
                $("#slDep").append('<option value="-1">--请选择--</option>');
                for(var i=0,len=data.length;i<len;i++){
                    var res = '<option value="'+data[i].code+'">'+data[i].name+'</option>';
                    $("#slDep").append(res);
                }
            }
        }else{
            $("#slDep").append("<option value='-1'>暂无数据</option>");
        }
    });
    $("#slDep").change(function(){
        var depCode = $(this).val();
        if(depCode != -1){
            $("#preloadDiv").mypop();
            $.get('account/getAccountInfos.do?msg=' + new Date().getTime(),
            {depCode : depCode},function(data){
                $("#preloadDiv").mypopClose();
                $("#slPeo").empty();
                if(data && data.length>0){
                    if(data == '-401'){
                        goLoginPage();
                    }else{
                        for(var i=0,len=data.length;i<len;i++){
                            $("#slPeo").append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
                        }
                    }
                }else{
                    $("#slPeo").append("<option value='-1'>暂无数据</option>");
                }
            });
        }
    });
}
