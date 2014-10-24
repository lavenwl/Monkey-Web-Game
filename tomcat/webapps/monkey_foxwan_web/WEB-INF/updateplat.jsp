<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectplat!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<s:hidden name="pro.mid"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>mid：</td><td><s:textfield name="pro.mid" disabled="true"/></td></tr>
	<tr><td>res：</td><td><s:textfield name="pro.res"/></td></tr>
	<tr><td>resodds：</td><td><s:textfield name="pro.resodds"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>

	
	
	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>