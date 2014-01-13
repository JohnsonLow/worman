$(function() {

    $("#logform-2").click(function() {
        getSysLoginValidator();
    });
    if ($("#txt-lg-2").val() != "" && $("#txt-lg-2").val() != "密码") {
        $("#txt-lg-2").val("");
    }
    $("#txt-lg-1").focusin(function() {
        if ($(this).val() == "用户名") {
            $(this).val("");
        }
        $(this).removeClass("fc");
        $(".i-tip").eq(0).hide();
        $(".i-tip").eq(1).hide();
        $(".i-tip").eq(3).hide();
    }).focusout(function() {
        if ($(this).val() == "") {
            $(this).addClass("fc");
            $(this).val("用户名");
        }
    });

    $("#txt-lg-2").focus(function() {

        if ($("#txt-lg-2").val() == "密码") {
            $("#txt-lg-22").val("");
        }

        $("#txt-lg-2").hide();
        $("#txt-lg-22").show().focus();
        $("#txt-lg-22").val('');
        $("#txt-lg-22").css("font-size", "10px");
        $("#txt-lg-22").removeClass("fc");
        $(".i-tip").eq(0).hide();
        $(".i-tip").eq(1).hide();
    }).focusout(function() {
        if ($(this).val() == "") {
            $("#txt-lg-2").val("密码");
        }
    });

    $("#txt-lg-22").focusin(function() {

        $(".i-tip").eq(0).hide();
        $(".i-tip").eq(1).hide();
    }).focusout(function() {

        if ($(this).val() == "") {
            $("#txt-lg-2").show();
            $("#txt-lg-22").hide();
            $("#txt-lg-2").css("font-size", "20px");
        }
    });

    $("#txt-lg-3").focusin(function() {
        if ($(this).val() == "验证码") {
            $(this).val("");
        }
        $(this).removeClass("fc");
        $(".i-tip").eq(2).hide();
    }).focusout(function() {
        if ($(this).val() == "") {
            $(this).addClass("fc");
            $(this).val("验证码");
        }
    });

});

function getSysLoginValidator() {
    var text = true;
    var userName = $.TrimAll($("#txt-lg-1").val(), 'g');
    var passWord = $("#txt-lg-22").val();
    var validationcode = $("#txt-lg-3").val();

    if (userName == null || userName == "" || userName == "用户名") {
        $(".i-tip").eq(0).show();
        $(".i-tip").eq(0).find("p").html("请输入用户名！");
        $("#txt-lg-1").val("");
        text = false;
    }

    if (passWord == null || passWord == "" || passWord == "密码") {
        $(".i-tip").eq(1).show();
        $(".i-tip").eq(1).find("p").html("请输入密码！");
        $("#txt-lg-2").val("");
        text = false;
    }

    if (validationcode == null || validationcode == "" || validationcode == "验证码") {

        $(".i-tip").eq(2).show();
        $(".i-tip").eq(2).find("p").html("请输入验证码！");
        $("#txt-lg-3").val("");
        text = false;
    }
    if (!text) {
        return;
    }
    var date = loginDate();
    passWord = SHA1(passWord);
    $.post("internal/sysLoginValidator.do?sysUnionCode=" + userName, {
        "userName" : $.trim(userName),
        "passWord" : passWord,
        "verificationCode" : validationcode,
        "date" : date
    }, function(data) {
        if (data == "1") {
            location.href="internal/index.do";
        } else if (data == '-1') {
            $(".i-tip").eq(2).show();
            $(".i-tip").eq(2).find("p").html("验证码错误！");
        } else if (data == '-2') {
            $(".i-tip").eq(1).show();
            $(".i-tip").eq(1).find("p").html("密码错误！");
        } else if (data == '-3') {
            $(".i-tip").eq(3).show();
            $(".i-tip").eq(3).find("p").html("您没有足够的权限，请与管理员联系！");
        } else {
            $(".i-tip").eq(0).show();
            $(".i-tip").eq(0).find("p").html("账号不存在！");
        }
    });
}

function loginDate() {
    var now = new Date();
    // 获取系统日期，即Sat Jul 29 08:24:48UTC+0800 2006
    var yy = now.getFullYear();
    // 截取年，即2006
    var clock = yy + '-';
    var mm = now.getMonth();
    // 截取月，即07
    if (mm < 9)
        clock += '0';
    clock += mm + 1 + '-';
    var dd = now.getDate();
    // 截取日，即29
    if (dd < 10)
        clock += '0';
    clock += dd + '\t\t\t\t\t\t';
    // 取时间
    var hh = now.getHours();
    // 截取小时，即8
    var mm = now.getMinutes();
    // 截取分钟，即34
    var ss = now.getTime() % 60000;
    // 获取时间，因为系统中时间是以毫秒计算的，
    // 所以秒要通过余60000得到。
    ss = (ss - (ss % 1000)) / 1000;
    // 然后，将得到的毫秒数再处理成秒
    if (hh < 10)
        clock += '0';
    clock += hh + ':';
    // 将得到的各个部分连接成一个日期时间
    if (mm < 10)
        clock += '0';
    // 字符串
    clock += mm + ':';
    if (ss < 10)
        clock += '0';
    clock += ss;
    return clock;
}

var unionCodeReg = /^[0-9]*$/;
