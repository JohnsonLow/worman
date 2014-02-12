$(function(){
    initInfos();
    $("#createAndSend").click(function(){
        $.get("weibo/sysWeibo.do?msg=" + new Date().getTime(),{
            id : currId
        },function(data){
            if(data == -1){
                 window.location.href = accessUrl;
            }else if(data == -2){
                alert("获取微博授权失败");
                window.location.href = contextPath + "internal/main.do";
            } else if(data == -3){
                alert("不存在的微博账号，请重新授权");
                window.location.href = contextPath + "internal/main.do";
            }else if(data == 1){
                //创建任务，发送私信
            }
        });
    });
});
function initInfos(){
    $("#preloadDiv").mypop();
    $.get('sysMan/getDepartmentList.do?msg=' + new Date().getTime(),function(data){
        $("#preloadDiv").mypopClose();
        $("#slDep").empty();
        if(data && data.length>0){
            if(data == '401'){
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
                    if(data == '401'){
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
