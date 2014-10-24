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
     Map<String,Object> resultMap= new HashMap<String,Object>();
     int count=0;
     int cutterPage=0;
    if(request.getAttribute("results")==null){
    	response.sendRedirect("readCheckForDay15minits.action?pagetype=2");
    }else if(request.getAttribute("results").toString()=="one"){
    	response.sendRedirect("checkDayOne.action");
    } else{
   		resultMap=( Map<String,Object>)request.getAttribute("results");
   		lecld=(List<EntityCheckDayDetail>)resultMap.get("results");
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
<script type="text/javascript">
function checkPage(){

	if(document.getElementById("stime1").value=="请选择日期"){
	alert("必须有时间才可以进行操作");	
		return false;
	}else{
		return true;
	}
	
}
</script>
</head>
<body>
<s:form action="readCheckForDay15minits.action" method="post" enctype ="multipart/form-data" onsubmit="return checkPage()" >
<div>
	<table>
		<tr>
		<td>选择时间：<input type="text" name="stime1" id="stime1" onclick="MyCalendar.SetDate(this)" readonly="readonly" value="请选择日期" /></td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
	</table>
</div>
</s:form>  
	<table border=1 width="700px">
	<tr>	
	<td rowspan="2">日期</td>
	<td colspan="6">当日注册用户(当天新增用户数据)</td>
	<td colspan="2">当日所有用户(当天所有用户的数据)</td>
	<td colspan="2">当日在线用户</td>
	<td rowspan="2">登陆游戏的老用户</td>
	<td rowspan="2">进入游戏的老用户</td>
	<!-- <td>刷新数据</td>  -->
	<tr>
	<td>平台新引入数</td>
	<td>平台总引入数</td>
	<td>看到创建角色界面</td>
	<td>创建角色数</td>
	<td>开始新手引导的新玩家数</td>
	<td>完成新手引导的新玩家数</td>
	<td>当日登陆游戏用户数</td>
	<td>进入游戏玩家用户数</td>
	<td>最高在线</td>
	<td>平均在线</td>
	<!-- <td>看到就点</td>  -->
	</tr>
	<tr>
	<td colspan=26">
	<!-- <s:form action="checkDay.action" method="post" enctype ="multipart/form-data" >
	<input type="hidden" name="execl" id="execl" value="1" />
		<input type="submit" value="生成xml" name="addnewsdone" />
		</s:form> -->
	</td></tr>
	<%
	int regman=0;
	for(EntityCheckDayDetail ecd:lecld){
	regman+=ecd.getRegMan();
	%>
	<tr>
	<td><%=ecd.getDate() %></td>
	<td><%=ecd.getPpsIn() %></td>
    <td><%=ecd.getNewPlayer() %></td>
	<td><%=ecd.getRegsuccess() %></td>
	<td><%=ecd.getRegMan() %></td>
	<td><%=ecd.getNov1() %></td>
	<td><%=ecd.getNov47() %></td>
	<td><%=ecd.getNewPlayer()+ecd.getOldPlayer() %></td>
	<td><%=ecd.getNov1()+ecd.getOldPlayerLodin() %></td>
	
	<td><%=ecd.getMaxOnline() %></td>
	<td><%=ecd.getAvgNum() %></td>
	
	<td><%=ecd.getOldPlayer() %></td>
	<td><%=ecd.getOldPlayerLodin() %></td>
	<td><!-- <a href="checkForDay.action?stime1=<%=ecd.getDate() %>&id=<%=ecd.getAvgNum() %>" >刷新</a> --></td>	
	</tr>
	<%
	}
	 %>
	<tr><td>总计</td><td>新增<%=regman %>新玩家</td></tr>
	<tr>
	<td></td>
	<td colspan="2">
	<%
		for(int i=0;i<count;i++){
		%>
		<a href="readCheckForDay15minits.action?page=<%=i %>"><%=i%></a>
		<%
		}
	 %>
	</td>
	</tr>
	</table>
</body>
</html>