<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityCheckGoldItemDetail"%>
<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.text.DecimalFormat"%>
<%
DecimalFormat df=new DecimalFormat("#.00");
 %>
    <%
     List<EntityCheckGoldItemDetail> Lecgid= new ArrayList<EntityCheckGoldItemDetail>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkGoldSell.action");
    }else{
   		Lecgid=( List<EntityCheckGoldItemDetail> )request.getAttribute("results");
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

<!--<s:form action="checkSell.action" method="post" enctype ="multipart/form-data" >
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
	<td>日期</td>
	<td>强化消费</td>
	<td>改造消费</td>
	<td>鉴定</td>
	<td>洗练</td>
	<td>上架拍卖物</td>
	<td>购买战斗道具</td>
	<td>工会捐献</td>
	<td>总消耗</td>
	</tr>
	<%
		long ServerMoney=0;
		long sell=0;
		for(EntityCheckGoldItemDetail ecgid:Lecgid){
		
		if(ecgid.getDateTime()!=null){
		ServerMoney=ecgid.getServerGold();
		sell+=ecgid.getGoldType()+ecgid.getGoldType2()+ecgid.getGoldType3()+ecgid.getGoldType4()+ecgid.getGoldType5()+ecgid.getGoldType6()+ecgid.getGoldType7();
	 %>
	<tr>
	<td><%=ecgid.getDateTime() %></td>
	<td><%=ecgid.getGoldType() %></td>
	<td><%=ecgid.getGoldType2() %></td>
	<td><%=ecgid.getGoldType3()%></td>
	<td><%=ecgid.getGoldType4() %></td>
	<td><%=ecgid.getGoldType5() %></td>
	<td><%=ecgid.getGoldType6() %></td>
	<td><%=ecgid.getGoldType7() %></td>
	<td><%=sell %></td>
	</tr>
	<%
	}
	 }
	 %>
	<tr>
	<td>当前游戏中的游戏币总数</td>
	<td colspan="8">
	<%=ServerMoney %>
	</td>
	</tr>
	</table>
	
</body>
</html>