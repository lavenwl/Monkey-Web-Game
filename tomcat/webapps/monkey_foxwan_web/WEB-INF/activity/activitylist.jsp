<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<html>
	<head>
	</head>
	<body >

	<table border=1>
		<tr>
			<th>id</th>
			<th>type</th>
			<th>flag</th>
			<th>month</th>
			<th>day</th>
			<th>monthend</th>
			<th>dayend</th>
			<th>isnew</th>
		</tr>
	<!-- 在循环过程总，
	struts会将当前循环元素压入root栈顶，
	因此表达式直接写"id",访问的是元素的id属性值 
	stat是一个迭代状态对象，具有index,count,first,last,even,odd。
	-->
	<s:iterator value="activity" status="statta">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="type"/></td>
			<td><s:property value="flag"/></td>
			<td><s:property value="month"/></td>
			<td><s:property value="day"/></td>
			<td><s:property value="monthend"/></td>
			<td><s:property value="dayend"/></td>
			<td><s:property value="isnew"/></td>
			<td><a href="activitylist2?id=${id }">更新</a></td>
		</tr>
	</s:iterator>
	</table>
	</body>
</html>
