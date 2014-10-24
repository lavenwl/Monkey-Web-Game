<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectbmap!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>name：</td><td><s:textfield name="pro.name"/></td></tr>
	<tr><td>dengji：</td><td><s:textfield name="pro.dengji"/></td></tr>
	<tr><td>nandu：</td><td><s:textfield name="pro.nandu"/></td></tr>
	<tr><td>chubing：</td><td><s:textfield name="pro.chubing"/></td></tr>
	<tr><td>isagain：</td><td><s:textfield name="pro.isagain"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>startlv：</td><td><s:textfield name="pro.startlv"/></td></tr>
	<tr><td>startnum：</td><td><s:textfield name="pro.startnum"/></td></tr>
	<tr><td>getexp：</td><td><s:textfield name="pro.getexp"/></td></tr>
	<tr><td>getyin：</td><td><s:textfield name="pro.getyin"/></td></tr>
	<tr><td>getgongxun：</td><td><s:textfield name="pro.getgongxun"/></td></tr>

	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>