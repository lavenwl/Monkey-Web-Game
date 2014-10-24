<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>服务器添加</h1>
	<form action="addserver2.action" method="post">
	名称：<input type="text" name="server.name"><br/>
	状态：<input type="text" name="server.statue_mag"><br/>
	推荐：<input type="text" name="server.statue_tui"><br/>
	新服：<input type="text" name="server.statue_xin"><br/>
	开关：<input type="text" name="server.statue_on"><br/>
	<input type="submit" value="添加">
	</form>
	</body>
</html>