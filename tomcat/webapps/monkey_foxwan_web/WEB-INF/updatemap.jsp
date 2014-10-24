<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectmap!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>任务ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>name：</td><td><s:textfield name="pro.name"/></td></tr>
	<tr><td>desc：</td><td><s:textfield name="pro.desc"/></td></tr>
	<tr><td>battery：</td><td><s:textfield name="pro.battery"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>getgongxun：</td><td><s:textfield name="pro.getgongxun"/></td></tr>
	<tr><td>getexp：</td><td><s:textfield name="pro.getexp"/></td></tr>
	<tr><td>getyin：</td><td><s:textfield name="pro.getyin"/></td></tr>
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>