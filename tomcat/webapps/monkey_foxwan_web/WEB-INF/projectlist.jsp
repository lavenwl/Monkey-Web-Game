<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
	<%@ page import="java.text.SimpleDateFormat"%>
	<%@ page import="java.util.*"%>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<%SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							String now = df.format(new Date());%>
	<s:form action="searchPay.action" method="post" enctype ="multipart/form-data" onsubmit="return checkPage()" >
<div>
	<table>
		<tr>
		<td>请输入openid查询：
			<s:textfield name="openid" id="openid" ></s:textfield>
			
			</td>
			
		</tr>
		<tr>
		<td>请输入查询时间：
			<input type="text" name="cxtime" onclick="SelectDate(this,'yyyy-MM-dd')"  
		  readonly="readonly"  style="width: 145px" value="<%=now%>"/>
			<s:submit value="点击查询"></s:submit>
			</td>
			
		
		</tr>
	</table>
</div>
</s:form>
<br/>
	
	<h1>充值列表</h1>
		<s:if test="page<=1">
			<a>上一页</a>
		</s:if>
		<s:else>
			<a href="list.action?page=${page-1 }">上一页</a>
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
			<a href="list.action?page=${page+1 }">下一页</a>
	</s:else>
	<table border=1>
		<tr>
			<th>id编号</th>
			<th>openid</th>
			<th>payitem</th>
			<th>totalmoney</th>
			<th>time</th>
		</tr>
	<!-- 在循环过程总，
	struts会将当前循环元素压入root栈顶，
	因此表达式直接写"id",访问的是元素的id属性值 
	stat是一个迭代状态对象，具有index,count,first,last,even,odd。
	-->
	<s:iterator value="pros" status="stat">
		<tr>
			<td>${id }</td>
			<td><s:property value="openid"/></td>
			<td>
			<s:property value="payitem"/>
			</td>
			<td>
			<s:property value="totalmoney"/>
			</td>
			<td>
			<s:property value="time"/>
			</td>
			
		</tr>
	</s:iterator>
	</table>
<br>
<br/>

<div>
合计金额：<s:textfield name="allmoney" id="allmoney"  disabled="true"/>
<!-- 实际金额：<s:textfield name="allmoneysj" id="allmoneysj"  disabled="true"/> -->
<br/>
<!-- 充值黄钻人数：<s:textfield name="hznum" id="hznum"  disabled="true"/>  -->
</div>
		

	</body>
	
</html>
