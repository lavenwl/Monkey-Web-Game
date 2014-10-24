<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityCheckDayDetail"%>
<%@page import="java.util.*" %>
<%@page import="java.text.DecimalFormat"%>
<%
DecimalFormat df=new DecimalFormat("#.00");
 %>

 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
//   List<Map<String,Object>> listMap= new ArrayList<Map<String,Object>>();
  Map<String,Map<String,Object>> maplist = new HashMap<String,Map<String,Object>>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("getCheckMap.action");
     }else{
//   		listMap=( List<Map<String,Object>> )request.getAttribute("results");
		maplist=(Map<String,Map<String,Object>>)request.getAttribute("results");
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
<s:form action="checkBattleForDay.action" method="post" enctype ="multipart/form-data" >
<div>
	<table>
		<tr>
		<td><br>起始时间：<input type="text" name="stime1" id="stime1" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
	</table>
</div>
</s:form>
	<table border=1 width="700px">
	<%
		Iterator<Map.Entry<String,Map<String,Object>>> it = maplist.entrySet().iterator();
		%>
		<%
		while(it.hasNext()){
			Map.Entry entry = it.next();
			%>
				<tr>
			<td><%=entry.getKey() %></td>
			<td><%=entry.getValue() %></td>
			</tr>
			<%
		}
		%>
	</table>
</body>
</html>