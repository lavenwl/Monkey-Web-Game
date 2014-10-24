<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.stang.game.service.impl.*"%>
<%@ page import="com.stang.game.entity.detail.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<%@ taglib prefix="s" uri="/struts-tags"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
	</head>
	<body>
		<div id="giftListDiv" style="z-index: 1; display: none; position: absolute; BORDER-RIGHT: 3px outset; BORDER-TOP: 3px outset; BACKGROUND: #ffffff; BORDER-LEFT: 3px outset; BORDER-BOTTOM: 3px outset;" align=left>
			<center>
				<a href="#" onclick="functionCloseGiftList()">关&nbsp;闭</a>
			</center>
			<hr>
				<br/>
			<hr>
			<table border="0">
				<%
					int i = 0;
					int j = 0;
				%>
				<tr <%=j % 4 == 0 ? "style='background-color:#dddddd'" : "style='background-color:#eeeeee'"%>>

					<%
						HashMap<String, Object> param = new HashMap<String, Object>();
						List<GameItemDetail> equipList = new GameItemServiceImpl().getGameItem();
						for (GameItemDetail equip : equipList) {
					%>
					<td>
						<input type="checkbox" onCLick="functionGetGift('<%=equip.getItemname()%>','2-1-<%=equip.getId()%>')" /><%=equip.getItemname()%>
					</td>
					<%
					if (++i % 6 == 0) {
					j++;
					%>
				</tr>
				<tr <%=j % 4 == 0 ? "style='background-color:#dddddd'" : "style='background-color:#eeeeee'"%>>
					<%
					}
					%>

					<%
					}
					%>
				</tr>
				<tr>
					<td colspan=6>
						<hr>
					</td>
				</tr>
				<tr>
					<td colspan=6>
						<hr>
					</td>
				</tr>
			</table>
			<hr>
			<center>
				<a href="#" onclick="functionCloseGiftList()">关&nbsp;闭</a>
			</center>
		</div>
		<form action="sendGift.action" method="post" onSubmit="return getSelect()">
			<div>
				<font color=red size=10><b>${ tip }</b></font>
			</div>
			<table>
				<h1>发送道具列表：</h1>
				<tr>
					<br/>
					<br/>
					<br/>
					<td>
						&nbsp;请选择发送道具：
					</td>
					<td>
						<input id="isGift" type="checkbox" onclick="return functionIsGift()" !checked/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="giftDiv" style="display: none">
							<table>
								<tr>
									<td>
										道具列表：
									</td>
									<td>
										<select id="gifts" name="gifts" multiple="multiple"
											style="width: 150px; height: 250px; overflow-y: hidden;"">
										</select>
									</td>
									<td>
										<input type="button" value="&lt;&lt;-添加"	
											onclick='document.getElementById("giftListDiv").style.display="block";' />
										<br />
										<input type="button" value="-&gt;&gt;移除" onclick="giftsDele()" />											
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</table>
			<br/>
			<br/>
			<table width="395" height="240">
				<tr>
					<td colspan="3">
						请输入openid：
					</td>
				</tr>
				<tr style="width: 150px">
					<td style="vertical-align: top">
						<div style="position: relative">
							<div>
								<input id="uname" type="text"
									style="height: 18px; text-align: center; color: #AB998F; width: 150px"
									>
							</div>
						</div>
					</td>
					<td>
						<input type="button" onclick="unamesAdd()" value="添加-&gt;&gt;" />							
						<p />
						<input type="button" onclick="unamesDele()" value="移除&lt;&lt;-" />	
						<p />
						<input type="button" onclick="confirms()" value="全选-&gt;&gt;" />	
					</td>
					<td>
						<select id="unames" name="unames" multiple="multiple"
							style="width: 150px; height: 200px; overflow-y: hidden;">
                         12
                         21
                         <br/>
                         33
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						请输入serverid：
					</td>
				</tr>
				<tr style="width: 150px">
					<td style="vertical-align: top">
						<div style="position: relative">
							<div>
								<input id="serverid" type="text"
									style="height: 18px; text-align: center; color: #AB998F; width: 150px"
									>
							</div>
						</div>
					</td>
					<td>
						<input type="button" onclick="serveridsAdd()" value="添加-&gt;&gt;" />							
						<p />
						<input type="button" onclick="serveridsDele()" value="移除&lt;&lt;-" />	
					</td>
					<td>
						<select id="serverids" name="serverids" multiple="multiple"
							style="width: 150px; height: 200px; overflow-y: hidden;">
                         12
                         21
                         <br/>
                         33
						</select>
					</td>
				</tr>
			</table>
			<input type="submit" value="提交" style="width:80px"/>
			<input type="hidden" value="0" name="isGift" id="isGiftHidden" />
		</form>



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
			document.getElementById("uname").value="";
 		}
 		
 		function serveridsAdd(){
			var y=document.createElement('option');
  			y.text=document.getElementById("serverid").value;
  			var x=document.getElementById("serverids");
  			try
    		{
				x.add(y,null); // standards compliant
			}
			catch(ex)
			{
				x.add(y); // IE only
			}
			document.getElementById("serverid").value="";
 		}
 		
		function unamesDele(){
			var x=document.getElementById("unames");
			x.remove(x.selectedIndex);
		}
		function serveridsDele(){
			var x=document.getElementById("serverids");
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
			y.value=value+"-"+y.text;
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
		function confirms(){
		//if(confirm("是否全选所有用户")==true){
			//选择是
		var y=document.createElement('option');
  			y.text="所有用户";
  			var x=document.getElementById("unames");
  			x.length=0;
  //			var sel = document.forms["myForm"].elements["sel"];
//sel.length = 0; //为0表全清空，为1表留下一项……
  			//x.remove();
  			x.add(y,null);
		//}else{
		//	return ;
		//}
		
		}
		function functionGetGiftItem(name,id,numS){
			var y=document.createElement('option');
			var num = parseInt(numS);
			if(isNaN(num)||num<1){
				return;
			}
			y.text=name+" X"+num;
			y.value="3-"+num+"-"+id+"-"+y.text;
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
			y.value="5-"+num+"-0-"+y.text;
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
			y.value="0-"+num+"-0-"+y.text;
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
	var selectedList3=  document.getElementById("serverids");
	for(var i=0;i<selectedList1.length;i++){
		selectedList1.options[i].selected = true;
	}
	for(var i=0;i<selectedList2.length;i++){
		selectedList2.options[i].selected = true;
	}
	for(var i=0;i<selectedList3.length;i++){
	   selectedList3.options[i].selected = true;
	}
	return true;
}

		
		</script>

	</body>
</html>