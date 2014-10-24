<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page
	import="com.stang.game.ffd.service.impl.GMRejectLoginIdsServiceImpl"%>
<%@page import="com.stang.game.ffd.entity.detail.GMRejectLoginIdsDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.stang.game.ffd.entity.detail.GMRejectChatIdsDetail"%>
<%@page import="com.stang.game.ffd.service.impl.GMRejectChatIdsServiceImpl"%>
<%@page import="com.stang.game.ffd.common.StringUtil"%>
<%@page import="com.stang.game.ffd.common.GameConstants"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'rejectInfo.jsp' starting page</title>
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
			Integer type = Integer.parseInt(request.getParameter("type"));
			Object pageO = request.getParameter("page");
			Object countO = request.getParameter("count");
			HashMap<String, Object> param =	 new HashMap<String, Object>();
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
			if (type == 1) {
				List<GMRejectLoginIdsDetail> reject = new GMRejectLoginIdsServiceImpl()
						.getGMRejectLoginIdsDetailByParam(param);
						%>
						<table border="1">
							<tr>
								<td colspan="4">
								所有封号信息
								<font size=2><a href="rejectLogin.jsp">(返回角色管理)</a> </font>
								</td>
							</tr>
							<tr>
								<td width="150px">
								玩家名字
								</td>
								<td width="250px">
								封号起始时间
								</td>
								<td width="250px">
								封号结束时间
								</td>
								<td width="50px">
								解封
								</td>
							</tr>
							
						<%
						for(GMRejectLoginIdsDetail gmrli : reject){
							%>
								<tr>
									<td width="150px">
									<%=StringUtil.uriDecode(gmrli.getRoleName(),GameConstants.FORMAT)%>
									</td>
									<td width="250px">
									<%=df.format(gmrli.getStartTime())%>
									</td>
									<td width="250px">
									<%if(gmrli.getEndTime()==null){ %>
									永久
									<%}else{ %>
									<%=df.format(gmrli.getEndTime())%>
									<%} %>
									</td>		
									<td width="50px">
									<a href="delReject.action?roleId=<%=gmrli.getRoleId()%>&type=1">解封</a>
									</td>
								</tr>
							<%
						}
						%>
						<tr>
							<td colspan="4">
							<center>
				<%int allPage = new GMRejectLoginIdsServiceImpl().getGMRejectLoginIdsDetailCount();
					for (int i=0;allPage>0;allPage-=count,i++) {
				%>
					
						<a href="rejectInfo.jsp?page=<%=i%>&count=<%=count %>&type=1"><%=i+1%></a>&nbsp;
					
				<%
				}
				%></center>
							</td>
						</tr>
						</table>
						<%
			}
			
			if (type == 2) {
				List<GMRejectChatIdsDetail> reject = new GMRejectChatIdsServiceImpl()
						.getGMRejectChatIdsDetailByParam(param);
						%>
						<table border="1">
							<tr>
								<td colspan="4">
								所有禁言信息
								<font size=2><a href="rejectLogin.jsp">(返回角色管理)</a></font>
								</td>
							</tr>
							<tr>
								<td width="150px">
								玩家名字
								</td>
								<td width="250px">
								禁言起始时间
								</td>
								<td width="250px">
								禁言结束时间
								</td>
								<td width="50px">
								解禁
								</td>
							</tr>
							
						<%
						for(GMRejectChatIdsDetail gmrlci : reject){
							%>
								<tr>
									<td width="150px">
									<%=StringUtil.uriDecode(gmrlci.getRoleName(),GameConstants.FORMAT) %>
									</td>
									<td width="250px">
									<%=df.format(gmrlci.getStartTime())%>
									</td>
									<td width="250px">
									<%if(gmrlci.getEndTime()==null){ %>
									永久
									<%}else{ %>
									<%=df.format(gmrlci.getEndTime())%>
									<%} %>
									</td>		
									<td width="50px">
									<a href="delReject.action?roleId=<%=gmrlci.getRoleId()%>&type=2">解禁</a>
									</td>
								</tr>
							<%
						}
						%>
						<tr>
							<td colspan="4">
							<center>
				<%int allPage = new GMRejectChatIdsServiceImpl().getGMRejectChatIdsDetailCount();
					for (int i=0;allPage>0;allPage-=count,i++) {
				%>
					
						<a href="rejectInfo.jsp?page=<%=i%>&count=<%=count %>&type=2"><%=i+1%></a>&nbsp;
					
				<%
				}
				%></center>
							</td>
						</tr>
						</table>
						<%
			}
		%>

	</body>
</html>
