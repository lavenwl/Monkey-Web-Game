<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ page import="apiinterface.Home"%>



<%
	//外网
	String openid = request.getParameter("openid");
	//String openkey = request.getParameter("openkey");
	//String pf = request.getParameter("pf");
	//String pfkey = request.getParameter("pfkey");
	//String success = request.getParameter("app_custom");//邀请好友
	
	//内网
	//String pf = (String) session.getAttribute("pf");
	//String openid = (String) session.getAttribute("openid");
	//String openkey = (String) session.getAttribute("openkey");
	//String pfkey = (String) session.getAttribute("pfkey");
	//String success = (String) session.getAttribute("success");
	//String serverId = (String) session.getAttribute("serverId");
	
	//本地
	//String openid = "E4CBD011DF7DFECABC87F2306374960";
	String openkey ="9119ACDD81E909EA63CF683F1C598F8A";
	String pf = "qzone";
	String pfkey = "b337a1174429dc1e0181f9168ec2cd76";
	
	//String openid = "19C85C54FC1A0871752B1615701EB734";
	//String openkey ="FE92C6ADCA6A5E33353D3931071312D4";
	//String pf = "qzone";
	//String pfkey = "711ccb1d067480db2beb4f9cb8872e93";
	String success = null;
	String serverId = "1";
	
	response.sendRedirect("./DeskCheck?openid=" + openid);
	%>
	
	

<html>
	<head>
		<title>临时维护</title>
		<link href="index3.css" rel="stylesheet" type="text/css" />
		<script type="text/JavaScript" src="server1/js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="server1/js/qq.js" charset="utf-8"></script>
		<script type="text/javascript">
		function mul_servers(){
		var openid = "<%=openid%>";
		alert("openid:" + openid);
		var openkey ="<%=openkey%>";
		alert("openkey:" + openkey);
		var pf = "<%=pf%>";
		var pfkey = "<%=pfkey%>";
		var success = "<%=success%>";
		var tmp = document.createElement("form");
		var action="./Server?openid=<%=openid%>&pf=<%=pf%>&openkey=<%=openkey%>&pfkey=<%=pfkey%>&serverId=<%=serverId%>&success=<%=success%>"
		     tmp.action = action;
		     tmp.method = "post";
		     document.body.appendChild(tmp);
		     tmp.submit();
		     return tmp;
		}
		</script>
	</head>
	<body>
		<div id="all_top" style="position: relative;height: 150px;">
			<!-- <div style="position: absolute;">
			<a target="blank_" onclick="token()" > <img
					src="img/huangzuan.png" border="0" style="margin-left: 790px;margin-top: 40px;"/> </a>
			</div> -->
			<div>
			<a href='javascript:void(0)' onclick='dianquan()'> <img
					src="img/dianquan.png" border="0" style="margin-left: 290px;margin-top: 90px;"/> </a>
			<a href='javascript:void(0)' onclick='invite()'><img
					src="img/friend.png" border="0" /> </a>
			<a target="blank_" href='http://bbs.open.qq.com/forum.php?mod=forumdisplay&action=list&fid=537'> <img
					src="img/luntan.png" border="0" /> </a>
			<a target="blank_" onclick="token()" href='http://bbs.open.qq.com/thread-3315330-1-1.html'> <img
					src="img/youxizhensuo.png" border="0" /> </a>		
			<!-- <a target="blank_" onclick="addfavorite()"> <img
					src="img/soucangyouxi.png" border="0" /> </a> -->
					<a href="download.jsp"><img
					src="img/baocunzhuomian.png" border="0" /></a>
			<!--<a target="blank_" onclick="toDesktop('www.baidu.com','baidu')"> <img
					src="img/baocunzhuomian.png" border="0" /> </a>-->
			<a target="blank_" onclick="mul_servers()"> <img
					src="img/mul_server.png" border="0" /> </a>
			<a target="blank_" onclick="token()" > <img
					src="img/huangzuan.png" border="0" /> </a>
			</div>
		</div>
		<div style="position: relative; width: 950px; border: 0px solid #000; margin: 0 auto; overflow: hidden;">
			<div style="height:600px; float:left;  width: 950px;">
			<table id="t" width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">
						
						<div id="linshi"> 
							<div style="height:145px;"></div>
							<div id="tishi">
							<div>&nbsp&nbsp${message}</div>
						</div>
					</td>
				</tr>
			</table>
			</div>
		</div>
		<div id="all_foot"
			style="position: relative; background: url('img/banner3.jpg'); height: 250px">
			<div style="height:250px;"></div>
			<div id="foot">
			<div style="position: relative; text-align:center;"><font size="2px">    OPENID:<%=openid %>    SERVERID:<%=serverId %></font></div>
			<p>&nbsp&nbsp声明：《颠倒西游》应用是"泰州三唐信息技术有限公司"提供，若您的游戏玩不了，请使用【<a href="http://bbs.open.qq.com/thread-3315330-1-1.html" target="_blank">游戏诊所</a>】。</p>
			<p>&nbsp&nbsp如需帮助，请到【<a href="http://bbs.open.qq.com/forum.php?mod=forumdisplay&action=list&fid=537" target="_blank">论坛</a>】提交问题或加qq群：108815819，会有专业的客服人员为您解答问题。</p>
		</div>
		</div>
	</body>
</html>

		