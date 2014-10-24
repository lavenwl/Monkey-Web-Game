<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.entity.detail.EntityCheckBattleDetail"%>
<%@page import="java.util.*" %>
 <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <%
     List<EntityCheckBattleDetail> lecbd= new ArrayList<EntityCheckBattleDetail>();
      Map<String,Object> map1=new HashMap<String,Object>();
    if(request.getAttribute("results")==null){
    	response.sendRedirect("checkBattle.action");
    }else{
   		lecbd=( List<EntityCheckBattleDetail> )request.getAttribute("results");
    }	
     %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>check day</title>
<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/WebCalendar.js"></SCRIPT>
</head>
<body>
<s:form action="checkBattleForDay.action" method="post" enctype ="multipart/form-data" >
 <div>
		<table>
		<tr>
		<td>选择时间：
		<input name="startTime" id="startTime" type="text" value=""
							id="stime2" onclick="SelectDate(this,'yyyy-MM-dd')"
							readonly="true" style="cursor: pointer" />
		</td>
		<td><input type="submit" value="查询" name="addnewsdone" /></td>
		</tr>
		</table>
        </div>
        </s:form>
	<table border=1 width="700px">
	<tr>	
	<td>房间号</td>
	<td>房间类型</td>
	<td>战斗时间</td>
	<td>玩家总数</td>
	<td>地图编号</td>
	<td>A队伍</td>
	<td>B队伍</td>
	<td>获胜队伍</td>
	</tr>
	
	<%
	for(EntityCheckBattleDetail ecbd:lecbd){
	%>
	<tr>
	<td><%=ecbd.getRoomNum() %></td>
	<td><%
	switch(ecbd.getRoomType()){
		case 1:out.print("挑战");break;
		case 2:out.print("撮合");break;
		case 3:out.print("副本");break;
		case 4:out.print("活动");break;
	}
	 %></td> 
	<!-- <td><%
	switch(ecbd.getBattleType()){
		case 1:out.print("自由组队");break;
		case 2:out.print("撮合");break;
		case 3:out.print("pve");break;
	}
	
	 %></td> -->
	<td><%=(ecbd.getEndTime()-ecbd.getStartTime())/1000/60 %>分钟</td>
	<td><%=ecbd.getPlayerCount() %></td>
	<td><%=ecbd.getMapId() %></td>
	<td><%=ecbd.getTeamA() %></td>
	<td><%
	if(ecbd.getTeamB().equals("[]")){
		out.print("机器人");
	}else{
		out.print(ecbd.getTeamB());	
	}
	 %></td>
	<td><%
		switch(Integer.parseInt(ecbd.getWinTeam())){
			case 1:out.print("A");break;
			case 2:out.print("B");break;
		}
	 %>队伍</td>
	</tr>
	<%
	}
	 %>
	
	</table>
</body>
</html>