<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.stang.game.ffd.entity.detail.*"%>
<%@ page import="com.stang.game.ffd.service.impl.*"%>
<%@ page import="com.stang.game.ffd.common.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.stang.game.entity.detail.*"%>
<%@ page import="apiinterface.Home"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Typme" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="../common/js/WebCalendar.js"></SCRIPT>
		<%@ taglib prefix="s" uri="/struts-tags"%>
		<%
			List<ServerDetail> serverlist = null;
			List<String> l = null;
			Home home  = new Home();
			serverlist = home.getServerList();
			l = new ArrayList<String>();
			for(int i = 0; i < serverlist.size(); i++){
				//if(serverlist.get(i).getStatue_on() == 1)
					l.add(serverlist.get(i).getId() + " 服:" + serverlist.get(i).getName());
			}
			request.setAttribute("l", l);
				 %>
	</head>
	<body>
	<br/>
	<h2>请点击更新缓存按钮：</h2>
		<font color="red" size="3">${tip }</font>
		<s:form action="/admin/messagethree.action">
			<br/>
			<br/>
			<table style="border: 2px solid">
				<tr>
					<td>
					
					</td>
				</tr>
				
				<tr>
				</tr>
				<tr style="width: 150px">
					<td>
						<s:select list="#request.l" id="serverids" name="serverids" multiple="true"
							style="width: 150px; height: 200px; overflow-y: hidden;">
							</s:select>
						
					</td>
				</tr>
				<tr>
					<td>
						<center>
							<s:submit name="sure" value="更新" cssStyle="width: 100px"></s:submit>
						</center>
					</td>
				</tr>
			</table>
			
		</s:form>

		
	</body>
</html>