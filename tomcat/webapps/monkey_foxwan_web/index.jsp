<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script type="text/javascript">
			function check(){
				if(document.getElementById("memberUsername").value==""){
					alert("用户名为空或格式错误");
					return false;
				}
				if(document.getElementById("memberPassword").value==""){
					alert("密码不能为空");
					return false;
				}
				if(document.getElementById("memberPassword").value!=""
					&&document.getElementById("memberUsername").value!=""){
					 return true;
				}
			  
			}
		</script>
		<title>欢迎来到颠倒西游</title>
		<link href="index2.css" rel="stylesheet" type="text/css" />
	</head>
	<body onselectstart="return false">
		<div class="wrapper">
			<div class="content">
				<form name="loading" action="./Loadingtohomejsp" method="post">
					<input id="memberUsername" type="text" name="memberUsername"
						" />
					<p></p>
					<input id="memberPassword" type="password" name="memberPassword"
						 />
					<input id="tijiao" type="submit" onclick="return check()"
						class="denglu" onMouseOver="this.className='denglu2'"
						onMouseOut="this.className='denglu'" />
				</form>
			</div>
			<div class="warmtips">
				<p style="">
					声明：《颠倒西游》应用是"上海三唐信息科技有限公司"提供，若您的游戏玩不了，请使用
					<a id="link_doctor onclick="showguanjia()">【游戏诊所】</a>
					<br />
					如需帮助，请联系我们
					<a onclick="showguanjia()">【客服平台】</a>或者到
					<a onclick="showguanjia()">【论坛】</a>提交问题或联系客服电话：---，会有专业的客服人员为您解答问题。
				</p>
			</div>
		</div>
	</body>
</html>
