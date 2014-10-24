<%@page pageEncoding="utf-8" 
contentType="text/html;charset=utf-8" %>
<html>
	<head></head>
	<body style="font-size:20px;font-style:italic;">
	<h1>道具添加</h1>
	<form action="project!add.action" method="post">
	id:<input type="text" name="pro.id"><br/>
	道具名称：<input type="text" name="pro.itemname"><br/>
	资源名称：<input type="text" name="pro.itemres"><br/>
	道具说明：<input type="text" name="pro.itemprop"><br/>
	itemtype：<input type="text" name="pro.itemtype"><br/>
	itemurl：<input type="text" name="pro.itemurl"><br/>
	itemlevel：<input type="text" name="pro.itemlevel"><br/>
	isover：<input type="text" name="pro.isover"><br/>
	isuse：<input type="text" name="pro.isuse"><br/>
	isshop：<input type="text" name="pro.isshop"><br/>
	coin：<input type="text" name="pro.coin"><br/>
	cointype：<input type="text" name="pro.cointype"><br/>
	flag：<input type="text" name="pro.flag"><br/>
	reward：<input type="text" name="pro.reward"><br/>
	quality：<input type="text" name="pro.quality"><br/>
	itemvip：<input type="text" name="pro.itemvip"><br/>
	yuanbao：<input type="text" name="pro.yuanbao"><br/>
	<input type="submit" value="添加">
	</form>
	</body>
</html>