<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectequip!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>equipname：</td><td><input type="text" name="pro.equipname"></td></tr>
	<tr><td>equipurl：</td><td><input type="text" name="pro.equipurl"></td></tr>
	<tr><td>equiptype：</td><td><input type="text" name="pro.equiptype"></td></tr>
	<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>
	<tr><td>gongji：</td><td><input type="text" name="pro.gongji"></td></tr>
	<tr><td>fanwei：</td><td><input type="text" name="pro.fanwei"></td></tr>
	<tr><td>sudu：</td><td><input type="text" name="pro.sudu"></td></tr>
	<tr><td>xueliang：</td><td><input type="text" name="pro.xueliang"></td></tr>

	<tr><td>extra：</td><td><input type="text" name="pro.extra"></td></tr>
	<tr><td>level：</td><td><input type="text" name="pro.level"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
	<tr><td>coin：</td><td><input type="text" name="pro.coin"></td></tr>
	<tr><td>cointype：</td><td><input type="text" name="pro.cointype"></td></tr>
	<tr><td>desc：</td><td><input type="text" name="pro.desc"></td></tr>
	<tr><td>isshop：</td><td><input type="text" name="pro.isshop"></td></tr>
	<tr><td>quality：</td><td><input type="text" name="pro.quality"></td></tr>
	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>