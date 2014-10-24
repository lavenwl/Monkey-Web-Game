<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.stang.game.ffd.entity.detail.GameMailDetail"%>
<%@page import="com.stang.game.ffd.service.impl.GameRoleServiceImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.stang.game.ffd.common.StringUtil"%>
<%@page import="com.stang.game.ffd.common.GameConstants"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    <%
     List<Map<String,Object>> reMap = new ArrayList<Map<String,Object>>();
    if(request.getAttribute("reMap")!=null){
    	reMap=(List<Map<String,Object>>)request.getAttribute("reMap");
    }
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>邮件监控</title>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/WebCalendar.js"></SCRIPT>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
	</head>
	<SCRIPT type="text/javascript">
		function checkAll(){
			var title = document.getElementById("title").value.replace(/(^\s*)|(\s*$)/g,"");
			var uname1 = document.getElementById("uname1").value.replace(/(^\s*)|(\s*$)/g,"");
			var uname2 = document.getElementById("uname2").value.replace(/(^\s*)|(\s*$)/g,"");
			var timeBegin = document.getElementById("timeBegin").value.replace(/(^\s*)|(\s*$)/g,"");
			var timeEnd = document.getElementById("timeEnd").value.replace(/(^\s*)|(\s*$)/g,"");
			if(uname1=="请在这里输入用户名"){
				document.getElementById("uname1").value ="";
				uname1="";
			}
			if(uname2 == "请在这里输入用户名"){
				document.getElementById("uname2").value ="";
				uname2 = "";	
			}
			if(title==""&&timeBegin==""&&timeEnd==""&&uname1==""&&uname2==""){
				document.getElementById("uname2").value ="请在这里输入用户名";
				document.getElementById("uname1").value ="请在这里输入用户名";
				alert("请输入查询条件")
				return false;
			}
			return true;
			
			
		}
	</SCRIPT>
	
	<body>
		<s:form action="checkMail.action" method="post"
			onsubmit="return checkAll()">
			<table>
				<tr>
					<td>
						发送者：
					</td>
					<td>
						<div style="position: relative">
							<div>
								<input id="uname1" type="text" name="uname1" id="uname1"
									onkeyup="queryByName('getRoleName.action',this.value,1);panduan(event,1)"
									size="23"
									style="height: 18px; text-align: center; color: #AB998F; width: 150px"
									value="请在这里输入用户名"
									onclick="document.getElementById('uname1').value=''">
							</div>
							<div id="search1" style="position: absolute; display: none">
								<SELECT id="sname1" NAME="sname1"
									onkeyup="if(event.keyCode==13){document.getElementById('search1').style.display='none';document.getElementById('uname1').value=this.value;document.getElementById('uname1').focus();}"
									style="width: 150px"
									onclick="document.getElementById('search1').style.display='none';document.getElementById('uname1').value=this.value">
								</SELECT>
							</div>
						</div>
					</td>
					<td>
						接收者：
					</td>
					<td>
						<div style="position: relative">
							<div>
								<input id="uname2" type="text" name="uname2" id="uname2"
									onkeyup="queryByName('getRoleName.action',this.value,2);panduan(event,2)"
									size="23"
									style="height: 18px; text-align: center; color: #AB998F; width: 150px"
									value="请在这里输入用户名"
									onclick="document.getElementById('uname2').value=''">
							</div>
							<div id="search2" style="position: absolute; display: none">
								<SELECT id="sname2" NAME="sname2"
									onkeyup="if(event.keyCode==13){document.getElementById('search2').style.display='none';document.getElementById('uname2').value=this.value;document.getElementById('uname2').focus();}"
									style="width: 150px"
									onclick="document.getElementById('search2').style.display='none';document.getElementById('uname2').value=this.value">
								</SELECT>
							</div>
						</div>
					</td>

				</tr>
				<tr>
					<td>
						起始时间：
					</td>
					<td>
						<input name="timeBegin" id="timeBegin" type="text" value=""
							maxlength="100" id="stime1"
							onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')" readonly="true"
							style="width: 150px; cursor: pointer" />
					</td>
					<td>
						结束时间：
					</td>
					<td>
						<input name="timeEnd" id="timeEnd" type="text" value=""
							maxlength="100" id="stime2"
							onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')" readonly="true"
							style="width: 150px; cursor: pointer" />
					</td>

				</tr>
				<tr>
					<td>
						邮件标题：
					</td>
					<td>
						<input type="text" id="title" size="23" name="title"
							style="height: 18px; width: 150px">
					</td>
				</tr>
				<tr>
					<td colspan="4">
						*注：查询时，所有填写的内容都将作为查询条件
					</td>
				</tr>
			</table>
			<s:submit value="查询"></s:submit>
		</s:form>
		<%
			if(reMap.size()>0){
				for(int i =0;i<reMap.size();i++){
				Map<String,Object> mailMap = reMap.get(i);
					%>
					<table border="1" <%=i % 2==0?"style='background-color:#dddddd'"
					: "style='background-color:#eeeeee'" %>">
						<tr>
							<td width="100px">
							标题:
							</td>
							<td width="200px">
							<%=StringUtil.uriDecode(String.valueOf(mailMap.get("mailTitle")),GameConstants.FORMAT)%>
							</td>
							<td width="80px">
							发送时间：
							</td>
							<td width="200px">
							<%=	df.format(mailMap.get("sendTime"))%>
							</td>
						</tr>
						<tr>
							<td>
							发送者：
							</td>
							<td>
							<%= StringUtil.uriDecode(String.valueOf(mailMap.get("sender")),GameConstants.FORMAT)%>
							</td>
							<td>
							接受者:
							</td>
							<td>
							<%=StringUtil.uriDecode(String.valueOf(mailMap.get("receiver")),GameConstants.FORMAT)%>
							</td>
						</tr>
						<tr>
							<td>
							邮件内容
							</td>
							<td colspan="3" width="600px">
							<%=StringUtil.uriDecode(String.valueOf(mailMap.get("mailContent")),GameConstants.FORMAT)%>
							</td>
						</tr>
						<%List<Map<String,Object>> attList = (List<Map<String,Object>>)mailMap.get("att"); 
							if(attList.size()>0){
							%><tr>
								<td>
									附件：
								</td>
								<td colspan="3"><%
								for(int j =0;j<attList.size();j++){
									
									%>
									<%=attList.get(j).get("name")+"*"+attList.get(j).get("num")%>
									<%
								}
								%></td></tr><%
							}
						%>
					</table>
					<br/>
					<%	
					}			
				}
		 %>
		
		
<script>
//获取用户角色名
function getQuery(url,name,num,callBack)
{
	var xmlHttp;
	var r = function ()
	{
		if (xmlHttp.readyState == 4)
		{
			if (xmlHttp.status == 200)
			{
    //alert(isIE);
				var xmlstr;
				//var xmldoc;
				//var isIE = !!(window.attachEvent && !window.opera);
				//if (isIE) {
				//	xmldoc = xmlHttp.responseXML;
				//} else {
					xmlstr = xmlHttp.responseText;
				//	alert(xmlstr);
				//	var parser = new DOMParser();
				//	xmldoc = parser.parseFromString(xmlstr, "text/xml");
			
				var m = [];
				var t = '';
				var lastNum = false;
				for(var i=0;i<xmlstr.length;i++){
					var tmp = xmlstr.charAt(i);
					if(tmp!=','){
						t += tmp;
						lastNum = true;
					}else{
						if(t != ''){
							m.push(t);
							t = '';
						}
						lastNum = false;
					}
				}
				if(t != ''){
					m.push(t);
				}
				try {
					callBack(m,num);
				}
				catch (e) {
					alert(e.message+xmlstr);
				}
			}
		}
	};

	var create = function (url, r) {
		try {
   // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		}
		catch (e) {

   // Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch (e) {
					return false;
				}
			}
		}

		var string = "roleName="+name;
		xmlHttp.onreadystatechange = r;
		xmlHttp.open("post", url, true);
		xmlHttp.setRequestHeader("content-length",string.length);  
		xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");  
		xmlHttp.send(string);
	};
	create(url, r);
}
</script>
	<script>
		var int_keycode;
         document.onkeyclick = function( event_e ){  
             if( window.event )  
                event_e = window.event;  
           	int_keycode = event_e.charCode||event_e.keyCode;  
         }  

		function queryByName(url,name,num)
		{
    		if(int_keycode==13 || int_keycode==38 || int_keycode==40) return;
    		getQuery(url,name,num,backname);
		}
		function backname(msg,num)
		{
			var option="";
    		if(msg.length>0)
    		{
       			option+="<option value='"+msg[0]+"' selected>"+msg[0]+"</option>";
        		for(var i=1;i<msg.length;i++)
        		{
            		option+="<option value='"+msg[i]+"'>"+msg[i]+"</option>";
        		}
				var str='<SELECT multiple size="11" id="sname'+num+'" NAME="sname'+num+'" onkeyup="if(event.keyCode==13){document.getElementById(\'search'+num+'\').style.display=\'none\';document.getElementById(\'uname'+num+'\').value=this.value;document.getElementById(\'uname'+num+'\').focus();}" style="width:150px" onclick="document.getElementById(\'search'+num+'\').style.display=\'none\';document.getElementById(\'uname'+num+'\').value=this.value">'+
					option+
					'</SELECT>';
        	document.getElementById("search"+num).innerHTML=str;
			}
			document.getElementById("search"+num).style.display="block";
		}
		function panduan(e,num)
		{
			if(document.getElementById("search"+num).style.display=="block"&&(e.keyCode==38 || e.keyCode==40))
 			{
				document.getElementById("search"+num).focus();
			}
			if(e.keyCode==13)
			{
				search();
				document.getElementById("search"+num).style.display="none";
			}
		}
		</script>
	</body>
</html>
