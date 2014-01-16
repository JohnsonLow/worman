$(function(){
    initInfos(); 
});
function initInfos(){
    $("#preloadDiv").mypop();
    $.post("sysMan/getAuthList.do?msg="+new Date().getTime(),function(data){
        $("#authList").find("tbody").empty();;
        if(data) {
           if(data != '401'){
               for(var i=0,len=data.length;i<len;i++){
                   var dt = data[i];
                   var res = '<tr><td>'+dt.level+'</td><td>'+dt.name+'</td><td>'+dt.description+'</td></tr>';
                   $("#authList").find("tbody").append(res);
               }
           }else{
               window.parent.location.href=contextPath + "/internal/login.do";
           }
       }else{
           
       }
        $("#preloadDiv").mypopClose();
    });
}

