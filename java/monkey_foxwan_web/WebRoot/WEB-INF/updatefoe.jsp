<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectfoe!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.foeid"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.foeid" disabled="true"/></td></tr>
	<tr><td>foename：</td><td><s:textfield name="pro.foename"/></td></tr>
	<tr><td>foedesc：</td><td><s:textfield name="pro.foedesc"/></td></tr>
	<tr><td>fangyu：</td><td><s:textfield name="pro.fangyu"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="pro.type"/></td></tr>
	<tr><td>xueliang：</td><td><s:textfield name="pro.xueliang"/></td></tr>
	<tr><td>sudu：</td><td><s:textfield name="pro.sudu"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>

	
	
	
	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>