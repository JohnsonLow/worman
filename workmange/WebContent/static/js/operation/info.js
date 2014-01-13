var numberReg = /^\d+$/;
var telReg = /^(\d{3}-\d{8}|\d{4}-\d{7}|400[-]?\d{7}|800[-]?\d{7})$/;//固定电话 
var mobileReg = /^(13[0-9]|15[0-9]|18[0|2|3|5|6|7|8|9])\d{8}$/;
$(function(){
    init();
    $("#saveBtn").click(function() {
        var param = validateData();
        if(param){
            var updateParam = {};
            if(agency){
                agency.tel24H = param.tel24H;
                updateParam.agency = JSON.stringify(agency);
            }
             if(mainInfo){
                mainInfo.reservationPhone = param.reservationPhone;
                mainInfo.repirePosition = param.repirePosition;
                mainInfo.workTime = param.workTime;
                updateParam.mainInfo = JSON.stringify(mainInfo);
            }
            $.post("../OperatorManagement/updateSInfo.do",updateParam,function(data){
                if(data == 'true'){
                    alert("修改成功");
                    window.location.reload();
                }else{
                    alert("修改失败，请联系管理员");
                }
            });
        }
    });
});
function init(){
    var inputObjs = $("#infos").find('input');
    if(agency){
        inputObjs.eq(0).val(agency.tel24H);
    }else{
        $("tr[name='resTr']").hide();
    }
    if(mainInfo){
        inputObjs.eq(1).val(mainInfo.reservationPhone);
        inputObjs.eq(2).val(mainInfo.repirePosition);
        inputObjs.eq(3).val(mainInfo.workTime);
    }else{
       $("tr[name='mainTr']").hide();
    }
}
function validateData(){
    var inputObjs = $("#infos").find('input');
    var flag = true;
    var tel24H = '';
    var reservationPhone = '';
    var repirePosition = '';
    var workTime = '';
    if(agency){
        tel24H = inputObjs.eq(0).val();
        flag &= validateTel24H(tel24H);
    }
    if(mainInfo){
        reservationPhone = inputObjs.eq(1).val();
        flag &= validateServicePhone(reservationPhone);
        repirePosition = inputObjs.eq(2).val();
        if(repirePosition && $.trim(repirePosition) && numberReg.test(repirePosition)){
            if(parseInt(repirePosition) < 2147483647){
                flag &= true;
                $("span[name='msgSpan']").eq(2).css("color","green");
                $("span[name='msgSpan']").eq(2).text("√");
            }else{
                 flag &=false;
                $("span[name='msgSpan']").eq(2).css("color","red");
                $("span[name='msgSpan']").eq(2).text("输入数据不合法");
            }
        }else{
            flag &=false;
            $("span[name='msgSpan']").eq(2).css("color","red");
            $("span[name='msgSpan']").eq(2).text("输入数据不合法");
        }
        workTime = inputObjs.eq(3).val();
        $("span[name='msgSpan']").eq(3).css("color","green");
        $("span[name='msgSpan']").eq(3).text("√");
    }
    if(flag){
        var param={
            tel24H : tel24H,
            reservationPhone : reservationPhone,
            repirePosition : repirePosition,
            workTime : workTime
        };
        return param;
    }
    
}
function validateTel24H(tel24H){
    var flag = true;
    if(tel24H && $.trim(tel24H)){
        if(tel24H.indexOf(",") >0){
            var arr = tel24H.split(",");
            for(var i=0;i<arr.length;i++){
                if(!telReg.test(arr[i]) && !mobileReg.test(arr[i])){
                    flag = false;
                }
            }
        }else{
            if(!telReg.test(tel24H) && !mobileReg.test(tel24H)){
                flag = false;
            }
        }
    }else{
        flag =false;
    }
    if(!flag){
        $("span[name='msgSpan']").eq(0).css("color","red");
        $("span[name='msgSpan']").eq(0).text("输入数据不合法");
    }else{
         $("span[name='msgSpan']").eq(0).css("color","green");
         $("span[name='msgSpan']").eq(0).text("√");
    }
    return flag;
}
function validateServicePhone(phone){
    var flag = true;
    if(phone && $.trim(phone)){
        if(phone.indexOf(",") >0){
            var arr = phone.split(",");
            for(var i=0;i<arr.length;i++){
                if(!telReg.test(arr[i])){
                    flag = false;
                }
            }
        }else{
            if(!telReg.test(phone)){
                flag = false;
            }
        }
    }else{
        flag =false;
    }
    if(!flag){
        $("span[name='msgSpan']").eq(1).css("color","red");
        $("span[name='msgSpan']").eq(1).text("输入数据不合法");
    }else{
         $("span[name='msgSpan']").eq(1).css("color","green");
         $("span[name='msgSpan']").eq(1).text("√");
    }
    return flag;
}
