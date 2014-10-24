<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityGameConsortiaDetail"%>
<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

    <%
     List<EntityGameConsortiaDetail> legcd= new ArrayList<EntityGameConsortiaDetail>();
     int count=0;
     int cutterPage=0;
      Map<String,Object> resultMap= new HashMap<String,Object>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkGuild.action");
    }else{
   		//legcd=( List<EntityGameConsortiaDetail> )request.getAttribute("results");
   		
   		resultMap=( Map<String,Object>)request.getAttribute("results");
   		legcd=( List<EntityGameConsortiaDetail> )resultMap.get("results");
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
	<td>工会名称</td>
	<td>工会等级</td>
	<td>工会金币</td>
	<td>会长</td>
	<td>创建时间</td>
	</tr>
	<%
		
	 %>
	<%
	for(EntityGameConsortiaDetail egcd:legcd){
	
	%>
	<tr>
	<td><%=java.net.URLDecoder.decode(egcd.getConsortiaName(),"UTF-8")%></td>
	<td><%=egcd.getConsortiaLevel()%></td>
	<td><%=egcd.getConsortiaCoin()%></td>
	<td><%=java.net.URLDecoder.decode(egcd.getEgrd().getRoleName(),"UTF-8") %></td>
	<td><%=egcd.getCtime() %></td> 
	</tr>
	<%
	}
	 %>
	<tr>
	<td></td>
	<td colspan="3">
	<%
		for(int i=0;i<count;i++){
		%>
		<a href="checkGuild.action?pagetype=2&page=<%=i %>"><%=i%></a>
		<%
		}
	 %>
	</td></tr>
	</table>
</body>
</html>