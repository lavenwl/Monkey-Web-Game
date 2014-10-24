<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>封号禁言处理</title>
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
		var selectedList1 = document.getElementById("unames");
			for(var i=0;i<selectedList1.length;i++){
				selectedList1.options[i].selected = true;
			}
			var uname = document.getElementById("unames").value;
			if(uname == null||uname==""){
				
			}else{
				
			}
		}
		function changeType(ra){
			if(ra.value=="封号"){
				document.getElementById("rejectType").value = 1;
				document.getElementById("jin").checked = false;
			}else{
				document.getElementById("rejectType").value = 2;
				document.getElementById("fen").checked = false;
			}
		}
	</SCRIPT>
	<body>
		<s:form action="addReject.action" method="post"
			onsubmit="return checkAll()">
		<div>
				<font color=red size=10><b>${ tip }</b></font>
			</div>
			<table>
			<tr>
			<td colspan="3">
			<font size=2><a href="rejectInfo.jsp?type=1">(封号信息查看)</a>&nbsp;<a href="rejectInfo.jsp?type=2">(禁言信息查看)</a>&nbsp;<a href="logReject.jsp?type=1&type1=3">(封号日志查看)</a>&nbsp;<a href="logReject.jsp?type=2&type1=4">(禁言日志查看)</a></font>			
			</td>
			</tr>
				<tr>
					<td colspan="3">
						请输入用户名：
					</td>
			
				</tr>
				<tr style="width: 150px">
					<td style="vertical-align: top">
						<div style="position: relative">
							<div>
								<input id="uname" type="text"
									onkeyup="queryByName('getRoleName.action',this.value);panduan(event)" size="23"
									style="height: 18px; text-align: center; color: #AB998F; width: 150px"
									value="请在这里输入用户名"
									onclick="document.getElementById('uname').value=''">

							</div>
							<div id="search" style="position: absolute; display: none">
								<SELECT id="sname" NAME="sname"
									onkeyup="if(event.keyCode==13){document.getElementById('search').style.display='none';document.getElementById('uname').value=this.value;document.getElementById('uname').focus();}"
									style="width: 150px"
									onclick="document.getElementById('search').style.display='none';document.getElementById('uname').value=this.value">
								</SELECT>
							</div>
						</div>
						<p>
							<font color=red size=2>说明:<br />请根据弹出的下拉列表选<br />择用户并添加。<br />
							</font>
							<br/>
							<br/>
							结束时间：<br/>
							<input name="timeEnd" id="timeEnd" type="text" value=""
							maxlength="100" id="stime2"
							onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')" readonly="true"
							style="width: 150px; cursor: pointer" /><br/>
							<font color=red size=2>
							说明:<br/>如不填写时间将作为永久<br/>处理。
							</font>
						</p>
					</td>
					<td>
						<input type="button" onclick="unamesAdd()" value="添加-&gt;&gt;" />							
						<p />
						<input type="button" onclick="unamesDele()" value="移除&lt;&lt;-" />	
					</td>
					<td>
						<select id="unames" name="unames" multiple="multiple"
							style="width: 150px; height: 200px; overflow-y: hidden;">

						</select>
					</td>
				</tr>
				<tr>
					<td>
					封号<input type="radio" id="fen" checked="checked" onclick="changeType(this)" value="封号"/>
					禁言<input type="radio" id="jin" onclick="changeType(this)" value="禁言"/>
					</td>
				</tr>
				<tr>
					<td>
					<s:submit value="提交"></s:submit>
					</td>
				</tr>
			</table>
			<input type="hidden" id="rejectType" name="rejectType" value="1" />
		</s:form>
		
	<script>
		var int_keycode;
		 
         document.onkeyclick = function( event_e ){  
             if( window.event )  
                event_e = window.event;  
           	int_keycode = event_e.charCode||event_e.keyCode;  
         }  

		function queryByName(url,name)
		{
    		if(int_keycode==13 || int_keycode==38 || int_keycode==40) return;
    		getQuery(url,name,backname);
		}
		function backname(msg)
		{
			var option="";
    		if(msg.length>0)
    		{
       			option+="<option value='"+msg[0]+"' selected>"+msg[0]+"</option>";
        		for(var i=1;i<msg.length;i++)
        		{
            		option+="<option value='"+msg[i]+"'>"+msg[i]+"</option>";
        		}
				var str='<SELECT multiple size="11" id="sname" NAME="sname" onkeyup="if(event.keyCode==13){document.getElementById(\'search\').style.display=\'none\';document.getElementById(\'uname\').value=this.value;document.getElementById(\'uname\').focus();}" style="width:150px" onclick="document.getElementById(\'search\').style.display=\'none\';document.getElementById(\'uname\').value=this.value">'+
					option+
					'</SELECT>';
        	document.getElementById("search").innerHTML=str;
			}
			document.getElementById("search").style.display="block";
		}
		function panduan(e)
		{
			if(document.getElementById("search").style.display=="block"&&(e.keyCode==38 || e.keyCode==40))
 			{
				document.getElementById("sname").focus();
			}
			if(e.keyCode==13)
			{
				search();
				document.getElementById("search").style.display="none";
			}
		}
		
		function unamesAdd(){
			var y=document.createElement('option');
  			y.text=document.getElementById("uname").value;
  			var x=document.getElementById("unames");
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
 		}
		function unamesDele(){
			var x=document.getElementById("unames");
			x.remove(x.selectedIndex);
		}
		function giftsDele(){
			var x=document.getElementById("gifts");
			x.remove(x.selectedIndex);
		}
		function functionIsGift(){
			if(document.getElementById("isGift").checked){
				document.getElementById("giftDiv").style.display="block";
				document.getElementById("giftListDiv").style.display="block";
				document.getElementById("isGiftHidden").value="1";
				return true;
			}else{
				document.getElementById("giftDiv").style.display="none";
				document.getElementById("giftListDiv").style.display="none";
				document.getElementById("isGiftHidden").value="0";
				return true;
			}
		}
		function functionCloseGiftList(){
			document.getElementById("giftListDiv").style.display="none";
		}
		function functionGetGift(name,value){
			var y=document.createElement('option');
			y.text=name;
			y.value=value;
			var x=document.getElementById("gifts");
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
		}
		function functionGetGiftItem(name,id,numS){
			var y=document.createElement('option');
			var num = parseInt(numS);
			if(isNaN(num)||num<1){
				return;
			}
			y.text=name+" X"+num;
			y.value="3-"+num+"-"+id;
			var x=document.getElementById("gifts");
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
		}
		function functionGetGiftMoney(numS){
			var y=document.createElement('option');
			var num = parseInt(numS);
			if(isNaN(num)||num<1){
				return;
			}
			y.text="点券"+" X"+num;
			y.value="5-"+num+"-0";
			var x=document.getElementById("gifts");
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
		}
		function functionGetGiftGold(numS){
			var y=document.createElement('option');
			var num = parseInt(numS);
			if(isNaN(num)||num<1){
				return;
			}
			y.text="金币"+" X"+num;
			y.value="0-"+num+"-0";
			var x=document.getElementById("gifts");
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
		}
</script>
<script>
//获取用户角色名
function getQuery(url,name,callBack)
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
					callBack(m);
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

function getSelect(){
	var selectedList1 = document.getElementById("unames");
	var selectedList2 = document.getElementById("gifts");
	for(var i=0;i<selectedList1.length;i++){
		selectedList1.options[i].selected = true;
	}
	for(var i=0;i<selectedList2.length;i++){
		selectedList2.options[i].selected = true;
	}
	return true;
}

		
		</script>

	</body>
</html>
