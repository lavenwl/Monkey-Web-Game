<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.stang.game.ffd.dao.impl.GiftBagTypeInfoDaoImpl" %>

<%@ page import="com.stang.game.ffd.service.impl.*"%>
<%@ page import="com.stang.game.ffd.entity.detail.*"%>
<%@ page import="java.util.Map"%>

<%
	List<EntityDubiousDataDetail> leddd =new ArrayList<EntityDubiousDataDetail>();
	if(request.getAttribute("result")==null){
		response.sendRedirect("getDoubiousInfo.action");
	}else{
	   leddd=(List<EntityDubiousDataDetail>)request.getAttribute("result");
	}
 %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>礼包创建</title>
    <SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
var rs_giftNameList;
	function change(){
		var select=document.getElementById("giftNameList");
		var text;
		for(var i=0;i<select.length;i++){
			if(select.options[i].selected==true){
				var _value=select.options[i].value;
				document.getElementById("giftBagTypeName").value=_value;
				rs_giftNameList=1;
			}	
		}
	}
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

function functionGetGift1(valueInfo){
	var rs_value = document.getElementById("listName");
	if(rs_value.value.length==0){
		rs_value.value=valueInfo;
	}else{
		rs_value.value+=","+valueInfo;
	}
		
}
var items="";
//检查所有类别的东西是不是有东西
function checkAll(){
	var rs_gbn=document.getElementById("giftBagName").value;
	var rs_ol=document.getElementById("openLive").value;
	var rs_ip=document.getElementById("item_prop").value;
	var rs_gbtn=document.getElementById("giftBagTypeName").value;
	if(rs_gbn=="" || rs_ol=="" || rs_ip=="" || rs_gbtn=="" ||rs_giftNameList=="" ||items=="" ){
		alert("请仔细检查页面，此页面不允许有空值出现。");
		return false;
	}else{
		return true;
	}
}

//获取数量类型的道具信息
function functionGetGiftItem1(valueid,valueNum,valueName){

if(valueNum!="" && valueNum>0){
	valueInfo="3-"+valueNum+"-"+valueid+"-"+valueName;
	items=valueInfo;
	var rs_value = document.getElementById("listName");
	if(rs_value.value.length==0){
		rs_value.value=valueInfo;
	}else{
		rs_value.value+=","+valueInfo;
	}
}
}
		</script>
  </head>
  
  <body>

  <% 
  	List<EntityGiftBagTypeInfoDetail> egbtid= new ArrayList<EntityGiftBagTypeInfoDetail>(); 
  	GiftBagTypeInfoDaoImpl daogb= new GiftBagTypeInfoDaoImpl(); 
  	egbtid=daogb.findGiftBagType(); 
   %>
     <s:form action="addDubiousDataInfo.action" method="post" onsubmit="return checkAll()">
     <table>
     <tr>
    <td>请选择要标记的物品:</td>
    </tr>
    <tr>
    <td>价格上限：<input type="text" name="priceMax" id="priceMax" /></td>
	<td colspan="2">价格下限:<input type="text" name="priceMin" id="priceMin"/></td>
	</tr>
	<tr>
    </tr>
    </table>
    	<s:hidden name="giftBagTypeName" id="giftBagTypeName" /> 
    	选择礼品：
    	飞机类别：
    	<table border=0>
				<%
					int i = 0;
					int j = 0;
				%>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
					: "style='background-color:#eeeeee'"%>>

					<%
						HashMap<String, Object> param = new HashMap<String, Object>();
						List<EntityGameEquipDetail> equipList = new GameEquipServiceImpl()
								.getAllInfo(param);
						for (EntityGameEquipDetail equip : equipList) {
					%>
							<td>
						<input type="checkbox"
							onCLick="functionGetGift1('2-1-<%=equip.getId()%>-<%=equip.getEquipName()%>')" name="checkList" /><%=equip.getEquipName()%></td>
					<%
								if (++i % 6 == 0) {
								j++;
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
									: "style='background-color:#eeeeee'"%>>
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
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
					: "style='background-color:#eeeeee'"%>>
					<%
						i = 0;
						List<EntityGamePlaneDetail> planeList = new GamePlaneServiceImpl()
								.getAllInfo(param);
						for (EntityGamePlaneDetail plane : planeList) {
					%>
					<td>
							<input type="checkbox"
							onCLick="functionGetGift1('1-1-<%=plane.getId()%>-<%=plane.getPlaneName()%>')" /><%=plane.getPlaneName()%></td>
  					<%
								if (++i % 6 == 0) {
								j++;
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
									: "style='background-color:#eeeeee'"%>>
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
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
					: "style='background-color:#eeeeee'"%>>
					<%
						i = 0;
						List<EntityGameAvatarDetail> avatarList = new GameAvatarServiceImpl()
								.getAllInfo(param);
						for (EntityGameAvatarDetail avatar : avatarList) {
					%>
					<td>
													<input type="checkbox"
							onCLick="functionGetGift1('4-1-<%=avatar.getId()%>-<%=avatar.getAvatarName()%>')" /><%=avatar.getAvatarName()%>
							</td>
					<%
								if (++i % 6 == 0) {
								j++;
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
									: "style='background-color:#eeeeee'"%>>
					<%
					}
					%>
					<%
					}
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
					: "style='background-color:#eeeeee'"%>>
					<%
						i = 0;
						List<EntityGameItemsDetail> itemList = new GameItemServiceImpl()
								.getAllInfo(param);
						for (EntityGameItemsDetail item : itemList) {
					%>
					<td>
													<input type="checkbox" style="width: 15px"
							onblur='functionGetGiftItem1("<%=item.getId()%>",1,"<%=item.getItemName()%>")' /><%=item.getItemName()%>
							</td>
					<%
								if (++i % 6 == 0) {
								j++;
					%>
				</tr>
				<tr
					<%=j % 4 == 0 ? "style='background-color:#dddddd'"
									: "style='background-color:#eeeeee'"%>>
					<%
					}
					%>
					<%
					}
					%>
				</tr>
			</table>
			<select id="gifts" name="gifts" multiple="multiple"	style="width: 150px; height: 50px; overflow-y: hidden;"">
			</select>
				<input type="hidden" name="listName" id="listName" value="" />
    	<s:submit value="comic" />
    </s:form>
    
    <div id="doubiousInfo">
    <table>
    <tr>
    <td>itemName</td><td>MAX</td><td>MIN</td><td>EDIT</td>
    </tr>
    <%
    	for(EntityDubiousDataDetail eddd:leddd){
    		%>
    		<tr>
    		<td><%=eddd.getITEMNAME() %></td>
    		<td><%=eddd.getPRICEMAX() %></td>
    		<td><%=eddd.getPRICEMIN() %></td>
    		<td><a href="">删除</a></td>
    		</tr>
    		<%
    	}
     %>
     </table>
    </div>
  </body>
</html>
