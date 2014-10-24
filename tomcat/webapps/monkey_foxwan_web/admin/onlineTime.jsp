<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	int arr[]={};
	if(request.getAttribute("resultsOnlineTime")==null){
		//response.sendRedirect("onlineTime.action");
	}else{
		arr=(int [])request.getAttribute("resultsOnlineTime");
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'onlineTime.jsp' starting page</title>
    <SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/WebCalendar.js"></SCRIPT>
<script type="text/javascript">
function checkPage(){

	if(document.getElementById("startTime").value=="请选择日期"){
	alert("必须有时间才可以进行操作");	
		return false;
	}else{
		return true;
	}
	
}
</script>
  </head>
  
  <body>
  <s:form action="onlineTime.action" method="post" enctype ="multipart/form-data" onsubmit="return checkPage()" >
<div>
	<table>
		<tr>
		<td>选择时间：
		<input name="startTime" id="startTime" type="text" value="请选择日期"
							id="stime2" onclick="SelectDate(this,'yyyy-MM-dd')"
							readonly="true" style="cursor: pointer" />
		</td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
	</table>
</div>
</s:form>  
  	在线人数：
  	<table>
  	<tr>
  	<td>小时</td>
  	<td>人数</td>
  	</tr>
  
  		<%
  			for(int i=0;i<arr.length;i++){
  				%>
  			<tr>
  			<td><%=i %></td>
  			<td><%=arr[i] %></td>
  			</tr>	
  				<%
  			}
  		 %>
  		 	</table>
  </body>
</html>
