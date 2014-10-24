<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>商城打折管理</h1>
	<form action="updateshop.action" method="post">
	
	<s:hidden name="id"></s:hidden>
	任务ID：
		<s:textfield name="id" disabled="true"/>
	<br/>
	
	discount：
		<s:textfield name="discount" />
	<br/>
	flag：
		<s:textfield name="flag" />
	<br/>
	month：
		<s:textfield name="month" />
	<br/>
	day：
		<s:textfield name="day" />
	<br/>
	monthend：
		<s:textfield name="monthend" />
	<br/>
		dayend：
		<s:textfield name="dayend" />
	<br/>
	
	<input type="submit" value="更新">
 </form>
	</body>
</html>