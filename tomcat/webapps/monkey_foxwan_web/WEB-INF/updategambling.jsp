<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectbling!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>mId：</td><td><s:textfield name="pro.mId"/></td></tr>
	<tr><td>typeId：</td><td><s:textfield name="pro.typeId"/></td></tr>
	<tr><td>cost：</td><td><s:textfield name="pro.cost"/></td></tr>
	<tr><td>is_rare：</td><td><s:textfield name="pro.is_rare"/></td></tr>
	<tr><td>rare_num：</td><td><s:textfield name="pro.rare_num"/></td></tr>
	<tr><td>rare_num_now：</td><td><s:textfield name="pro.rare_num_now"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>is_show：</td><td><s:textfield name="pro.is_show"/></td></tr>
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>