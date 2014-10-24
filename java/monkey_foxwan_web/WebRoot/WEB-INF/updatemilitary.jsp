<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectmilitary!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>name：</td><td><s:textfield name="pro.name"/></td></tr>
	<tr><td>pingzhi：</td><td><s:textfield name="pro.pingzhi"/></td></tr>
	<tr><td>pztype：</td><td><s:textfield name="pro.pztype"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="pro.type"/></td></tr>
	<tr><td>gongji：</td><td><s:textfield name="pro.gongji"/></td></tr>
	<tr><td>gongsu：</td><td><s:textfield name="pro.gongsu"/></td></tr>
	<tr><td>fanwei：</td><td><s:textfield name="pro.fanwei"/></td></tr>
	<tr><td>gjiacheng：</td><td><s:textfield name="pro.gjiacheng"/></td></tr>
	<tr><td>xljiacheng：</td><td><s:textfield name="pro.xljiacheng"/></td></tr>
	<tr><td>xueliang：</td><td><s:textfield name="pro.xueliang"/></td></tr>
	<tr><td>level：</td><td><s:textfield name="pro.level"/></td></tr>
	<tr><td>art：</td><td><s:textfield name="pro.art"/></td></tr>
	<tr><td>arts：</td><td><s:textfield name="pro.arts"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>isshow：</td><td><s:textfield name="pro.isshow"/></td></tr>
	<tr><td>iscompose：</td><td><s:textfield name="pro.iscompose"/></td></tr>
	<tr><td>isaddcompose：</td><td><s:textfield name="pro.isaddcompose"/></td></tr>
	<tr><td>needcompose：</td><td><s:textfield name="pro.needcompose"/></td></tr>
	<tr><td>composeid：</td><td><s:textfield name="pro.composeid"/></td></tr>
	
	
	
	
	
	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>