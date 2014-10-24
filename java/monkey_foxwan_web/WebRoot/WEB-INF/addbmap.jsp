<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectbmap!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>name：</td><td><input type="text" name="pro.name"></td></tr>
	<tr><td>dengji：</td><td><input type="text" name="pro.dengji"></td></tr>
	<tr><td>nandu：</td><td><input type="text" name="pro.nandu"></td></tr>
	<tr><td>chubing：</td><td><input type="text" name="pro.chubing"></td></tr>
	<tr><td>isagain：</td><td><input type="text" name="pro.isagain"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
	<tr><td>startlv：</td><td><input type="text" name="pro.startlv"></td></tr>
    <tr><td>startnum：</td><td><input type="text" name="pro.startnum"></td></tr>
	<tr><td>getexp：</td><td><input type="text" name="pro.getexp"></td></tr>
	<tr><td>getyin：</td><td><input type="text" name="pro.getyin"></td></tr>
	<tr><td>getgongxun：</td><td><input type="text" name="pro.getgongxun"></td></tr>
	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>