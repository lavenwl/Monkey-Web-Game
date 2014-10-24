<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectmilitary!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>name：</td><td><input type="text" name="pro.name"></td></tr>
	<tr><td>pingzhi：</td><td><input type="text" name="pro.pingzhi"></td></tr>
	<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>
	<tr><td>pztype：</td><td><input type="text" name="pro.pztype"></td></tr>
	<tr><td>gongji：</td><td><input type="text" name="pro.gongji"></td></tr>
	<tr><td>gjiacheng：</td><td><input type="text" name="pro.gjiacheng"></td></tr>
	<tr><td>gongsu：</td><td><input type="text" name="pro.gongsu"></td></tr>
	<tr><td>time：</td><td><input type="text" name="pro.time"
	onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"  
		  readonly="readonly"></td></tr>
	
	<tr><td>fanwei：</td><td><input type="text" name="pro.fanwei"></td></tr>
	<tr><td>xueliang：</td><td><input type="text" name="pro.xueliang"></td></tr>
	<tr><td>xljiacheng：</td><td><input type="text" name="pro.xljiacheng"></td></tr>
	<tr><td>level：</td><td><input type="text" name="pro.level"></td></tr>
	<tr><td>art：</td><td><input type="text" name="pro.art"></td></tr>
	<tr><td>arts：</td><td><input type="text" name="pro.arts"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
	<tr><td>isshow：</td><td><input type="text" name="pro.isshow"></td></tr>
	<tr><td>iscompose：</td><td><input type="text" name="pro.iscompose"></td></tr>
	<tr><td>isaddcompose：</td><td><input type="text" name="pro.isaddcompose"></td></tr>
	<tr><td>needcompose：</td><td><input type="text" name="pro.needcompose"></td></tr>
	<tr><td>composeid：</td><td><input type="text" name="pro.composeid"></td></tr>
	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>