<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectmission!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>name：</td><td><input type="text" name="pro.name"></td></tr>
	<tr><td>artdesc：</td><td><input type="text" name="pro.artdesc"></td></tr>
	<tr><td>goal：</td><td><input type="text" name="pro.goal"></td></tr>
	<tr><td>jiangli：</td><td><input type="text" name="pro.jiangli"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>

	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>