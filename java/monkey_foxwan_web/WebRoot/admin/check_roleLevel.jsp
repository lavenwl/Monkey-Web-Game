<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
     List<Map<String,Object>> lMap= null;
    if(request.getAttribute("results")==null){
      response.sendRedirect("searchUserLive.action");
    }else{
   	  lMap=(List<Map<String,Object>>)request.getAttribute("results");
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
<table>
<tr>
<td>人数</td>
<td>等级</td>
</tr>
<%
if(lMap!=null){
for(int i=0;i<lMap.size();i++){
	Map<String,Object> tempMap = lMap.get(i);
	Iterator<Map.Entry<String,Object>> it = tempMap.entrySet().iterator();
	%>
	<tr>
	<%
	while(it.hasNext()){
		Map.Entry entry=it.next();
		%>
		<td><%=entry.getValue() %></td>
		<%
	}
	%>
	</tr>
	<%
}
}
 %>
 </table>
</body>
</html>