<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectbuff!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>name：</td><td><input type="text" name="pro.name"></td></tr>
	<tr><td>buffdip：</td><td><input type="text" name="pro.buffDip"></td></tr>
	<tr><td>buffatktime：</td><td><input type="text" name="pro.buffAtktime"></td></tr>
	<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>
	<tr><td>buffkeeptime：</td><td><input type="text" name="pro.buffKeeptime"></td></tr>
	<tr><td>atkperson：</td><td><input type="text" name="pro.atkperson"></td></tr>
	<tr><td>bufftype：</td><td><input type="text" name="pro.bufftype"></td></tr>
	<tr><td>bufftime：</td><td><input type="text" name="pro.bufftime"></td></tr>
	<tr><td>ctime：</td><td><input type="text" name="pro.ctime"
	onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"  
		  readonly="readonly"></td></tr>
	
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>

	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>