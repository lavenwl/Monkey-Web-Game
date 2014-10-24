<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.service.impl.GameRaceConfServiceImpl"%>
<%@page import="com.stang.game.ffd.service.IGameRaceConfService"%>
<%@page import="com.stang.game.ffd.entity.detail.GameRaceConfDetail"%>
<%@page import="com.stang.game.ffd.common.StringUtil"%>
<%@page import="com.stang.game.ffd.common.GameConstants"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'checkRaceing.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<%
   		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   	IGameRaceConfService igrcs = new GameRaceConfServiceImpl();
	   	int startPage = 0;
		int count = 15;
		Object pageO = request.getParameter("page");
		Object countO = request.getParameter("count");
		HashMap<String, Object> param = new HashMap<String, Object>();
		if (pageO != null && countO != null) {
			try {
				startPage = Integer.parseInt(String.valueOf(pageO));
				count = Integer.parseInt(String.valueOf(countO));
				} catch (Exception e) {
			}
		}
		param.put("startR", startPage * count);
		param.put("count", count);
   		List<GameRaceConfDetail> gameRaceList = igrcs.getGameRaceConfDetail(param);
   		    		 %>
   		  <font color=red size=10><b>${ tip }</b> </font>
   		 <table border="1">
   		 	<tr>
   		 		<td width="170px">比赛名称</td>
   		 		<td width="200px">比赛开始时间</td>
   		 		<td width="200px">比赛报名时间</td>
   		 		<td width="170px">修改</td>
   		 	</tr>
   		 	<%for(GameRaceConfDetail grcd : gameRaceList){
   		 	 %>
   		 	<tr>
	   		 	<td>
	   		 		<%=StringUtil.uriDecode(grcd.getRaceName(),GameConstants.FORMAT) %>
	   		 	</td>
	   		 	<td>
	   		 		<%=df.format(grcd.getStartTime()) %>
	   		 	</td>
	   		 	<td>
	   		 		<%=df.format(grcd.getSignUpStartTime()) %>
	   		 	</td>
	   		 	<td>
	   		 		<a href="raceInfo.jsp?raceId=<%=grcd.getId()%>">查看修改</a>
	   		 		</t>
	   		 		<a href="delRace.action?raceId=<%=grcd.getId()%>">删除</a>
	   		 	</td>
   		 	</tr>
   		 	<%} %>
   		 	<tr>
   		 	
   		 	<td	colspan=4" style="text-align: center">
   		 	<%
					
				int allPage = igrcs.getGameRaceConfCount();
					for (int i=0;allPage>0;allPage-=count,i++) {
				%>
						<a href="checkRaceing.jsp?page=<%=i%>&count=<%=count %>"><%=i+1%></a>&nbsp;
				<%
				}
				%>
   		 	</td>
   		 	</tr>
   		 </table>
  </body>
</html>
