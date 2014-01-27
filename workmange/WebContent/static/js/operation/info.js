var mobileReg = /^(13[0-9]|15[0-9]|18[0|2|3|5|6|7|8|9])\d{8}$/;
var emailReg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
$(function(){
    if(userName == 'sysadmin'){
        $("#depDiv").hide();
        $("#posDiv").hide();
    }
    $("#saveBtn").click(function() {
        var param = validateData();
        if(param){
            $.post("operation/updateInfo.do",param,function(data){
                if(data == true){
                    alert("修改成功");
                    window.location.reload();
                }else{
                    alert("修改失败，请联系管理员");
                }
            });
        }
    });
});
function validateData(){
    var flag = true;
    var phone = $("#phone").val();
    if(phone){
        if(!mobileReg.test(phone)){
            flag &= false;
            $("#phoneMsgSpan").css("color","red");
            $("#phoneMsgSpan").text("请输入正确的手机号");
        }else{
             flag &= true;
             $("#phoneMsgSpan").css("color","green");
             $("#phoneMsgSpan").text("√");
        }
    }else{
        $("#phoneMsgSpan").text("");
    }
    var weibo = $("#weibo").val();
    if(emailReg.test(weibo)){
        $("#weiboMsgSpan").css("color","green");
        $("#weiboMsgSpan").text("√");
        flag &= true;
    }else{
        $("#weiboMsgSpan").css("color","red");
        $("#weiboMsgSpan").text("请输入正确的微博账号");
        flag &= false;
    }
    if(flag){
        var infos = {
            weibo : $("#weibo").val(),
            phone : phone,
            name : $("#name").val()
        };
        return infos;
    }
    
}
