<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
	<%@ page import="java.text.SimpleDateFormat"%>
	<%@ page import="java.util.*"%>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	

	<table border=1>
		<tr>
			<th>发放礼品者</th>
			<th>玩家Id</th>
			<th>礼品</th>
			<th>发送时间</th>
			<th>IP地址</th>
		</tr>
	<!-- 在循环过程总，
	struts会将当前循环元素压入root栈顶，
	因此表达式直接写"id",访问的是元素的id属性值 
	stat是一个迭代状态对象，具有index,count,first,last,even,odd。
	-->
	<s:iterator value="lg" status="stat">
		<tr>
			<td><s:property value="menage"/></td>
			<td>
			<s:property value="wanjiaid"/>
			</td>
			<td>
			<s:property value="lipin"/>
			</td>
			<td>
			<s:property value="time"/>
			</td>
			<td>
			<s:property value="ip"/>
			</td>
			
		</tr>
	</s:iterator>
	</table>
<br>
<br/>

		

	</body>
	
</html>
