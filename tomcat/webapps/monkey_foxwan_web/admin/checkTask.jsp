<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameSkillDetail"%>
<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
    Map<String,Integer> resultMap = new HashMap<String,Integer>();
     List<EntityGameSkillDetail> lresult= new ArrayList<EntityGameSkillDetail>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkTask.action?type=1");
    }else{
   		resultMap=( Map<String,Integer>)request.getAttribute("results");
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

<s:form action="checkTask.action?type=1" method="post" enctype ="multipart/form-data" >
 <div>
		<table>
		<tr>
		<td>起始时间：<input type="text" name="stime1" id="stime1" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td>结束时间：<input type="text" name="stime2" id="stime2" onclick="MyCalendar.SetDate(this)" readonly="readonly" /></td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
		</table>
        </div>
        </s:form>
       
	<table border=1 width="700px">
	<tr>
	<td>任务名</td>	
	<td>完成次数</td>
	</tr>
	<%
	Iterator<Map.Entry<String,Integer>> it = resultMap.entrySet().iterator();
	while(it.hasNext()){	
		Map.Entry entry=it.next();
	%>
	<tr>
	<td><%=java.net.URLDecoder.decode(entry.getKey().toString(),"UTF-8") %></td>
	<td><%=entry.getValue() %></td>
	</tr>
	<%
	}
	 %>
	
	</table>
</body>
</html>