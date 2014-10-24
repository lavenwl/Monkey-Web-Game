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
     List<EntityCheckDayDetail> lecld= new ArrayList<EntityCheckDayDetail>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkDay.action?pagetype=2");
    }else{
   		lecld=( List<EntityCheckDayDetail> )request.getAttribute("results");
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
<s:form action="checkDay.action" method="post" enctype ="multipart/form-data" >
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
	<td rowspan="2">日期</td>
	<td colspan="4">当日注册用户(当天新增用户数据)</td>
	<td colspan="2">当日所有用户(当天所有用户的数据)</td>
	<td colspan="2">当日在线用户</td>
	<td rowspan="2">登陆游戏的老用户</td>
	<td rowspan="2">进入游戏的老用户</td>
	<tr>
	<td>pps登陆数121212</td>
	<td>看到创建角色界面</td>
	<td>创建角色数</td>
	<td>进入游戏用户数(新玩家)</td>
	<td>当日登陆游戏用户数</td>
	<td>进入游戏玩家用户数</td>
	<td>最高在线</td>
	<td>平均在线</td>
	
	</tr>
	<tr><td colspan=26">
	<s:form action="checkDay.action" method="post" enctype ="multipart/form-data" >
	<input type="hidden" name="execl" id="execl" value="1" />
		<input type="submit" value="生成xml" name="addnewsdone" />
		</s:form>
	</td></tr>
	<%
	int regman=0;
	for(EntityCheckDayDetail ecd:lecld){
	regman+=ecd.getRegMan();
	%>
	<tr>
	<td><%=ecd.getDate() %></td>
    <td>shit</td>
	
	<td><%=ecd.getRegsuccess() %></td>
	<td><%=ecd.getRegMan() %></td>
	<td><%=ecd.getRegManLogin() %></td>
	<td><%=ecd.getUlt() %></td>
	<td><%=ecd.getAllUserPlayNum() %></td>
	
	<td><%=ecd.getMaxOnline() %></td>
	<td><%=ecd.getAvgNum() %></td>
	<%
		int sum_num=0;
		if(ecd.getUlt() - ecd.getRegsuccess()>0){
			sum_num=ecd.getUlt() - ecd.getRegsuccess();
		}
	 %>
	<td><%=sum_num %></td>
	<td><%=(ecd.getAllUserPlayNum() - ecd.getRegManLogin()) %></td>	
	</tr>
	<%
	}
	 %>
	<tr><td>总计</td><td>新增<%=regman %>新玩家</td></tr>
	</table>
</body>
</html>