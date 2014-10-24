<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projectskill!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>skillName：</td><td><s:textfield name="pro.skillName"/></td></tr>
	<tr><td>skillDesc：</td><td><s:textfield name="pro.skillDesc"/></td></tr>
	<tr><td>skillIcon：</td><td><s:textfield name="pro.skillIcon"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="pro.type"/></td></tr>
	<tr><td>skillMc：</td><td><s:textfield name="pro.skillMc"/></td></tr>
	<tr><td>skillMcclip：</td><td><s:textfield name="pro.skillMcclip"/></td></tr>
	<tr><td>skillType：</td><td><s:textfield name="pro.skillType"/></td></tr>
	<tr><td>mpcost：</td><td><s:textfield name="pro.mpcost"/></td></tr>
	<tr><td>skillCd：</td><td><s:textfield name="pro.skillCd"/></td></tr>
	<tr><td>skillArea：</td><td><s:textfield name="pro.skillArea"/></td></tr>
	<tr><td>skillBuffId：</td><td><s:textfield name="pro.skillBuffId"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>nameurl：</td><td><s:textfield name="pro.nameurl"/></td></tr>
	
	
	
	
	
	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>