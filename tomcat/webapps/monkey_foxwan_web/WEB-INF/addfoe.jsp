<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectfoe!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.foeid"></td></tr>
	<tr><td>foename：</td><td><input type="text" name="pro.foename"></td></tr>
	<tr><td>foedesc：</td><td><input type="text" name="pro.foedesc"></td></tr>
	<tr><td>fangyu：</td><td><input type="text" name="pro.fangyu"></td></tr>
	<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>
	<tr><td>xueliang：</td><td><input type="text" name="pro.xueliang"></td></tr>
	<tr><td>sudu：</td><td><input type="text" name="pro.sudu"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
	<tr><td>time：</td><td><input type="text" name="pro.time"
	onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"  
		  readonly="readonly"></td></tr>
	
	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>