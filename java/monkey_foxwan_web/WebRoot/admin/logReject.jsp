<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.stang.game.ffd.service.impl.LogRejectServiceImpl"%>
<%@page import="com.stang.game.ffd.entity.detail.LogRejectDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'logReject.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<table border="1">
			<tr>
				<td colspan="6">
					封号日志查看<font size=2><a href="rejectLogin.jsp">(返回角色管理)</a> </font>
				</td>
			</tr>
			<tr>
				<td width="100px">
					操作内容
				</td>
				<td width="250px">
					操作对象
				</td>
				<td width="250px">
					操作结束时间
				</td>
				<td width="80px">
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
				Integer type = Integer.parseInt(request.getParameter("type"));
				Integer type1 = Integer.parseInt(request.getParameter("type1"));
				param.put("type", type);
				param.put("type1", type1);
				
				List<LogRejectDetail> logRejectList = new LogRejectServiceImpl()
						.getLogRejectByParam(param);
				for (LogRejectDetail lrd : logRejectList) {
			%>
			<tr>
				<td>
					<%switch(lrd.getType()){
						case 1:
							%>添加封号<%
							break;
							case 2:
							%>添加禁言<%
							break;
							case 3:
							%>解除封号<%
							break;
							case 4:
							%>解除禁言<%
							break;
							}
					%>
				</td>
				<td>
					<%=lrd.getRoleName()%>
				</td>
				<td>
					<%if(lrd.getEndTime()==null){ %>
					永久
					<%}else{ %>
					<%=df.format(lrd.getEndTime())%>
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
				<td colspan="6">
				<center>
				<%
					
				int allPage = new LogRejectServiceImpl().getLogRejectCount(param);
					for (int i=0;allPage>0;allPage-=count,i++) {
				%>
					
						<a href="logReject.jsp?page=<%=i%>&count=<%=count %>&type=<%=type %>&type1=<%=type1 %>"><%=i+1%></a>&nbsp;
					
				<%
				}
				%>
				</center>
				</td>
			</tr>

		</table>

	</body>
</html>
