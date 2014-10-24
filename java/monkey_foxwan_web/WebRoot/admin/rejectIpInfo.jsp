<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.stang.game.ffd.service.IGMRejectIpsService"%>
<%@page import="com.stang.game.ffd.service.impl.GMRejectIpsServiceImpl"%>
<%@page import="com.stang.game.ffd.entity.detail.GMRejectIpsDetail"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'rejectIpInfo.jsp' starting page</title>

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
			int startPage = 0;
			int count = 30;
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
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			IGMRejectIpsService igmris = new GMRejectIpsServiceImpl();
			List<GMRejectIpsDetail> gmrid = igmris.findGMRejectIpsDetailByParam(param);
		%>
		<table border="1">
			<tr>
				<td colspan="4">
					所有封IP信息
					<font size=2><a href="rejectIp.jsp">(返回角色管理)</a> </font>
				</td>
			</tr>
			<tr>
				<td width="150px">
					起始IP
				</td>
				<td width="250px">
					结束IP
				</td>
				<td width="250px">
					封IP结束时间
				</td>
				<td width="50px">
					解封
				</td>
			</tr>

			<%
				for (GMRejectIpsDetail gmrli : gmrid) {
			%>
			<tr>
				<td>
					<%=gmrli.getStartIp()%>
				</td>
				<td>
					<%=gmrli.getEndIp()%>
				</td>
				<td>
					<%if(gmrli.getOverTime()==null){%>
					永久
					<% }else{%>
					<%=df.format(gmrli.getOverTime())%>
					<%} %>
				</td>
				<td>
					<a href="delRejectIp.action?startIp=<%=gmrli.getStartIp()%>&endIp=<%=gmrli.getEndIp()%>">解封</a>
				</td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="4">
					<center>
						<%
							int allPage = new GMRejectIpsServiceImpl().getGMRejectIpsCount();
							for (int i = 0; allPage > 0; allPage -= count, i++) {
						%>
						<a href="rejectInfo.jsp?page=<%=i%>&count=<%=count%>&type=1"><%=i + 1%></a>&nbsp;
						<%
							}
						%>
					</center>
				</td>
			</tr>
		</table>
	</body>
</html>
