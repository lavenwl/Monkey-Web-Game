<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
	<%@ page import="apiinterface.*"%>
<%
	Home ha=new Home();
	//String openid = request.getParameter("openid");
	//String openkey = request.getParameter("openkey");
	//String pf = request.getParameter("pf");
	//String pfkey = request.getParameter("pfkey");
	//String success = request.getParameter("app_custom");//邀请好友
	
	String openid = "0EEF5BD90DD3A9DD0D38764A802512C7";
	String openkey ="3116F0E84B2F1CCB0092A44133DB2ABF";
	String pf = "qzone";
	String pfkey = "898e4407edfdcda7c8319e417adaf2eb";
	String success = null;
	if(ha.home()==0){
		response.sendRedirect("choose");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>欢迎来到颠倒西游</title>
		<link href="index.css" rel="stylesheet" type="text/css" />
		<script type="text/JavaScript" src="server1/js/jquery-1.4.3.js"></script>
		<script type="text/javascript" charset="utf-8"
			src="http://fusion.qq.com/fusion_loader?appid=100719210&platform=<%=pf%>">
		</script>
		<style>
		.content img {
			float:left;
		}
		
		</style>
<script type="text/javascript">
	function home(){
		$.post("home", {"id":1},function(data){
			//alert(data[0].status);
			if(1<2){
				
			}
		});
		//location.href="linshi.jsp";
	}
	
</script>
	</head>
	<body onselectstart="return false" >
		<div id="all_top" 
		style="background: url('img/top.jpg'); height: 150px">
		<a href='javascript:void(0)' onclick='isYellowVip()'> <img
					src="img/dianquan.png" border="0" style="margin-left: 240px;margin-top: 90px;"/> </a>
			<a href='javascript:void(0)' onclick='invite()'><img
					src="img/friend.png" border="0" /> </a>
			<a href='javascript:void(0)' onclick='cjinfens()'> <img
					src="img/buycoin.png" border="0" /> </a>
			<a target="blank_" href='http://bbs.open.qq.com/forum.php?mod=forumdisplay&action=list&fid=537'> <img
					src="img/luntan.png" border="0" /> </a>
			<a target="blank_" onclick="token()" href='javascript:void(0)'> <img
					src="img/huangzuan.png" border="0" style="margin-right: -2px;margin-bottom: 60px;"/> </a>
		</div>
		<div class="wrapper">
			<div class="content" style="height:600px">
				<img src="img/01.jpg"/>
				<img src="img/02.jpg"/>
				<img src="img/03.jpg"/>
				<img src="img/04.jpg"/>
				<form id="myfrom" name="loading"
					action="./Loading?openid=<%=openid%>&pf=<%=pf%>&openkey=<%=openkey%>&pfkey=<%=pfkey%>&success=<%=success%>"
					method="post">
					<input type="submit" class="denglu"
						onMouseOver="this.className='denglu2'"
						onMouseOut="this.className='denglu'" />
				</form>
			</div>
		</div>
		<div id="all_foot"
			style="background: url('img/banner.jpg'); height: 250px">
			
			<div style="height:250px;"></div>
			<div id="foot">
			<div style="text-align:center;"><font size="2px" color="red">ID:<%=openid %></font></div>
			<p>&nbsp&nbsp声明：《颠倒西游》应用是"泰州三唐信息技术有限公司"提供，若您的游戏玩不了，请使用【游戏诊所】。</p>
			<p>&nbsp&nbsp如需帮助，请联系我们【<a href="#" target="_blank">客服平台</a>】或者到【<a href="http://bbs.open.qq.com/forum.php?mod=forumdisplay&action=list&fid=537" target="_blank">论坛</a>】提交问题或联系客服电话：---，会有专业的客服人员为您解答问题。</p>
			</div>
		</div>
	</body>
</html>
