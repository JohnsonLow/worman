$(function(){
    initInfos(); 
});
function initInfos(){
    $("#preloadDiv").mypop();
    $.post("sysMan/getDepartmentList.do?msg="+new Date().getTime(),function(data){
        $("#depList").find("tbody").empty();;
        if(data && data.length>0) {
           if(data != '401'){
               for(var i=0,len=data.length;i<len;i++){
                   var dt = data[i];
                   var res = '<tr><td>'+dt.code+'</td><td>'+dt.name+'</td><td>'+dt.description+'</td></tr>';
                   $("#depList").find("tbody").append(res);
               }
           }else{
               window.parent.location.href=contextPath + "/internal/login.do";
           }
       }else{
           $("#depList").find("tbody").append('<tr><td colspan="5">暂无数据</td></tr>');
       }
        $("#preloadDiv").mypopClose();
        $("#selectDiv").hide();
    });
}

