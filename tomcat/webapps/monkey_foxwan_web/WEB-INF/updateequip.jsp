<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectequip!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>equipname：</td><td><s:textfield name="pro.equipname"/></td></tr>
	<tr><td>equipurl：</td><td><s:textfield name="pro.equipurl"/></td></tr>
	<tr><td>equiptype：</td><td><s:textfield name="pro.equiptype"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="pro.type"/></td></tr>
	<tr><td>gongji：</td><td><s:textfield name="pro.gongji"/></td></tr>
	<tr><td>fanwei：</td><td><s:textfield name="pro.fanwei"/></td></tr>
	<tr><td>sudu：</td><td><s:textfield name="pro.sudu"/></td></tr>
	<tr><td>xueliang：</td><td><s:textfield name="pro.xueliang"/></td></tr>
	<tr><td>extra：</td><td><s:textfield name="pro.extra"/></td></tr>
	<tr><td>level：</td><td><s:textfield name="pro.level"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>coin：</td><td><s:textfield name="pro.coin"/></td></tr>
	<tr><td>cointype：</td><td><s:textfield name="pro.cointype"/></td></tr>
	<tr><td>desc：</td><td><s:textfield name="pro.desc"/></td></tr>
	<tr><td>isshop：</td><td><s:textfield name="pro.isshop"/></td></tr>
	<tr><td>quality：</td><td><s:textfield name="pro.quality"/></td></tr>
	
	
	
	
	
	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>