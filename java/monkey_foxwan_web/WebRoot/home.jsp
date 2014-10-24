<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ page import="com.stang.game.entity.detail.HostStatusDetail"%>
<%@ page import="com.stang.game.entity.detail.ServerDetail"%>
<%@ page import="java.util.List"%>
<%@ page import="com.stang.game.service.IHostStatusService"%>
<%@ page import="com.stang.game.service.impl.HostStatusServiceImpl"%>



<% 
		String message = null;
		List<HostStatusDetail> hoststatus=new HostStatusServiceImpl().getHostStatus();
		for(int j = 0; j < 5; j++){
			if(!hoststatus.equals(null)){
				break;
			}
		}
		int size=hoststatus.size();
		
		for(int i=0;i<size;i++){
			int id0=hoststatus.get(i).getId();
			if(id0==1){
				message=hoststatus.get(i).getMessage();
			}
		}  %>


	<html>
	<head>
		<title>临时维护</title>
		<link href="index3.css" rel="stylesheet" type="text/css" />
		<script type="text/JavaScript" src="server1/js/jquery-1.4.3.js"></script>
		<script type="text/javascript" src="server1/js/qq.js" charset="utf-8"></script>
		<script type="text/javascript">
		</script>
	</head>
	<body>
		<div id="all_top" style="position: relative;height: 150px;">
			<!-- <div style="position: absolute;">
			<a target="blank_" onclick="token()" > <img
					src="img/huangzuan.png" border="0" style="margin-left: 790px;margin-top: 40px;"/> </a>
			</div> -->
			<div>
			<a target="blank_" href='http://ddxy.foxwan.com/'> <img
					src="img/luntan.png" border="0" style="margin-left: 290px;margin-top: 90px;"/> </a>
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
							<div>&nbsp&nbsp<%out.print(message);%></div>
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
			<!-- <p>&nbsp&nbsp声明：《颠倒西游》应用是"泰州三唐信息技术有限公司"提供，若您的游戏玩不了，请使用【<a href="http://bbs.open.qq.com/thread-3315330-1-1.html" target="_blank">游戏诊所</a>】。</p> -->
			<p>&nbsp&nbsp如需帮助，请到【<a href="http://ddxy.foxwan.com/" target="_blank">论坛</a>】提交问题或加qq群：171674530，会有专业的客服人员为您解答问题。</p>
		</div>
		</div>
	</body>
</html>