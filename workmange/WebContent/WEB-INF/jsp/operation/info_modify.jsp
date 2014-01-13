<%@ page contentType="text/html;charset=utf-8" language="java"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>4s店资料修改</title>
<link href="../static/css/style.css" rel="stylesheet" type="text/css" />
<link href="../static/css/elements.css" rel="stylesheet" type="text/css" />
<style>
.frame{ width:98%; height:auto; line-height:24px; color:#3333333}
.frame .input_text550{background:url(../static/images/news/bg_textInput550.gif) no-repeat;width:547px;height:29px; line-height:29px;padding:3px 0 3px 3px;border:0px;}
.frame .input_text240{background:url(../static/images/news/bg_textInput.gif) no-repeat;width:237px;height:29px; line-height:29px; padding:3px 0 3px 3px;border:0px;}
.frame_cont{ width:100%;margin:20px 10px 10px 10px; padding:5px 0 5px 0;border:1px solid #8398ad;border-top:2px solid #23879f; background:#f7fbfc}
.frame_cont th{ text-align:right; border:0; font-weight:200; padding:4px 0 4px 0}
.frame_cont td{ border:0; text-align:left;}
.frame_button input{padding:0px 10px;margin-left:72px; background:url(../static/images/news/bg_btn1.gif) repeat-x; border:1px solid #8398ac;color:#333;height:28px;line-height:28px;}
</style>
<script type="text/javascript" src="../static/js/jquery-1.4.2.js"></script>
</head>

<body>
	<div class="frame">
		<div class="frame_title">系统管理 &gt; 资料修改</div>
		<div class="frame_cont" id="infos">
			<div class="">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr name="resTr">
						<th width="15%"><img align="absmiddle" src="../static/images/news/icon_xing.gif"/>4S救援电话：</th>
						<td><input name="resPhone" class="input_text550" value=""/>
						 <span style="margin-left:10px;color: gray;">24小时救援电话，可以为手机或固定电话，多个电话之间以‘,’隔开</span>
						 <span style="color: red;" name="msgSpan"></span></td>
					</tr>
					<tr name="mainTr">
						<th width="15%"><img align="absmiddle" src="../static/images/news/icon_xing.gif"/>4S服务电话：</th>
						<td width="75%"><input name="servicePhone" class="input_text550" value=""/>
						<span style="margin-left:10px;color: gray;">维修保养预约电话，只能是固定电话，多个电话以‘,’隔开</span>
						<span style="color: red;" name="msgSpan"></span></td>
					</tr>
					<tr name="mainTr">
						<th width="15%"><img align="absmiddle" src="../static/images/news/icon_xing.gif"/>维修工位数：</th>
						<td><input name="emNum" value="" class="input_text240" maxlength="10"/>
						<span style="margin-left:10px;color: gray;">只能为数字，范围为0~2147483647</span>
						<span style="color: red;" name="msgSpan"></span></td>
					</tr>
					<tr name="mainTr">
						<th width="15%"><img align="absmiddle" src="../static/images/news/icon_xing.gif"/>工作时间：</th>
						<td><input name="workTime" value="" class="input_text240"/>
						<span style="margin-left:10px;color: gray;">维修保养工作时间</span>
						<span style="color: red;" name="msgSpan"></span></td>
					</tr>
					<tr>
						<th></th>
						<td><div class="frame_button">
								<input id="saveBtn" type="button" value="提交" />
							</div></td>
					</tr>
				</table>
			</div>
			
			<p class="cl"></p>
		</div>
	</div>
	<script type="text/javascript" src="../static/js/operatorManage/info-4s.js"></script>
	<script type="text/javascript" src="../static/js/sha-1.js"></script>
	<script type="text/javascript" src="../static/js/common/json/json2.js"></script>
	<script type="text/javascript" language="javascript">
		var agency = getJSONObject(${agencyInfo});
		var mainInfo = getJSONObject(${mainInfo});
	</script>
</body>
</html>
