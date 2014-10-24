<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<%@page import="com.stang.game.ffd.entity.detail.EntityGameAstrologyDetail"%>
<%@page import="java.util.*" %>
<%@page import="java.text.DecimalFormat"%>

<%
	List<EntityGameAstrologyDetail> legad = new ArrayList<EntityGameAstrologyDetail>();
	if(request.getAttribute("results")==null){
		response.sendRedirect("findGameAstrology.action");
	}else{
		legad = (List<EntityGameAstrologyDetail>)request.getAttribute("results");
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>星魂查看界面</title>
  </head>
  <body>
  <table>
  <tr>
  <td>星魂名称</td>
  <td>星魂类别</td>
  <td>加成属性</td>
  <td>资源地址</td>
  <td>编辑</td>
  <td>删除</td>
  </tr>
  <%
 	for(EntityGameAstrologyDetail egad:legad){
 		%>
 		<tr>
 		<td><%=egad.getAstrology_name() %></td>
 		<td><%=egad.getAstrology_type() %></td>
 		<td><%=egad.getAstrology_initial() %></td>
 		<td><%=egad.getAstrology_src()%></td>
 		<td></td>
 		<td></td>
 		</tr>
 		<%
 	}
   %>
    </table>
  </body>
</html>
