<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectmlevel!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>level：</td><td><input type="text" name="pro.level"></td></tr>
	<tr><td>exp：</td><td><input type="text" name="pro.exp"></td></tr>
	<tr><td>allexp：</td><td><input type="text" name="pro.allexp"></td></tr>
	<tr><td>xyin：</td><td><input type="text" name="pro.xyin"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
    <tr><td>time：</td><td><input type="text" name="pro.time"
	onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"  
		  readonly="readonly"></td></tr>
	

	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>