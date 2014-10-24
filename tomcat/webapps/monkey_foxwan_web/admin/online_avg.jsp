<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

  <%
  	List<String> lss = new ArrayList<String>();
    
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkOnlineNum.action");
    }
    else{
   		lss=(List<String> )request.getAttribute("results");
    }
     %>
<%@page import="com.stang.game.ffd.entity.detail.EntityCheckDayDetail"%>
<%@page import="java.util.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>5分钟数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


  </head>
  
  <body> 
  <table> 
  <%
  if(lss.size()>1){
  	for(String temps : lss){
  	String[] res=temps.split("-");
  %>
  <tr><td><%=res[0] %></td><td><%=res[1] %></td></tr>
  <%	
  	}
  	}else
  	out.print("当前没有克显示的数据");
   %>
  </table>
  </body>
</html>
