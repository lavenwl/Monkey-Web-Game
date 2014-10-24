<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="project!update" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>任务ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>道具名称：</td><td><s:textfield name="pro.itemname"/></td></tr>
	<tr><td>资源名称：</td><td><s:textfield name="pro.itemres"/></td></tr>
	<tr><td>道具说明：</td><td><s:textfield name="pro.itemprop"/></td></tr>
	<tr><td>itemtype：</td><td><s:textfield name="pro.itemtype"/></td></tr>
	<tr><td>itemlevel：</td><td><s:textfield name="pro.itemlevel"/></td></tr>
	<tr><td>isover：</td><td><s:textfield name="pro.isover"/></td></tr>
	<tr><td>isuse：</td><td><s:textfield name="pro.isuse"/></td></tr>
	<tr><td>isshop：</td><td><s:textfield name="pro.isshop"/></td></tr>
	<tr><td>coin：</td><td><s:textfield name="pro.coin"/></td></tr>
	<tr><td>cointype：</td><td><s:textfield name="pro.cointype"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>reward：</td><td><s:textfield name="pro.reward"/></td></tr>
	<tr><td>quality：</td><td><s:textfield name="pro.quality"/></td></tr>
	<tr><td>itemvip：</td><td><s:textfield name="pro.itemvip"/></td></tr>
	<tr><td>yuanbao：</td><td><s:textfield name="pro.yuanbao"/></td></tr>
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>