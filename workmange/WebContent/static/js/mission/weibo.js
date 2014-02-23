function sendWeiboInfo(id,missionId,handleId,url){
    if(confirm("是否发送微博通知？")){
        var param = {
            id : id,
            missionId : missionId
        };
        if(handleId){
            param.handleId = handleId;
        }
        $.get('weibo/sendWeibo.do',param,function(data){
            if(data == -401){
                goLoginPage();
            }else if(data == -1){
                alert("未进行微博授权绑定");
            }else if(data == -2){
                alert("通知对象未进行微博绑定");
            }else if(data == -3){
                alert("微博验证出错");
            }else if(data == -4){
                alert("发送微博失败");
            }else if(data == 1){
                alert("发送成功");
            }
            if(url){
                window.location.href = url;
            }else{
                window.location.reload();
            }
        });
    }else{
         if(url){
            window.location.href = url;
        }else{
            window.location.reload();
        }
    }
}
