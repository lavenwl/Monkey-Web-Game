<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>开停服管理</h1>
	<form action="updatefuwu.action" method="post">
	
	<h2>游戏运行状态：1为开服，0为停服：</h2>
	<h3>开服请选1，停服请选0</h3>
	<s:hidden name="id"></s:hidden>
	任务ID：
		<s:textfield name="id" disabled="true"/>
	<br/>
	请选择开停服：<s:textfield name="status"/><br/>
	<br/>
	
	<s:textarea name="message" Style="width: 330px;height:230px">消息内容:</s:textarea>
	<br/>
	<input type="submit" value="添加">
 </form>
	</body>
</html>