<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityKeyWordDetail"%>
<%@page import="com.stang.game.ffd.service.impl.KeyWordServiceImpl"%>
<%@ page import="com.stang.game.ffd.common.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>ChatLog</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<style type="text/css">
/* CSS Document */
body {
	font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica,
		sans-serif;
	color: #4f6b72;
	background: #E6EAE9;
}

a {
	color: #c75f3e;
}

#mytable {
	width: 700px;
	padding: 0;
	margin: 0;
}

caption {
	padding: 0 0 5px 0;
	width: 700px;
	font: italic 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	text-align: right;
}

th {
	font: bold 11px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #4f6b72;
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	border-top: 1px solid #C1DAD7;
	letter-spacing: 2px;
	text-transform: uppercase;
	text-align: left;
	padding: 6px 6px 6px 12px;
	background: #CAE8EA url(images/bg_header.jpg) no-repeat;
}

th.nobg {
	border-top: 0;
	border-left: 0;
	border-right: 1px solid #C1DAD7;
	background: none;
}

td {
	border-right: 1px solid #C1DAD7;
	border-bottom: 1px solid #C1DAD7;
	background: #fff;
	font-size: 14px;
	padding: 6px 6px 6px 12px;
	color: #4f6b72;
}

td.alt {
	background: #F5FAFA;
	color: #797268;
}

th.spec {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #fff url(images/bullet1.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
}

th.specalt {
	border-left: 1px solid #C1DAD7;
	border-top: 0;
	background: #f5fafa url(images/bullet2.gif) no-repeat;
	font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
	color: #797268;
}
</style>
	<body>
		<button
			onClick='serverId=1;document.getElementById("chatDiv").innerHTML =""'>
			服务器一
		</button>
		<hr>
		<button onClick='document.getElementById("chatDiv").innerHTML =""'>
			[清屏]
		</button>
		<button onClick='isStop=!isStop;this.innerHTML=isStop?"[恢复]":"[暂停]"'>
			[暂停]
		</button>
		<div id="chatDiv">
		</div>

		<div id="roleDiv" style="position: absolute; top: 50; display: none">
			<table style="background-color: #eeeeee;">
				<tr>
					<td>
						<div id="roleContentDiv"></div>
					</td>
				</tr>
			</table>
		</div>
		<script>
	var isIe = false;
	start();
	function getMessage(messages){
		if(isIe){
			getMessageIe(messages);
			return;
		}
		var root = messages.documentElement;
		var message = root.getElementsByTagName("message");
		var fname;
		var mess;
		var fid;
		var toname;
		var chn;
		var time;
		var innerHTML;
		
		for(var i = 0 ; i < message.length ; i++)
		{
			fname = message.item(i).getElementsByTagName("fname").item(0).firstChild.data;
			fid = message.item(i).getElementsByTagName("fid").item(0).firstChild.data;
			mess = message.item(i).getElementsByTagName("mess").item(0).firstChild.data;
			chn = message.item(i).getElementsByTagName("chn").item(0).firstChild.data;
			time = message.item(i).getElementsByTagName("time").item(0).firstChild.data;
			var tonameTmp =  message.item(i).getElementsByTagName("toname").item(0).firstChild;
			if(tonameTmp!=null)
				toname = tonameTmp.data;
			else
				toname = "null";
			
			fname = replaceNameKey(fname);
			mess = replaceMessKey(mess);
			
            innerHTML = time;
            
            switch (parseInt(chn)){
            case 1:innerHTML = innerHTML +"[当前]"; break;
            case 2:innerHTML = innerHTML +"[房间]"; break;
            case 3:innerHTML = innerHTML +"[战斗]"; break;
            case 4:innerHTML = innerHTML +"[队伍]"; break;
            case 5:innerHTML = innerHTML +"[公会]"; break;
            case 6:innerHTML = innerHTML +"[私聊]"; break;
            case 7:innerHTML = innerHTML +"[大喇叭]"; break;
            case 12:innerHTML = innerHTML +"[小喇叭]"; break;
            default :innerHTML = innerHTML +"["+ chn +"]";
            }
            innerHTML = innerHTML
           	+"<a href=\"#\" onClick=\"chickRoleName(event,'"+fname+"','"+fid+"')\">"
            +fname
            +"</a>";
            
            if(toname==null||toname=="null"){
            	innerHTML = innerHTML+":";
            }else{
            	innerHTML = innerHTML+"对"+replaceNameKey(toname)+"说:";
            }
            
            innerHTML = innerHTML
            +mess
            +"<br />"
            +document.getElementById("chatDiv").innerHTML
            ;
            
            document.getElementById("chatDiv").innerHTML
            = innerHTML;
		}
	}
	
	function getMessageIe(messages){
		var root = messages.documentElement;
		var message = root.childNodes;
		var fname;
		var mess;
		var fid;
		var toname;
		var chn;
		var time;
		var innerHTML;
		for(var i = 0 ; i < message.length ; i++)
		{
			fname = message.item(i).getElementsByTagName("fname").item(0).firstChild.data;
			fid = message.item(i).getElementsByTagName("fid").item(0).firstChild.data;
			mess = message.item(i).getElementsByTagName("mess").item(0).firstChild.data;
			chn = message.item(i).getElementsByTagName("chn").item(0).firstChild.data;
			time = message.item(i).getElementsByTagName("time").item(0).firstChild.data;
			var tonameTmp =  message.item(i).getElementsByTagName("toname").item(0).firstChild;
			if(tonameTmp!=null)
				toname = tonameTmp.data;
			else
				toname = "null";
			
			fname = replaceNameKey(fname);
			mess = replaceMessKey(mess);
			
            innerHTML = time;
            
            switch (parseInt(chn)){
            case 1:innerHTML = innerHTML +"[当前]"; break;
            case 2:innerHTML = innerHTML +"[房间]"; break;
            case 3:innerHTML = innerHTML +"[战斗]"; break;
            case 4:innerHTML = innerHTML +"[队伍]"; break;
            case 5:innerHTML = innerHTML +"[公会]"; break;
            case 6:innerHTML = innerHTML +"[私聊]"; break;
            case 7:innerHTML = innerHTML +"[大喇叭]"; break;
            case 12:innerHTML = innerHTML +"[小喇叭]"; break;
            default :innerHTML = innerHTML +"["+ chn +"]";
            }
            innerHTML = innerHTML
           	+"<a href=\"#\" onClick=\"chickRoleName(event,'"+fname+"','"+fid+"')\">"
            +fname
            +"</a>";
            
            if(toname==null||toname=="null"){
            	innerHTML = innerHTML+":";
            }else{
            	innerHTML = innerHTML+"对"+replaceNameKey(toname)+"说:";
            }
            
            innerHTML = innerHTML
            +mess
            +"<br />"
            +document.getElementById("chatDiv").innerHTML
            ;
            
            document.getElementById("chatDiv").innerHTML
            = innerHTML;
		}
	}
		
	var xmlHttp;
	var isStop = false;
	var serverId=0;
	function a()
	{
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		}catch (e) { // Internet Explorer
			isIe = true;
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			}catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				}catch (e) {
					alert("游览器不支持");
			}
		}
	}
		xmlHttp.onreadystatechange = function ()
		{
			if (xmlHttp.readyState == 4)
			{
				if (xmlHttp.status == 200)
				{
					getMessage(xmlHttp.responseXML);
				}
			};
		};
	}
	function start(){
		setInterval(function(){
				if(isStop)
					return;
				a();
				string = "serverId="+serverId;	
				xmlHttp.open("post","chatLog.action", true);
				xmlHttp.setRequestHeader("content-length",string.length);  
				xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");  
				xmlHttp.send(string);

			}
			,1000
		);
	}
	function chickRoleName(event,fname,fid){
		var div = document.getElementById("roleDiv");
		div.style.display="block";
		div.style.left = event.clientX  + 20;
		div.style.top = event.clientY  - 10;
		
		document.getElementById("roleContentDiv").innerHTML=""
		+"<center><a href='#' onClick='document.getElementById(\"roleDiv\").style.display=\"none\"'>关闭</a></center>"
		+"<hr>"
		+"<table><tr><td>"
		+"所在服务器："+"<label id='serverId'>"+serverId+"</label>"
		+"</td></tr><tr><td>"+"昵称："+"<label id='fname'>"+fname+"</label>"
		+"</td></tr><tr><td>"+"id："+"<label id='fid'>"+fid+"</label>"
		+"</td></tr><tr><td>"+"时限："
		+"<input id='time' type='textfield' style='width: 100px;text-align:center' value='300'>(秒)"
		+"</td></tr><tr><td><center>"
		+"<button onClick='rejectAction(\"chatLogRejectChat.action\")'>禁言</button>"
		+"&nbsp&nbsp"
		+"<button onClick='rejectAction(\"chatLogRejectLogin.action\")'>封停</button>"
		+"</center></td></tr></table>"		
		;
	}
	function rejectAction(url){
		var params = "";
		params += "serverId="+document.getElementById("serverId");
		params += "fname="+document.getElementById("fname");
		params += "fid="+document.getElementById("fid");
		params += "time="+document.getElementById("time");
		
		var xmlHttpRequest;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttpRequest = new XMLHttpRequest();
		}catch (e) { // Internet Explorer
			try {
				xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
			}catch (e) {
				try {
					xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
				}catch (e) {
					alert("游览器不支持");
				}
			}
		}
		xmlHttpRequest.onreadystatechange = function ()
		{
			if (xmlHttpRequest.readyState == 4)
			{
				if (xmlHttpRequest.status == 200)
				{
					document.getElementById("roleContentDiv").innerHTML=""
					+"<center><a href='#' onClick='document.getElementById(\"roleDiv\").style.display=\"none\"'>关闭</a>"
					+"<hr>"
					+"<table><tr><td width='170'><center><font color=#010101 size=5>" + xmlHttpRequest.responseText +"</font></center></td></tr></table></center>";
				}
			};
		}
		
		xmlHttpRequest.open("post",url, true);
		xmlHttpRequest.setRequestHeader("content-length",params.length);  
		xmlHttpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");  
		xmlHttpRequest.send(params);
	}
	function replaceMessKey(str){
		var keys = new Array();
	<%
	HashMap<String,Object> param = new HashMap<String,Object>();
	param.put("type",1);
	List<EntityKeyWordDetail> ekwds = new KeyWordServiceImpl().findEntityKeyWordDetailByParam(param);
	int i=0;

	for(EntityKeyWordDetail ekwd :ekwds){
	%>
		keys[<%=i++%>]="<%=StringUtil.uriDecode(ekwd.getKeyWord(),
								GameConstants.FORMAT)%>"
	<%}
	ekwds = null;
	%>
		for(i in keys){
			str = str.replace(eval("/" + keys[i] + "/g"),"<font color=blue><b>"+keys[i]+"</b></font>");
		}

		return str;
	}
	
	
	function replaceNameKey(str){
		var keys = new Array();
	<%
	
	param.put("type",2);
	ekwds = new KeyWordServiceImpl().findEntityKeyWordDetailByParam(param);
	for(EntityKeyWordDetail ekwd :ekwds){
		%>
			keys[<%=i++%>]="<%=StringUtil.uriDecode(ekwd.getKeyWord(),
								GameConstants.FORMAT)%>"
		<%}
	param = null;
	ekwds = null;
	%>
		for(i in keys){
			str = str.replace(eval("/" + keys[i] + "/g"),"<font color=blue><b>"+keys[i]+"</b></font>");
		}

		return str;
	}	
		</script>
	</body>
</html>
