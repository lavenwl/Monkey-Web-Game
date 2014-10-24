<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.RoleSiteInfoDetail"%>
<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
    Map<String,Object> result = new HashMap<String,Object>();
    List<RoleSiteInfoDetail> leacd= new ArrayList<RoleSiteInfoDetail>();
    int countNum=0;
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkArea.action");
    }else{
   		result=( Map )request.getAttribute("results");
   		leacd=( List<RoleSiteInfoDetail>)result.get("list");
   	  	countNum=Integer.parseInt(result.get("areaNum")+"");
    }
    
     %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="refresh" content="20">
<!--  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
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
	<td>区号</td>
	<%
	 for(int i=0;i<=countNum;i++){
	 %>
	 <td><%=i+1 %>区</td>
	 <%
	 }
	%>
	</tr>
	
	<tr>
	<td>当前人数</td>
	<%
	for(int i=0;i<=countNum;i++){
	int counnum=0;
		for(RoleSiteInfoDetail temp:leacd){
			if(temp.getRoom_area()==i){//便利当前的人数
				counnum++;
			}
			}
			%>
			<td><%=counnum %></td>
			<%
		}
	 %>
	</tr>
	</table>
</body>
</html>