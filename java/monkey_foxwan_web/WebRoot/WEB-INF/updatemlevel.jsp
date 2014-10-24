<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectmlevel!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>level：</td><td><s:textfield name="pro.level"/></td></tr>
	<tr><td>exp：</td><td><s:textfield name="pro.exp"/></td></tr>
	<tr><td>allexp：</td><td><s:textfield name="pro.allexp"/></td></tr>
	<tr><td>xyin：</td><td><s:textfield name="pro.xyin"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>

	
	
	
	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>