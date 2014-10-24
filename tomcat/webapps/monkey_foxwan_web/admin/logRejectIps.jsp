<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.stang.game.ffd.entity.detail.LogRejectIpsDetail"%>
<%@page import="com.stang.game.ffd.service.impl.LogRejectIpsServiceImpl"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'logRejectIps.jsp' starting page</title>
    
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
  	<table border="1">
			<tr>
				<td colspan="7">
					封IP日志查看<font size=2><a href="rejectIp.jsp">(返回角色管理)</a> </font>
				</td>
			</tr>
			<tr>
				<td width="130px">
					操作内容
				</td>
				<td width="120px">
					起始IP
				</td>
				<td width="120px">
					结束IP
				</td>
				<td width="250px">
					封IP结束时间
				</td>
				<td width="70px">
					操作人
				</td>
				<td width="250px">
					操作时间
				</td>
				<td width="70px">
					状态
				</td>
			</tr>
			<%
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String now = df.format(new Date());
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
				
				List<LogRejectIpsDetail> logRejectList = new LogRejectIpsServiceImpl().getLogRejectIpsDetailByParam(param);
				for (LogRejectIpsDetail lrd : logRejectList) {
			%>
			<tr>
				<td>
					<%switch(lrd.getType()){
						case 1:
							%>封锁IP<%
							break;
							case 2:
							%>解禁IP<%
							break;
							}
					%>
				</td>
				<td>
					<%=lrd.getStartIp()%>
				</td>
				<td>
					<%=lrd.getEndIp()%>
				</td>
				<td>
					<%if(lrd.getOverTime()==null){ %>
					永久
					<%}else{ %>
					<%=df.format(lrd.getOverTime())%>
					<%} %>
				</td>
				<td>
					<%=lrd.getUname()%>
				</td>
				<td>
					<%=df.format(lrd.getOpTime())%>
				</td>
				<td>
					<%=lrd.getIsSuccess()== 0 ? "<font color=red>失败</font>"
								: "<font color=blue>成功</font>"%>
				</td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="7">
				<center>
				<%
					
				int allPage = new LogRejectIpsServiceImpl().getLogRejectIpsDetailCount();
					for (int i=0;allPage>0;allPage-=count,i++) {
				%>
					
						<a href="logRejectIps.jsp?page=<%=i%>&count=<%=count %>"><%=i+1%></a>&nbsp;
					
				<%
				}
				%>
				</center>
				</td>
			</tr>

		</table>
  	
  </body>
</html>
