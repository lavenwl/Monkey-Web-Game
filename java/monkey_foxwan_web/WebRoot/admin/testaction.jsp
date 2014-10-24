<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
 if(request.getAttribute("results")==null){
    	response.sendRedirect("findGameAstrology.action");
     }
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'testaction.jsp' starting page</title>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
