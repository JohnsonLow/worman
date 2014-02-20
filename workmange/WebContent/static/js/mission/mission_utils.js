function getStatus(status){
    if(status == 1){
        return "待处理";
    }
    if(status == 2){
        return "处理中";
    }
    if(status == 3){
        return "已完成";
    }
}