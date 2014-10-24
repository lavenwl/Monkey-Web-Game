<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntitySellDetail"%>
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
     List<List<EntitySellDetail>> llesd= new ArrayList<List<EntitySellDetail>>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkSell.action");
    }else{
   		llesd=(List<List<EntitySellDetail>> )request.getAttribute("results");
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
	<td>今日充值数</td>
	<td>今日消费数</td>
	<td>充值记录</td>
	<td>充值人数</td>
	<td>ARPU值</td>
	</tr>
	<%
		int ServerMoney=0;
		int payMoney=0;
		int sell=0;
		int payCount=0;
		int paycountpeople=0;
		for(List<EntitySellDetail> lesd:llesd){
		%>
		<tr>
		<%
		for(EntitySellDetail esd:lesd){
		payMoney+=esd.getPayMoney();
		sell+=esd.getSell();
		payCount+=esd.getPayCount();
		paycountpeople+=esd.getPayCountpeople();
	 %>
	
	<td><%=esd.getDatetime() %></td>
	<td><%=esd.getPayMoney() %></td>
	<td><%=esd.getSell() %></td>
	<td><%=esd.getPayCount() %></td>
	<td><%=esd.getPayCountpeople() %></td>
	<td><%
		if(esd.getServerCountPeople()>0){
		out.print(df.format(esd.getPayMoney()/(double)esd.getServerCountPeople()*100)+"%");
		}else{
		out.print("0");
		}
		
	 %></td>
	<%
	ServerMoney=esd.getServerMoney();
	}
	%>
	</tr>
	<%
	}
	 %>
	 <%if(ServerMoney<0){ %>
	<tr style="background-color: red;"><td>当前点券数</td><td colspan="4"><font color="#FFFFFF"><%=ServerMoney%></font></td></tr>
	<%}else{ %>
	<tr style="background-color: green;"><td>当前点券数</td><td colspan="4"><font color="#FFFFFF"><%=ServerMoney%></font></td></tr>
	<%} %>
	<tr>
	<td>总计</td>
	<td><%=payMoney %></td>
	<td><%=sell %></td>
	<td><%=payCount %></td>
	<td><%=paycountpeople %></td>
	</tr>
	</table>
	
</body>
</html>