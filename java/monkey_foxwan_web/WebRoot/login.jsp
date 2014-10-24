<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登录页面</title>
		
	</head>
	<body>
	
		<form action="loginn.action" method="post">
			<table align="center" style="border: 2px solid;">
				<tr>
					<td align="center">
						<font size="5">LOGIN</font>
					</td>
				</tr>
				<tr>
					<td
						style="background: url('images/site_table_bg.gif') no-repeat scroll right top #EFEFEF">
						username:
						<input type="textfield" name="uname" style="width: 150px"></input>
					</td>
				</tr>
				<tr>
					<td
						style="background: url('images/site_table_bg.gif') no-repeat scroll right top #EFEFEF">
						password:
						<input type="password" name="upassword" style="width: 150px"></input>
					</td>
				</tr>
				<tr>
					<td
						style="background: url('images/site_table_bg.gif') no-repeat scroll right top #EFEFEF"
						align="center">
						<input type="submit" value="enter" style="width: 100px"></input>
					</td>
				</tr>
				<tr>
					<td
						style="background: url('images/site_table_bg.gif') no-repeat scroll right top #EFEFEF"
						align="center">
						<font color="red" size="3">${loginTip}</font>
					</td>
				</tr>
			</table>
			<form>
			
	</body>
</html>