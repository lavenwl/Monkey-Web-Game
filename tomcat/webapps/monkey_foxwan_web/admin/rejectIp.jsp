<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'rejectIp.jsp' starting page</title>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/WebCalendar.js"></SCRIPT>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<SCRIPT type="text/javascript">
		function checkAll(){
			var startIp=document.getElementById("startIp").value;
			var endIp = document.getElementById("endIp").value;
			if(!isIPa(startIp)){
				alert("起始IP格式不对");
				return false;
			}
			if(!isIPa(endIp)){
				alert("结束IP格式不对");
				return false;
			}
			return true;
		}
		function isIPa(strIP) {
		var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/
		if(re.test(strIP))
		{
		  if( RegExp.$1 <256 && RegExp.$2<256 && RegExp.$3<256 && RegExp.$4<256){
		   return true;
		   }
		}
		return false;
		}
	</SCRIPT>

	<body>
		<s:form action="addRejectIp.action" method="post"	onsubmit="return checkAll()">
			<table>
				<tr>
					<td>
						请输入起始IP：
					</td>
					<td width="180px">
						<input type="text" name="startIp" id="startIp">
					</td>
					<td>
						请输入结束IP：
					</td>
					<td>
						<input type="text" name="endIp" id="endIp">
					</td>
				<tr>
					<td>
						请输入封停时间：
					</td>
					<td >
						<input name="timeEnd" id="timeEnd" type="text" value=""
							id="stime2" onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"
							readonly="true" style="cursor: pointer" />
					</td>
					<td colspan="2">
						<font color=red size=2>
							说明:如不填写时间将作为永久处理。
							</td>
				</tr>
				<tr>
					<td colspan="4">
						<s:submit value="提交"></s:submit>
							<font size=2><a href="rejectIpInfo.jsp">(封IP信息查看)</a>&nbsp;<a href="logRejectIps.jsp">(封IP日志查看)</a>
							</font>
					</td>
				</tr>
			</table>
		</s:form>
	</body>
</html>
