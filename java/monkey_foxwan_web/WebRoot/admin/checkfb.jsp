<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityCheckFbDetail"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     List<EntityCheckFbDetail> lecfd= new ArrayList<EntityCheckFbDetail>();
      Map<String,Object> resultMap= new HashMap<String,Object>();
     int count=0;
     int cutterPage=0;
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkfb.action");
    }else{
    	resultMap=(Map<String,Object>)request.getAttribute("results");
   		lecfd=( List<EntityCheckFbDetail> )resultMap.get("results");
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

<s:form action="checkfb.action" method="post" enctype ="multipart/form-data" >
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
	<td>日期</td>	
	<td>fb开启场次</td>
	<td>胜利场次</td>
	<td>失败场次</td>
	<td>胜率</td>
	<td>败率</td>
	<td></td>
	</tr>
	<tr><td>
	<!-- <s:form action="checkfb.action" method="post" enctype ="multipart/form-data" >
	<input type="hidden" name="execl" id="execl" value="1" />
		<input type="submit" value="生成xml" name="addnewsdone" />
		</s:form> -->
		</td></tr>
	<%
	for(EntityCheckFbDetail ecfd:lecfd){
	%>
	<tr>
	<td><%=ecfd.getDatetime() %></td>
	<td><%=ecfd.getFbnum() %></td>
	<td><%=ecfd.getFbwin() %></td>
	<td><%=ecfd.getFblost() %></td>
	<td><%
	DecimalFormat df=new DecimalFormat("#.00");
	if(ecfd.getFbnum()>ecfd.getFbwin()){
			out.print(df.format(ecfd.getFbwin() / (float)ecfd.getFbnum()*100));
	}
	 %>%</td>
	<td><%
	if(ecfd.getFbnum() > ecfd.getFblost()){
		out.print(df.format(ecfd.getFblost() / (float)ecfd.getFbnum()*100));
	}
	 %>%</td> 
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