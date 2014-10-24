<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectbing!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>name：</td><td><s:textfield name="pro.name"/></td></tr>
	<tr><td>icon：</td><td><s:textfield name="pro.icon"/></td></tr>
	<tr><td>artdesc：</td><td><s:textfield name="pro.artdesc"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="pro.type"/></td></tr>
	<tr><td>isenemy：</td><td><s:textfield name="pro.isenemy"/></td></tr>
	<tr><td>gongji：</td><td><s:textfield name="pro.gongji"/></td></tr>
	<tr><td>xishu1：</td><td><s:textfield name="pro.xishu1"/></td></tr>
	<tr><td>xueliang：</td><td><s:textfield name="pro.xueliang"/></td></tr>
	<tr><td>xishu2：</td><td><s:textfield name="pro.xishu2"/></td></tr>
	
	<tr><td>fangyu：</td><td><s:textfield name="pro.fangyu"/></td></tr>
	<tr><td>gongsu：</td><td><s:textfield name="pro.gongsu"/></td></tr>
	<tr><td>gongfan：</td><td><s:textfield name="pro.gongfan"/></td></tr>
	<tr><td>shangfan：</td><td><s:textfield name="pro.shangfan"/></td></tr>
	<tr><td>sudu：</td><td><s:textfield name="pro.sudu"/></td></tr>
	<tr><td>renkou：</td><td><s:textfield name="pro.renkou"/></td></tr>
	<tr><td>jiage：</td><td><s:textfield name="pro.jiage"/></td></tr>
	<tr><td>lengque：</td><td><s:textfield name="pro.lengque"/></td></tr>
	<tr><td>bullet：</td><td><s:textfield name="pro.bullet"/></td></tr>
	<tr><td>bulletfly：</td><td><s:textfield name="pro.bulletfly"/></td></tr>
	<tr><td>bullethit：</td><td><s:textfield name="pro.bullethit"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>skill：</td><td><s:textfield name="pro.skill"/></td></tr>
	<tr><td>gongjun：</td><td><s:textfield name="pro.gongxun"/></td></tr>
	<tr><td>bingfu：</td><td><s:textfield name="pro.bingfu"/></td></tr>
	<tr><td>xtype：</td><td><s:textfield name="pro.xtype"/></td></tr>
	
	
	
	
	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>