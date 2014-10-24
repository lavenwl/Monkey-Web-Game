<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
	<%@ page import="java.net.URLEncoder" %>
	<%@ page import="java.net.URLDecoder" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%
      response.setContentType("http://app100719210.qzoneapp.com");//设置为下载application/x-download
      String filedownload = "/aa.url";
      String filedisplay = "Monkey_Game.url";
      filedisplay = URLEncoder.encode(filedisplay,"UTF-8");
     // response.setContentType("text/html;charset=UTF-8");
      response.addHeader("Content-Disposition","attachment;filename=" + filedisplay);
    
      try
      {
          RequestDispatcher dis = request.getRequestDispatcher(filedownload);
          if(dis!= null)
          {
              dis.forward(request,response);
          }
          request.setCharacterEncoding("UTF-8");
          response.flushBuffer();
          out.clear();  
		  out = pageContext.pushBody();  
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      finally
      {
    
      }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'download.jsp' starting page</title>
    
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
    This is my JSP page. <br>
  </body>
</html>
