<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>任务更新</h1>
	
	<s:form action="updateactivity.action?activity=activity" 
		method="post" theme="simple">
		<table>
	<tr><td>活动ID：</td><td><s:textfield name="activity.id" readonly="true"/></td></tr>
	<tr><td>url：</td><td><s:textfield name="activity.url"/></td></tr>
	<tr><td>type：</td><td><s:textfield name="activity.type"/></td></tr>
	<tr><td>conditions：</td><td><s:textfield name="activity.conditions"/></td></tr>
	<tr><td>reward：</td><td><s:textfield name="activity.reward"/></td></tr>
	<tr><td>flag：</td><td><s:textfield name="activity.flag"/></td></tr>
	<tr><td>month：</td><td><s:textfield name="activity.month"/></td></tr>
	<tr><td>day：</td><td><s:textfield name="activity.day"/></td></tr>
	<tr><td>monthend：</td><td><s:textfield name="activity.monthend"/></td></tr>
	<tr><td>dayend：</td><td><s:textfield name="activity.dayend"/></td></tr>
	<tr><td>description：</td><td><s:textfield name="activity.description"/></td></tr>
	<tr><td>tipurl：</td><td><s:textfield name="activity.tipurl"/></td></tr>
	<tr><td>isnew：</td><td><s:textfield name="activity.isnew"/></td></tr>
	</table>
		<input type="submit" value="更新">
	</s:form>
	</body>
</html>