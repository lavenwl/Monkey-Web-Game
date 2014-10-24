<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>活动管理</h1>
	<form action="updatehuodong.action" method="post">
	
	<s:hidden name="id"></s:hidden>
	任务ID：
		<s:textfield name="id" disabled="true"/>
	<br/>
	请选择活动状态：<s:textfield name="status"/><br/>
	<br/>
	<br/>
	itemid：
		<s:textfield name="itemid"/>
	<br/>
	odds：
		<s:textfield name="odds" />
	<br/>
	mid1：
		<s:textfield name="mid1" />
	<br/>
	mid2：
		<s:textfield name="mid2" />
	<br/>
	res1：
		<s:textfield name="res1" />
	<br/>
	res2：
		<s:textfield name="res2" />
	<br/>
	reses：
		<s:textfield name="reses" />
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
	
	<input type="submit" value="添加">
 </form>
	</body>
</html>