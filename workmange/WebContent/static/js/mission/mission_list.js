var size = 10;
var page1;
var totalPage1 = 0;
var totalSize1 = 0;
var page2;
var totalPage2 = 0;
var totalSize2 = 0;
$(function(){
    $("search1").click(function(){
        getInfos(1,1);
    });
    $("search2").click(function(){
        getInfos(1,2);
    });
});

function getInfos(pNum,type){
    var param = {};
    if(type == 1){//我处理过的任务
        page1 = pNum;
        param.handler = currId;
    }else{//我发起的任务
        page2 = pNum;
        param.sponsor = currId;
    }
    var parDiv = $("#tab"+type);
    param.page = pNum;
    param.size = size;
    param.type = parDiv.find("select").eq(0).val();
    param.status = parDiv.find("select").eq(1).val();
    param.startTime = parDiv.find("input").eq(0).val();
    param.endTime = parDiv.find("input").eq(1).val();
    $(".preload").mypop();
    $.get('mission/getMissions.do?msg='+new Date().getTime(),param
    ,function(data){
        $("#missionList"+type).find('tbody').empty();
         $(".preload").mypopClose();
        if(data){
            
        }else if(data == -401){
            goLoginPage();
        }else{
            $("#missionList"+type).find('tbody').apend("<tr><td colspan='11'>暂无数据</td></tr>");
        }
    });
}
function setPager1(cPage){
    
}
