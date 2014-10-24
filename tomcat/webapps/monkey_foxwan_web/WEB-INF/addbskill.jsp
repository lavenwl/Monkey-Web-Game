<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectbskill!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>name：</td><td><input type="text" name="pro.name"></td></tr>
	<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>
	<tr><td>artdesc：</td><td><input type="text" name="pro.artdesc"></td></tr>
	<tr><td>buffid：</td><td><input type="text" name="pro.buffid"></td></tr>
	<tr><td>target：</td><td><input type="text" name="pro.target"></td></tr>

	<tr><td>jilv：</td><td><input type="text" name="pro.jilv"></td></tr>
	<tr><td>chufa：</td><td><input type="text" name="pro.chufa"></td></tr>
	<tr><td>fanwei：</td><td><input type="text" name="pro.fanwei"></td></tr>
	<tr><td>shanghai：</td><td><input type="text" name="pro.shanghai"></td></tr>
	<tr><td>cishu：</td><td><input type="text" name="pro.cishu"></td></tr>
	<tr><td>time：</td><td><input type="text" name="pro.time"></td></tr>
	<tr><td>bullet：</td><td><input type="text" name="pro.bullet"></td></tr>
	<tr><td>cd：</td><td><input type="text" name="pro.cd"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
	
	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>