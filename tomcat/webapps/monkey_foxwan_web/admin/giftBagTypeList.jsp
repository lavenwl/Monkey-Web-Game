<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGiftBagTypeInfoDetail" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
	List<EntityGiftBagTypeInfoDetail> legbti = new ArrayList<EntityGiftBagTypeInfoDetail>();;
	if(request.getAttribute("rs")==null){
	response.sendRedirect("findGiftBagTypeInfoAll.action");
	}else{
	legbti=(List<EntityGiftBagTypeInfoDetail>)request.getAttribute("rs");
	}
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>礼包类型列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function showMenu1(valueId){
		var edit_div=document.getElementById("edit_div"+valueId);
		var update_div=document.getElementById("update_div"+valueId);
			if(edit_div.style.display=="none"){
				edit_div.style.display="block";
				//document.getElementById("text"+valueId).readonly=true;
				update_div.style.display="none";
			}else{
				document.getElementById("text"+valueId).removeAttribute('disabled');
				edit_div.style.display="none";
				update_div.style.display="block";
				//alert("请填写新的内容");
			}
		}
		
		function submit_walue(emeId){
			var value=document.getElementById("text"+emeId).value;
			value=encodeURI(value);
			value=encodeURI(value);
		 	location.href="editGiftBagTypeInfoAll.action?giftBagTypeName="+value+"&emeID="+emeId;
		}
		
		function cancel(emeId){
			document.getElementById("edit_div"+emeId).style.display="block";
			document.getElementById("update_div"+emeId).style.display="none";
			document.getElementById("text"+emeId).disabled=true;
		}
		
		function delalert(){
			var rs=confirm("你确定要删除此礼包类型？");
			window.location.href="delGiftBagTypeInfo.action?emeID=1003";
		}
		
		function test(){
			alert("in function test");
		}
	</script>
	
  </head>
  <body> 
   <a href="createGiftBagType.jsp">添加新的礼包类型</a>
   
   <table>
   <tr><td>序号</td><td>类别名称</td><td>编辑状态</td></tr>
   <%
   if(legbti.size()>0){
   		for(EntityGiftBagTypeInfoDetail res:legbti){
   		%>
   			<tr>
   			  <td><%=res.getID() %></td> 
  			  <td><input type="text" disabled="true" id="text<%=res.getID() %>" value="<%=res.getGTI_NAME() %>" /></td>
  			  <td>
  			  <div id="update_div<%=res.getID() %>" style="display:none">
  			  <a href="javascript:void(0)" onclick="submit_walue(<%=res.getID() %>)" >信息录入</a>
  			  <a href="javascript:void(0)" onclick="cancel(<%=res.getID() %>)" >取消</a>
  			  </div>
  			  <div id="edit_div<%=res.getID() %>">
  			  <a href="javascript:void(0)" onclick="showMenu1(<%=res.getID() %>)" >修改当前信息</a>
  			  <a href="delGiftBagTypeInfo.action?emeID=<%=res.getID()%>" onclick="return delalert()">删除信息</a>
  			  </div>
  			  </td>
   	</tr>
   		<%
   		}
   	}
    %>
    </table>
  </body>
</html>
