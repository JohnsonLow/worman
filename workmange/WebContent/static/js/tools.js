//获得地址栏？传参的参数
function getParameter(param) {
	var query = window.location.search;
	var iLen = param.length;
	var iStart = query.indexOf(param);
	if (iStart == -1) {
		return "";
	}
	iStart += iLen + 1;
	var iEnd = query.indexOf("&", iStart);
	if (iEnd == -1) {
		return query.substring(iStart);
	}
	return query.substring(iStart, iEnd);
}

//添加cookie
function setCookie(key, val) {
	$.post("setCookie.do", {"key":key, "value":val}, function (data) {
	});
	setcookie(key, val);
}
//set cookie  
function setcookie(name, value) {
	var Days = 30;
	var exp = new Date();
	exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}
//获取cookie
function getCookieParam(c_name) {
	if (document.cookie.length > 0) {
		c_start = document.cookie.indexOf(c_name + "=");
		if (c_start != -1) {
			c_start = c_start + c_name.length + 1;
			c_end = document.cookie.indexOf(";", c_start);
			if (c_end == -1) {
				c_end = document.cookie.length;
			}
			return unescape(document.cookie.substring(c_start, c_end));
		}
	}
	return "";
}

function copyToClipboard(txt)
{  
   if (window.clipboardData) {  
      window.clipboardData.clearData();  
      window.clipboardData.setData("Text", txt);  
    } else if (navigator.userAgent.indexOf("Opera") != -1) {  
      window.location = txt;  
    } else if (window.netscape) {  
      try {  
        netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");  
      } catch (e) {                
         alert("您的当前浏览器设置已关闭此功能！请按以下步骤开启此功能！\n新开一个浏览器，在浏览器地址栏输入'about:config'并回车。\n然后找到'signed.applets.codebase_principal_support'项，双击后设置为'true'。\n声明：本功能不会危极您计算机或数据的安全！");  
      }  
      var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);  
      if (!clip) return;  
      var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);  
      if (!trans) return;  
      trans.addDataFlavor('text/unicode');  
      var str = new Object();  
      var len = new Object();  
      var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);  
      var copytext = txt;  
      str.data = copytext;
      trans.setTransferData("text/unicode", str, copytext.length * 2);
      var clipid = Components.interfaces.nsIClipboard;
      if (!clip) return false;
      clip.setData(trans, null, clipid.kGlobalClipboard);
    }  
    alert("已复制分享链接到剪贴板，请使用ctrl+v进行粘贴，通过QQ、msn等发给朋友。");
    return true;  
}

//输入值超长截取
var inputLongSub=function(node,length){
	var tempVal=$(node).val();
	var str=longSub(tempVal,length);
	if(tempVal!=str){
		$(node).val(str.substring(0,str.length-3));
	}
};

//超长截取加省略号
function longSub(str,length){
	var sLength=0;
	for(var i=0;i<str.length;i++){
		var s=str.charAt(i);
		if(isHanZi(s)){
			sLength+=2;
		}else{
			sLength+=1;
		}
		if(sLength==length||sLength>length){
			var ddd="...";
			str=str.substring(0,i)+ddd;
			return str;
		}
	}
	return str;
}
//汉字判断
function isHanZi(str){
	return /^[\u4E00-\u9FA5]*$/.test(str);
}

//设置头部current
var setTopCurrent=function(cIndex){
	var elements=$("#zhijiawangTop span");
	elements.eq(cIndex).addClass("current");
};


//将javascript object转换成string  用于事件传参 
var objectToJsonString=function(obj){
	if(typeof obj=="object"){
		var str="";
		for(var key in obj){
			if(key)
				str+=key+':'+obj[key]+',';
		}
		return str;
	}else{
		return obj;
	}
};
//将string转换成javascript object  用于解析
var jsonStringToObject=function(str){
	var arr=str.split(",");
	var obj={};
	for(var i=0;i<arr.length;i++){
		var pro=arr[i].split(":")[0];
		obj[pro]=arr[i].split(":")[1];
	}
	return obj;
};
//将yyyy-mm-dd格式的字符串转换为date
function parseToDate(str){
	if(!str){
		return;
	}
	var strArr = new String(str).split("-");
	if(strArr.length == 3){
		var date = new Date();
		date.setFullYear(parseInt(strArr[0]));
		var month = parseInt(strArr[1],10);
		month --;
		date.setMonth(month);
		date.setDate(parseInt(strArr[2],10));
		date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        date.setMilliseconds(0);
		return date;
	}
}
//获取yyyy-mm-dd HH:mm:ss格式的时间字符串
function searchDate(type) {
    var now = new Date(); //获取系统日期，即Sat Jul 29 08:24:48UTC+0800 2006
    var clock;
    if(type == 0){//获取当月一号日期
    	var yy  = now.getFullYear();
    	var mm = now.getMonth() + 1;
        clock = yy + '-';
        click+= addZero(mm) + '-01';
    }else if(type == 1){//获取一天前的日期
        var time = now.getTime();
        time = time - (24*60*60*1000);
        var t = new Date();
        t.setTime(time);
        var yy = t.getFullYear();
        var mm = t.getMonth() + 1;
        var dd = t.getDate();
        clock = yy + '-';
        clock += addZero(mm) + '-';
       	clock += addZero(dd);
    } else if(type == 2){//获取一个月前的日期
    	var time = now.getTime();
    	time = time - (30*24*60*60*1000);
    	var t = new Date();
    	t.setTime(time);
    	var yy = t.getFullYear();
        var mm = t.getMonth() + 1;
        var dd = t.getDate();
        clock = yy + '-';
        clock += addZero(mm) + '-';
       	clock += addZero(dd);
    } else{//获取当前日期
    	var yy  = now.getFullYear();
    	var mm = now.getMonth() + 1;
    	var dd = now.getDate();
        clock = yy + '-';
        clock += addZero(mm) + '-';
        clock += addZero(dd);
    }
    return clock;
}
function addZero(mm){
	if(mm < 10){
		return '0' + mm;
	}else{
		return mm;
	}
}
/**
 * 验证undefined，
 * @param {Object} val 验证的值
 * @param {Object} def 为undefined，显示的值
 */
function assertNullStr(val,def){
    if(!val){
        if(def){
            val=def;
        }else{
            val="";
        }
    }
    return val;
}
