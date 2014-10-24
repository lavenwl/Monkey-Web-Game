<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectequipproperty!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="pro.type"/></td></tr>
	<tr><td>speed：</td><td><s:textfield name="pro.speed"/></td></tr>
	<tr><td>attack：</td><td><s:textfield name="pro.attack"/></td></tr>
	<tr><td>hp：</td><td><s:textfield name="pro.hp"/></td></tr>
	<tr><td>quality：</td><td><s:textfield name="pro.quality"/></td></tr>

	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>