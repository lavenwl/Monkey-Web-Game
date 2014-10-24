<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projecttask!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>oldid：</td><td><input type="text" name="pro.oldid"></td></tr>
	<tr><td>taskname：</td><td><input type="text" name="pro.taskname"></td></tr>
	<tr><td>taskdesc：</td><td><input type="text" name="pro.taskdesc"></td></tr>
	<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>
	<tr><td>tasktype：</td><td><input type="text" name="pro.tasktype"></td></tr>
	<tr><td>tasklevel：</td><td><input type="text" name="pro.tasklevel"></td></tr>
	<tr><td>tasksx：</td><td><input type="text" name="pro.tasksx"></td></tr>
	<tr><td>tasknum：</td><td><input type="text" name="pro.tasknum"></td></tr>
	<tr><td>time：</td><td><input type="text" name="pro.time"
	onclick="SelectDate(this,'yyyy-MM-dd hh:mm:ss')"  
		  readonly="readonly"></td></tr>
	
	<tr><td>exp：</td><td><input type="text" name="pro.exp"></td></tr>
	<tr><td>taskcoin：</td><td><input type="text" name="pro.taskcoin"></td></tr>
	<tr><td>cointype：</td><td><input type="text" name="pro.cointype"></td></tr>
	<tr><td>taskres：</td><td><input type="text" name="pro.taskres"></td></tr>
	<tr><td>taskres2：</td><td><input type="text" name="pro.taskres2"></td></tr>
	<tr><td>taskgoal：</td><td><input type="text" name="pro.taskgoal"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
	<tr><td>gongxun：</td><td><input type="text" name="pro.gongxun"></td></tr>
	<tr><td>junling：</td><td><input type="text" name="pro.junling"></td></tr>
	
	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>