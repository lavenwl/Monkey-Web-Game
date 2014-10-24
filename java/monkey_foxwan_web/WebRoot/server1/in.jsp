<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String roleId = (String) session.getAttribute("roleId");
	String p = (String) session.getAttribute("p");
	String openid = (String) session.getAttribute("openid");
	String time = (String) session.getAttribute("time");
	String isadult = (String) session.getAttribute("isadult");
	String flag = (String) session.getAttribute("flag");
	String serverId = (String) session.getAttribute("serverId");
	String serverIp = (String) session.getAttribute("serverIp");
	//String serverId = "1";
	boolean isNew = Boolean.valueOf(String.valueOf(session.getAttribute("isNew")));
	//String pid = (String) session.getAttribute("pid");
	int requestGiftBack = 0;
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>颠倒西游</title>
		<link href="index3.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
		var d1="<%=openid%>";
		var d5="<%=roleId%>";
		var d6="<%=serverId%>";
		var d7="<%=serverIp%>";
		var d8="<%=p%>";
		var isNew="<%=isNew%>";
		var requestGiftBack="<%=requestGiftBack%>";
		</script>
		<script type="text/javascript">
		function mul_servers(){
		var openid = "<%=openid%>";
		var tmp = document.createElement("form");
		var action="./Server?openid=<%=openid%>&serverId=<%=serverId%>"
		     tmp.action = action;
		     tmp.method = "post";
		     document.body.appendChild(tmp);
		     tmp.submit();
		     return tmp;
		}
		</script>
		
		<script type="text/JavaScript" src="server1/js/jquery-1.4.3.js"></script>
		<!-- <script type="text/JavaScript" src="server1/js/injs.js"></script> -->
		<script type="text/javascript" src="server1/js/qq.js" charset="utf-8"></script>
	</head>
	<body style="background-image:url(http://cdn.ddxy.foxwan.com/fwRes//notice/beijing.jpg); background-repeat:no-repeat; background-color: black;background-position: center; background-position:top;" >
		<div id="all_top" style="position: relative;height: 150px;">
			<!-- <div style="position: absolute;">
			<a target="blank_" onclick="token()" > <img
					src="img/huangzuan.png" border="0" style="margin-left: 790px;margin-top: 40px;"/> </a>
			</div> -->
			<div>
			<a target="blank_" href='http://apiport.foxwan.com/redirect/pay?game=ddxy&sid=<%=serverId%>&uname=<%=openid%>'> <img
					src="img/buycoin.png" border="0" style="margin-left: 290px;margin-top: 90px;"/> </a>
			<!-- <a href='javascript:void(0)' onclick='invite()'><img
					src="img/friend.png" border="0" /> </a> -->
			<a target="blank_" href='http://ddxy.foxwan.com/'> <img
					src="img/luntan.png" border="0" /> </a>
			<!--<a target="blank_" onclick="token()" href='http://bbs.open.qq.com/thread-3315330-1-1.html'> <img
					src="img/youxizhensuo.png" border="0" /> </a>	-->	
			<!--<a target="blank_" onclick="getGroupFriends()"> <img
					src="img/soucangyouxi.png" border="0" /> </a> -->
			<!--<a href="download.jsp"><img
					src="img/baocunzhuomian.png" border="0" /></a>-->
			<!--<a target="blank_" onclick="toDesktop('www.baidu.com','baidu')"> <img
					src="img/baocunzhuomian.png" border="0" /> </a>-->
			<!--<a target="blank_" onclick="mul_servers()"> <img
					src="img/huangzuan.png" border="0" /> </a> -->
			</div>
		</div>
		<div style="position: relative; width: 950px; border: 0px solid #000; margin: 0 auto; overflow: hidden;">
			<div style="height:600px; float:left;  width: 950px;">
			<table id="t" width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
							codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
							width="950" height="600" id="FlashID" align="middle">
							<%if(!serverId.equals("666")){%>
							<param name="movie" id="myout" value="out.swf?<%=Math.random()%>" />
							<%}else{%>
								<param name="movie" id="myout" value="out_beta.swf?<%=Math.random()%>" />
							<%}%>
							<param name="quality" value="high" />
							<param name="wmode" value="transparent" />
							<param name="swfversion" value="11.0" />
							<param name="expressinstall" value="<%=basePath%>server1/Scripts/expressInstall.swf" />
							<param name="allowNetworking" value="all" />
							<param name="AllowScriptAccess" value="always" />
							<param name="allowFullScreen" value="true" />
							<%if(!serverId.equals("666")){%>
							<embed src="out.swf?<%=Math.random()%>" name="FlashID" id="FlashID2" quality="high"
								allowScriptAccess="always" swLiveConnect="true"
								pluginspage="http://www.macromedia.com/go/getflashplayer"
								type="application/x-shockwave-flash" width="950" height="600">
							</embed>
							<%}else{%>
							<embed src="out_beta.swf?<%=Math.random()%>" name="FlashID" id="FlashID2" quality="high"
								allowScriptAccess="always" swLiveConnect="true"
								pluginspage="http://www.macromedia.com/go/getflashplayer"
								type="application/x-shockwave-flash" width="950" height="600">
							</embed>
							<%}%>
							
						</object>
					</td>
				</tr>
			</table>
			</div>
		</div>
		<div id="all_foot"
			style="position: relative; background: url('img/banner3.jpg'); height: 250px">
			<div style="height:250px;"></div>
			<div id="foot">
			<div style="position: relative; text-align:center;"><font size="2px">人物ID:<%=roleId %>    OPENID:<%=openid %>     所在服务器：<%=serverId %>区</font></div>
			<!-- <p>&nbsp&nbsp声明：《颠倒西游》应用是"泰州三唐信息技术有限公司"提供。</p>  -->
			<p>&nbsp&nbsp如需帮助，请到【<a href="http://ddxy.foxwan.com/" target="_blank">论坛</a>】提交问题或加qq群：171674530，会有专业的客服人员为您解答问题。</p>
		</div>
		</div>
	</body>
</html>