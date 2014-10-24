<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectbuff!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>name：</td><td><s:textfield name="pro.name"/></td></tr>
	<tr><td>buffdip：</td><td><s:textfield name="pro.buffDip"/></td></tr>
	<tr><td>buffatktime：</td><td><s:textfield name="pro.buffAtktime"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="pro.type"/></td></tr>
	<tr><td>buffkeeptime：</td><td><s:textfield name="pro.buffKeeptime"/></td></tr>
	<tr><td>atkperson：</td><td><s:textfield name="pro.atkperson"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>bufftype：</td><td><s:textfield name="pro.bufftype"/></td></tr>
	<tr><td>bufftime：</td><td><s:textfield name="pro.bufftime"/></td></tr>

	
	
	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>