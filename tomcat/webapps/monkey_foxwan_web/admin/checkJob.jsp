<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameJobDetail"%>
<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     List<EntityGameJobDetail> legjd= new ArrayList<EntityGameJobDetail>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkJob.action");
    }else{
   		legjd=( List<EntityGameJobDetail> )request.getAttribute("results");
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
	<td>力量</td>
	<td>敏捷</td>
	<td>防御</td>
	</tr>
	<%
	for(EntityGameJobDetail egjd:legjd){
	%>
	<tr>
	<td><%=egjd.getStrength() %></td>
	<td><%=egjd.getAgility() %></td>
	<td><%=egjd.getDefanse() %></td>
	</tr>
	<%
	}
	 %>
	
	</table>
</body>
</html>