<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="com.stang.game.ffd.dao.impl.GiftBagTypeInfoDaoImpl" %>

<%@ page import="com.stang.game.ffd.service.impl.*"%>
<%@ page import="com.stang.game.ffd.entity.detail.*"%>
<%@ page import="java.util.Map"%>
<%
	List<EntityDubiousDataDetail> leddd =new ArrayList<EntityDubiousDataDetail>();
	if(request.getAttribute("result")==null){
		response.sendRedirect("getViolationDataInfo.action");
	}else{
	   leddd=(List<EntityDubiousDataDetail>)request.getAttribute("result");
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> 'violation.jsp' </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  <table>
  <tr>
  <td>买家</td>
  <td>卖家</td>
  <td>物品</td>
  <td>交易时间</td>
  </tr>
	<%
		for(EntityDubiousDataDetail eddd:leddd){
			%>
			<tr>
			<td><%=eddd.getBuyers() %></td>
			<td><%=eddd.getSeller() %></td>
			<td><%=eddd.getITEMNAME() %></td>
			<td><%=eddd.getTodaytime() %></td>
			</tr>
			<%
		}
	 %>
	 </table>
  </body>
</html>
