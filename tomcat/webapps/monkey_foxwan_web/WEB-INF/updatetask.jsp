<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="projecttask!update.action" 
		method="post" theme="simple">
		<s:hidden name="pro.id"></s:hidden>
		<table>
	<tr><td>ID：</td><td><s:textfield name="pro.id" disabled="true"/></td></tr>
	<tr><td>oldid：</td><td><s:textfield name="pro.oldid"/></td></tr>
	<tr><td>taskname：</td><td><s:textfield name="pro.taskname"/></td></tr>
	<tr><td>taskdesc：</td><td><s:textfield name="pro.taskdesc"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="pro.type"/></td></tr>
	<tr><td>tasktype：</td><td><s:textfield name="pro.tasktype"/></td></tr>
	<tr><td>tasklevel：</td><td><s:textfield name="pro.tasklevel"/></td></tr>
	<tr><td>tasksx：</td><td><s:textfield name="pro.tasksx"/></td></tr>
	<tr><td>tasknum：</td><td><s:textfield name="pro.tasknum"/></td></tr>
	<tr><td>exp：</td><td><s:textfield name="pro.exp"/></td></tr>
	<tr><td>taskcoin：</td><td><s:textfield name="pro.taskcoin"/></td></tr>
	<tr><td>cointype：</td><td><s:textfield name="pro.cointype"/></td></tr>
	<tr><td>taskres：</td><td><s:textfield name="pro.taskres"/></td></tr>
	<tr><td>taskres2：</td><td><s:textfield name="pro.taskres2"/></td></tr>
	<tr><td>taskgoal：</td><td><s:textfield name="pro.taskgoal"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="pro.flag"/></td></tr>
	<tr><td>gongxun：</td><td><s:textfield name="pro.gongxun"/></td></tr>
	<tr><td>junling：</td><td><s:textfield name="pro.junling"/></td></tr>
	
	
	
	
	
	
	
	
	</table>
		
	
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>