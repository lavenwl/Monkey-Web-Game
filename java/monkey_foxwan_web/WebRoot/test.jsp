<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ page import="apiinterface.*"%>



<%
	Home ha=new Home();
	if("null".equals(ha.home())){
	%>
	<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>数据库测试页面</title>
</head>

<body >
	<div id="linshi"> 
		<div style="height:145px;"></div>
		<div id="tishi">
			<h2>数据库忙碌，无返回！</h2>
	</div>
</body>
</html>
	
	<%
	}
	else{
int a = ha.home();
		%>
		<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


		<head>
			<title>数据库测试页面</title>
		</head>
		
		<body onselectstart="return false">
		
		
		<h1>数据库连接正常，正确返回<%=a%>！</h1>
		
	</body>
</html>
		
		<% 
	}
	%>

