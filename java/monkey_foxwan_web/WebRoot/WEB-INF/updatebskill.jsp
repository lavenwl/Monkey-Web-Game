<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectbskill!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>name：</td><td><s:textfield name="pro.name"/></td></tr>
	<tr><td>artdesc：</td><td><s:textfield name="pro.artdesc"/></td></tr>
	<tr><td>buffid：</td><td><s:textfield name="pro.buffid"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="pro.type"/></td></tr>
	<tr><td>target：</td><td><s:textfield name="pro.target"/></td></tr>
	<tr><td>jilv：</td><td><s:textfield name="pro.jilv"/></td></tr>
	<tr><td>chufa：</td><td><s:textfield name="pro.chufa"/></td></tr>
	<tr><td>fanwei：</td><td><s:textfield name="pro.fanwei"/></td></tr>
	<tr><td>shanghai：</td><td><s:textfield name="pro.shanghai"/></td></tr>
	<tr><td>cishu：</td><td><s:textfield name="pro.cishu"/></td></tr>
	<tr><td>time：</td><td><s:textfield name="pro.time"/></td></tr>
	<tr><td>bullet：</td><td><s:textfield name="pro.bullet"/></td></tr>
	<tr><td>cd：</td><td><s:textfield name="pro.cd"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>

	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>