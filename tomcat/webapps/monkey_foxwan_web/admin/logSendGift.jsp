<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.stang.game.ffd.entity.detail.*"%>
<%@ page import="com.stang.game.ffd.service.impl.*"%>
<%@ page import="com.stang.game.ffd.common.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<%@ taglib prefix="s" uri="/struts-tags"%>
	</head>
	<body>
		<font color="red" size="3">${tip }</font>
		<%
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = df.format(new Date());
		%>

		<table border="1">
			<tr>
				<td colspan=9>
					所有系统邮件日志:
					<font size=2><a href="sendGift.jsp">(返回发送邮件管理)</a> </font>
				</td>
			</tr>
			<tr>
				<td width="70px">
					标题
				</td>
				<td width="250px">
					附件
				</td>
				<td width="100px">
					接受者
				</td>
				<td width="250px">
					内容
				</td>
				<td width="50px">
					操作人
				</td>
				<td width="90px">
					操作日期
				</td>
				<td width="40px">
					状态
				</td>
			</tr>
			<%
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
				List<LogSendGiftDetail> lsgd = new LogSendGiftDetailServiceImpl()
						.getLogSendGiftDetail(param);

				for (int i = 0; i < lsgd.size(); i++) {
			%>
			<tr>
				<td>
					<%=lsgd.get(i).getTitle()%>
				</td>
				<td>
					<%=lsgd.get(i).getAttachsContent()%>
				</td>
				<td>
					<%=StangUtil.toHtml(lsgd.get(i).getNames())%>
				</td>
				<td>
					<%=lsgd.get(i).getContent()%>
				</td>
				<td>
					<%=lsgd.get(i).getUname()%>
				</td>

				<td>
					<%=df.format(lsgd.get(i).getOpTime())%>
				</td>

				<td>
					<%=lsgd.get(i).getIsSuccess() == 0 ? "<font color=red>失败</font>"
								: "<font color=blue>成功</font>"%>
				</td>
			</tr>
			<%
			}
			%>
			<tr>
				<td colspan=7><center>
				<%int allPage = new LogSendGiftDetailServiceImpl()
							.getLogSendGiftDetailCount();
					for (int i=0;allPage>0;allPage-=count,i++) {
				%>
					
						<a href="logSendGift.jsp?page=<%=i%>&count=<%=count %>"><%=i+1%></a>&nbsp;
					
				<%
				}
				%></center>
				</td>
			</tr>
		</table>
	</body>
</html>