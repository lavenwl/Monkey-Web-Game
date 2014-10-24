<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.stang.game.ffd.service.impl.*"%>
<%@ page import="com.stang.game.ffd.entity.detail.*"%>
<%@ page import="java.util.*"%>
<%
	List<EntityCaseLogDetail> lecld = new ArrayList<EntityCaseLogDetail>();
	Map<String,Object> resultMap = new HashMap<String,Object>();
	if(request.getAttribute("results")!=null){
	 resultMap=(Map<String,Object>)request.getAttribute("results");
		lecld =(List<EntityCaseLogDetail>) resultMap.get("result");
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>查询玩家的强化记录</title>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<%@ taglib prefix="s" uri="/struts-tags"%>
	</head>
	<body>
		<s:form action="checkQh.action" method="post" enctype ="multipart/form-data" >
						<div style="position: relative">
							<div>
								<input id="uname" type="text" name="uname"
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
							<div>
							<table>
		<tr>
		<td>起始时间：<input type="text" name="stime" id="stime" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td>结束时间：<input type="text" name="etime" id="etime" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
		
		<%
		if(resultMap!=null){
		out.print(resultMap.get("uname"));
		}
		 %>
		</table>
							</div>
						</div>
						</s:form>
						<div>
						<table>
						<tr><td>强化时间</td><td>强化消耗</td></tr>
						<%
							for(EntityCaseLogDetail ecld:lecld){
								String datetime=ecld.getCase_time().toString();
								String itmes=ecld.getCase_ex_desc();
								String [] itemArray=itmes.split("-");
								String itemsName="";
								for(String tempValue:itemArray){
									switch(Integer.parseInt(tempValue)){
										case 1040:
											itemsName+="初级强化晶片,";break;
										case 1041:
											itemsName+="高级强化晶片,";break;
										case 1042:
											itemsName+="保护结晶,";break;
										case 1043:
											itemsName+="幸运晶片,";break;
									}
								}
								%>
								<tr>
								<td><%=datetime %></td><td><%=itemsName %></td>
								</tr>
								<%
							}
						 %>
						</table>
						</div>
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