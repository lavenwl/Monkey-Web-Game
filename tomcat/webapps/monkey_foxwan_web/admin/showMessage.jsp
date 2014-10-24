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
					所有消息日志:
					<font size=2><a href="message.action">(返回消息管理)</a>
					</font>
				</td>
			</tr>
			<tr>
				<td>

				</td>
				<td width="35px">
					类型
				</td>
				<td width="50px">
					操作人
				</td>
				<td>
					操作日期
				</td>
				<td>
					消息内容
				</td>
				<td>
					首次发送时间
				</td>
				<td>
					下次发送时间
				</td>
				<td>
					间隔时间
				</td>
				<td>
					剩余发送次数
				</td>
			</tr>
			<%
						List<MessageManagerDetail> mml = new MessageManagerServiceImpl()
						.findMessageManagerByFlagOrderByOpTime();
				for (int i = 0; i < mml.size(); i++) {
			%>
			<tr>
				<td>
					<input style="width: 10px" type="checkbox" name="id"
						value="<%=mml.get(i).getId()%>" />
				</td>
				<td>
					<%=mml.get(i).getType() == 1 ? "广告" : "<b>系统</b>"%>
				</td>
				<td>
					<%=mml.get(i).getUname()%>
				</td>
				<td>
					<%=df.format(mml.get(i).getOp_time())%>
				</td>
				<td>
					<%=StringUtil.uriDecode(mml.get(i).getMessage(),GameConstants.FORMAT)%><%=mml.get(i).getType() == 1 ? "<br />(超连接"
						+ mml.get(i).getHerf() + ")" : ""%>
				</td>
				<td>
					<%=df.format(mml.get(i).getSend_time())%>
				</td>
				<td>
					<%=df.format(mml.get(i).getNext_time())%>
				</td>
				<td>
					<%=mml.get(i).getInt_time()%>
				</td>
				<td>
					<%=mml.get(i).getTimes() < 0 ? "无限" : mml.get(i)
						.getTimes()%>
				</td>
			</tr>
			<%
			}
			%>
		</table>
	</body>
</html>