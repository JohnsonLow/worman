var size = 10;
var page1;
var totalPage1 = 0;
var totalSize1 = 0;
var page2;
var totalPage2 = 0;
var totalSize2 = 0;
$(function(){
    $("#search1").click(function(){
        getInfos(1);
    });
    $("#search2").click(function(){
        getInfos(1);
    });
});

function getInfos(pNum){
    var param = {};
    if(type == 1){//我处理过的任务
        param.handler = currId;
    }else{//我发起的任务
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
    $.get('mission/getMissionList.do?msg='+new Date().getTime(),param
    ,function(data){
        $("#missionList"+type).find('tbody').empty();
        $(".preload").mypopClose();
        if(data && data.data){
            var missions = data.data;
            if(type == 1){
                totalPage1 = data.pageCount;
                totalSize1 = data.rowCount;
            }else{
                totalPage2 = data.pageCount;
                totalSize2 = data.rowCount;
            }
            setPager(pNum);
            for(var i=0,len=missions.length;i<len;i++){
                var res = '<tr><td>'+missions[i].id+'</td><td>'+missions[i].title
                    +'</td><td>'+getStatus(missions[i].status)+'</td><td>'+missions[i].type
                    +'</td><td>'+missions[i].sponsorName+'</td><td>'+missions[i].handlerName+
                    '</td><td>'+missions[i].createTime+'</td><td>'+missions[i].handleTime+
                    '</td><td>'+missions[i].commitTime+
                    '</td><td><a href="mission/goMissionInfoPage.do?id='+missions[i].id+'">查看</a></td></tr>';
                $("#missionList"+type).find('tbody').append(res);
            }
        }else if(data == -401){
            goLoginPage();
        }else{
            $("#missionList"+type).find('tbody').append("<tr><td colspan='10'>暂无数据</td></tr>");
        }
    });
}
function setPager(cPage){
    var tPage ,tRow;
    if(type == 1){//我处理过的任务
        page1 = cPage;
        tPage = totalPage1;
        tRow = totalSize1;
    }else{//我发起的任务
        page2 = cPage;
        tPage = totalPage2;
        tRow = totalSize2;
    }
    if(tPage > 0){
        $("#pager"+type).pager({ pagenumber: cPage,
        pagecount: tPage,
        datanumber:tRow, 
        buttonClickCallback: PageClick });
    }else{
        $("#pager"+type).hide();
    }
}
function PageClick(pageclickednumber){
    getInfos(pageclickednumber);
}
