<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameOnlineDetail"%>
<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     EntityGameOnlineDetail legjd= new EntityGameOnlineDetail();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkOnline.action");
    }else{
   		legjd=( EntityGameOnlineDetail )request.getAttribute("results");
    }
     %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="20">
<!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>check day</title>
<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
</head>
<body>

<!--<s:form action="checkGuild.action" method="post" enctype ="multipart/form-data" >
 <div>
		<table>
		<tr>
		<td>起始时间：<input type="text" name="stime1" id="stime1" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td>结束时间：<input type="text" name="stime2" id="stime2" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
		</table>
        </div>
        </s:form>-->
	<table border=1 width="700px">
	<tr>	
	<td>在线人数</td>
	<td>选区界面</td>
	<td>房间人数</td>
	<td>战斗人数</td>
	
	</tr>
	
	<tr>
	<td><%=legjd.getOnlineNum() %></td>
	<td><%=legjd.getChageArea() %></td>
	<td><%=legjd.getRoomNum() %></td>
	<td><%=legjd.getBattleNum() %></td>
	
	</tr>
	
	
	</table>
</body>
</html>