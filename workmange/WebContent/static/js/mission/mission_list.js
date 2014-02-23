var size = 10;
var page;
var totalPage = 0;
var totalSize = 0;
$(function(){
    initInfos();
    $("#search1").click(function(){
        getInfos(1);
    });
});

function getInfos(pNum){
    var param = {
        handler : currId,
        searchType : searchType
    };
    if(searchType > 1){
        page = pNum;
        param.page = pNum;
        param.size = size;
        param.type = $("select").eq(0).val();
        param.status = $("select").eq(1).val();
        param.startTime = $("input").eq(0).val();
        param.endTime = $("input").eq(1).val();
    }
    $(".preload").mypop();
    $.get('mission/getMissionList.do?msg='+new Date().getTime(),param
    ,function(data){
        $("#missionList").find('tbody').empty();
        $(".preload").mypopClose();
        if(data == -401){
            goLoginPage();
        }else{
            showInfos(data);
        }
    });
}
function initInfos(){
    if(searchType == 1){
        $("#title").text("待处理的任务");
        getInfos();
    }else if(searchType == 2){
        $("#title").text("我处理过的任务");
    } else{
        $("#title").text("我发起的任务");
    }
}
function showInfos(data){
    var missions;
    if(searchType == 1){
        missions = data;
    }else{
        missions = data.data;
        totalPage = data.pageCount;
        totalSize = data.rowCount;
        setPager(page);
    }
    if(missions && missions.length>0){
        for(var i=0,len=missions.length;i<len;i++){
            var res = '<tr><td>'+missions[i].id+'</td><td>'+missions[i].title
                +'</td><td>'+getStatus(missions[i].status)+'</td><td>'+missions[i].type
                +'</td><td>'+missions[i].sponsorName+'</td><td>'+missions[i].handlerName+
                '</td><td>'+missions[i].createTime+'</td><td>'+missions[i].handleTime+
                '</td><td>'+missions[i].commitTime+
                '</td><td><a href="mission/goMissionInfoPage.do?id='+missions[i].id+'">查看</a></td></tr>';
            $("#missionList").find('tbody').append(res);
        }
    }else{
         $("#missionList").find('tbody').append("<tr><td colspan='10'>暂无数据</td></tr>");
    }
}
function setPager(cPage){
    page = cPage;
    if(totalPage > 0){
        $("#pager").pager({ pagenumber: cPage,
        pagecount: totalPage,
        datanumber:totalSize, 
        buttonClickCallback: PageClick });
    }else{
        $("#pager").hide();
    }
}
function PageClick(pageclickednumber){
    getInfos(pageclickednumber);
}
