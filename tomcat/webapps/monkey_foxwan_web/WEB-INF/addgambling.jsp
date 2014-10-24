<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectbling!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>mId：</td><td><input type="text" name="pro.mId"></td></tr>
	<tr><td>typeId：</td><td><input type="text" name="pro.typeId"></td></tr>
	<tr><td>cost：</td><td><input type="text" name="pro.cost"></td></tr>
	<tr><td>is_rare：</td><td><input type="text" name="pro.is_rare"></td></tr>
	<tr><td>rare_num：</td><td><input type="text" name="pro.rare_num"></td></tr>
	<tr><td>rare_num_now：</td><td><input type="text" name="pro.rare_num_now"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
	<tr><td>is_show：</td><td><input type="text" name="pro.is_show"></td></tr>
	<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>

	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>