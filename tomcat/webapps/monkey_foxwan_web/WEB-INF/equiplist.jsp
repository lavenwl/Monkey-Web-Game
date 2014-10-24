<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	
	<h1>任务列表</h1>
		<s:if test="page<=1">
			<a>上一页</a>
		</s:if>
		<s:else>
			<a href="equiplist.action?page=${page-1 }">上一页</a>
		</s:else>
	当前【
	<s:property value="page"/>
	/
	<s:property value="totalPages"/>
	】页

	<s:if test="page>=totalPages">
			<a>下一页</a>
	</s:if>
	
	<s:else>
			<a href="equiplist.action?page=${page+1 }">下一页</a>
	</s:else>
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp
	<a href="geitwojspequip">添加</a>
	<table border=1>
		<tr>
			<th>id</th>
			
			<th>equipname</th>
			<th>equipurl</th>
			<th>equiptype</th>
		</tr>
	<!-- 在循环过程总，
	struts会将当前循环元素压入root栈顶，
	因此表达式直接写"id",访问的是元素的id属性值 
	stat是一个迭代状态对象，具有index,count,first,last,even,odd。
	-->
	<s:iterator value="gameequips" status="statta">
		<tr>
			<td>${id }</td>
			<td><s:property value="equipname"/></td>
			
			<td>
			<s:property value="equipurl"/>
			</td>
			<td>
			<s:property value="equiptype"/>
			</td>
			<td>
			<a href="projectequip!load.action?id=${id }">更新</a>
			</td>
		</tr>
	</s:iterator>
	</table>
	</body>
</html>
