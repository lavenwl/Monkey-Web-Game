<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<SCRIPT LANGUAGE="JavaScript" SRC="../common/js/Calendar4.js"></SCRIPT>
		<script LANGUAGE="JavaScript" SRC="common/js/WebCalendar.js"></SCRIPT>
	</head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="projectskill!add.action" method="post">
			<table>
	<tr><td>id：</td><td><input type="text" name="pro.id"></td></tr>
	<tr><td>skillName：</td><td><input type="text" name="pro.skillName"></td></tr>
	<tr><td>skillDesc：</td><td><input type="text" name="pro.skillDesc"></td></tr>
	<tr><td>skillIcon：</td><td><input type="text" name="pro.skillIcon"></td></tr>
	<tr><td>skillMc：</td><td><input type="text" name="pro.skillMc"></td></tr>
	<tr><td>skillMcclip：</td><td><input type="text" name="pro.skillMcclip"></td></tr>
	<tr><td>type：</td><td><input type="text" name="pro.type"></td></tr>
	<tr><td>skillType：</td><td><input type="text" name="pro.skillType"></td></tr>
	<tr><td>mpcost：</td><td><input type="text" name="pro.mpcost"></td></tr>

	<tr><td>skillCd：</td><td><input type="text" name="pro.skillCd"></td></tr>
	<tr><td>skillArea：</td><td><input type="text" name="pro.skillArea"></td></tr>
	<tr><td>skillBuffId：</td><td><input type="text" name="pro.skillBuffId"></td></tr>
	<tr><td>flag：</td><td><input type="text" name="pro.flag"></td></tr>
	<tr><td>nameurl：</td><td><input type="text" name="pro.nameurl"></td></tr>
	</table>
	<input type="submit" value="添加">
	</form>
	</body>
</html>