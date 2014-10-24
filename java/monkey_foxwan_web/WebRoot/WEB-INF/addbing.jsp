<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectbing!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>name：</td><td><input type="text" name="pro.name"></td></tr>
	<tr><td>icon：</td><td><input type="text" name="pro.icon"></td></tr>
	<tr><td>artdesc：</td><td><input type="text" name="pro.artdesc"></td></tr>
	<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>
	<tr><td>isenemy：</td><td><input type="text" name="pro.isenemy"></td></tr>
	<tr><td>gongji：</td><td><input type="text" name="pro.gongji"></td></tr>
	<tr><td>xishu1：</td><td><input type="text" name="pro.xishu1"></td></tr>
	<tr><td>xueliang：</td><td><input type="text" name="pro.xueliang"></td></tr>

	<tr><td>xishu2：</td><td><input type="text" name="pro.xishu2"></td></tr>
	<tr><td>fangyu：</td><td><input type="text" name="pro.fangyu"></td></tr>
	<tr><td>gongsu：</td><td><input type="text" name="pro.gongsu"></td></tr>
	<tr><td>gongfan：</td><td><input type="text" name="pro.gongfan"></td></tr>
	<tr><td>shangfan：</td><td><input type="text" name="pro.shangfan"></td></tr>
	<tr><td>sudu：</td><td><input type="text" name="pro.sudu"></td></tr>
	<tr><td>renkou：</td><td><input type="text" name="pro.renkou"></td></tr>
	<tr><td>jiage：</td><td><input type="text" name="pro.jiage"></td></tr>
	<tr><td>lengque：</td><td><input type="text" name="pro.lengque"></td></tr>
	
	<tr><td>bullet：</td><td><input type="text" name="pro.bullet"></td></tr>
	<tr><td>bulletfly：</td><td><input type="text" name="pro.bulletfly"></td></tr>
	<tr><td>bullethit：</td><td><input type="text" name="pro.bullethit"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
	<tr><td>skill：</td><td><input type="text" name="pro.skill"></td></tr>
	<tr><td>gongjun：</td><td><input type="text" name="pro.gongjun"></td></tr>
	<tr><td>bingfu：</td><td><input type="text" name="pro.bingfu"></td></tr>
	<tr><td>xtype：</td><td><input type="text" name="pro.xtype"></td></tr>
	
	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>