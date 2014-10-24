<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityCheckBuildDetail"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     List<EntityCheckBuildDetail> lecfd= new ArrayList<EntityCheckBuildDetail>();
      Map<String,Object> resultMap= new HashMap<String,Object>();
     int count=0;
     int cutterPage=0;
    if(request.getAttribute("results")==null){
    	response.sendRedirect("check_build_point.action");
    }else{
    	resultMap=(Map<String,Object>)request.getAttribute("results");
   		lecfd=( List<EntityCheckBuildDetail> )resultMap.get("results");
   		count=Integer.parseInt(resultMap.get("pages")+"");
   		cutterPage=Integer.parseInt(resultMap.get("cutterPage")+"");
    }
     %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>check day</title>
<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
</head>
<body>
	<table border=1 width="700px">
	<tr>
	<td>日期</td>	
	<td>战斗大厅</td>
	<td>科研所</td>
	<td>公会</td>
	<td>拍卖</td>
	<td>机库</td>
	<td>宝藏岛</td>
	<td>商城</td>
	<td>后山矿洞</td>
	<td>竞技场模块</td>
	<td>排行榜</td>
	<td>外域远征</td>
	</tr>
	<tr></tr>
	<%
	for(EntityCheckBuildDetail ecbd:lecfd){
	%>
	<tr>
	<td><%=ecbd.getDateTime() %></td>
	<td><%=ecbd.getZddt() %></td>
	<td><%=ecbd.getKyzx() %></td>
	<td><%=ecbd.getGh() %></td>
	<td><%=ecbd.getPmh() %></td>
	<td><%=ecbd.getJk() %></td>
	<td><%=ecbd.getBzd() %></td>
	<td><%=ecbd.getSc() %></td>
	<td><%=ecbd.getHskd() %></td>
	<td><%=ecbd.getJjc() %></td>
	<td><%=ecbd.getPhb() %></td>
	<td><%=ecbd.getWyyz() %></td>
	</tr>
	<%
	}
	 %>
	 <tr>
	 <td><%
		for(int i=0;i<count;i++){
		%>
		<a href="checkfb.action?page=<%=i %>"><%=i%></a>
		<%
		}
	 %></td>
	 </tr>
	</table>
</body>
</html>