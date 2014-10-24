<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String roleId = (String) session.getAttribute("roleId");
	String pf = (String) session.getAttribute("pf");
	String openid = (String) session.getAttribute("openid");
	String openkey = (String) session.getAttribute("openkey");
	String pfkey = (String) session.getAttribute("pfkey");
	String success = (String) session.getAttribute("success");
	//String pid = (String) session.getAttribute("pid");
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>塔防西游记</title>
		<link href="index.css" rel="stylesheet" type="text/css" />
		<script type="text/JavaScript" src="server1/js/jquery-1.4.3.js"></script>
		<script type="text/JavaScript" src="server1/js/injs.js"></script>
		<script type="text/javascript" charset="utf-8"
			src="http://fusion.qq.com/fusion_loader?appid=100719210&platform=<%=pf%>">
		</script>
	</head>
	<body>
		<div id="all_top">
			<a href='javascript:void(0)' onclick='isYellowVip()'> <img
					src="img/dianquan.png" border="0" style="margin-left: 240px;margin-top: 90px;"/> </a>
			<a href='javascript:void(0)' onclick='invite()'><img
					src="img/friend.png" border="0" /> </a>
			<a href='javascript:void(0)' onclick='cjinfens()'> <img
					src="img/buycoin.png" border="0" /> </a>
			<a target="blank" onclick="token()"> <img
					src="img/huangzuan.png" border="0" /> </a>
		</div>
		<div
			style="position: relative; width: 760px; border: 0px solid #000; margin: 0 auto;">
			<table id="t" width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">
						<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
							codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0"
							width="760" height="600" id="FlashID" align="middle"
							onBlur="this.focus()">
							<param name="movie" id="myout" value="out.swf" />
							<param name="quality" value="high" />
							<param name="wmode" value="transparent" />
							<param name="swfversion" value="11.0" />
							<param name="expressinstall"
								value="<%=basePath%>server1/Scripts/expressInstall.swf" />
							<param name="allowNetworking" value="all" />
							<param name="AllowScriptAccess" value="always" />
							<param name="allowFullScreen" value="true" />
							<embed src="out.swf" name="FlashID" id="FlashID2" quality="high"
								allowScriptAccess="always" swLiveConnect="true"
								pluginspage="http://www.macromedia.com/go/getflashplayer"
								type="application/x-shockwave-flash" width="760" height="600">
							</embed>
						</object>
					</td>
				</tr>
			</table>
		</div>
		<div id="all_foot"
			style="background: url('img/banner.jpg'); height: 250px">
		</div>
	</body>

	<script language="Javascript"> 
	var jsReady = false;
	pageInit();
	function getIsNew(){
		return "<%=String.valueOf(session.getAttribute("isNew"))%>";
	}
	function getPid(){
	alert("<%=roleId%>");
		return "<%=roleId%>";
	}
	function getSIp(){
		return "localhost";
	}
	function getSPort(){
		return "8008";
	}
	function isReady(){
		return jsReady;
	}
	function pageInit(){
		jsReady = true;
	}
	

function getFlash(id) {
	  if(navigator.appName.indexOf("Microsoft") != -1) {
	  	  return document.getElementById("FlashID");
	  }else{
	  	  return document.getElementById("FlashID2");
	  }
};

	function YellowVip() {
	$.post("QQOpenApi", {"openid":d1,"openkey":d2,"pf":d3,"id":d5,"success":success}, function (data, status) {
	
	}, "json");
	}
	function isYellowVip() {

	$.post("QQOpenApi", {"openid":d1,"openkey":d2,"pf":d3,"id":d5}, function (data, status) {
		//thisMovie("FlashID").getYellowVips(data[0].name);
		getFlash("FlashID").getYellowVips(data[0].name);
	}, "json");
	}

	function getFriends() {
	$.post("Friends", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"id":d5}, function (data, status) {
		
	}, "json");
	}
	
	function login(e) {
	$.post("login", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"level":e}, function (data, status) {
		
	}, "json");
	}
	
	function register() {
	$.post("register", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5}, function (data, status) {
		
	}, "json");
	}
	
	function access() {
	$.post("access", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5}, function (data, status) {
		
	}, "json");
	}
	
	function consume(e) {
	$.post("consume", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"modifyfee":e}, function (data, status) {
		
	}, "json");
	}
	
	function quit(e,d) {
	$.post("quit", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"onlinetime":e,"level":d}, function (data, status) {
		
	}, "json");
	}
	
	function report(e,d) {
	$.post("report", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"actionid":e,"level":d}, function (data, status) {
		
	}, "json");
	}
	
	function goods1(payitem,goodsmeta,goodsurl) {
	alert(1);
	alert(payitem);
	alert(goodsmeta);
	
	goodsurl = "http://app100719210.imgcache.qzoneapp.com/app100719210/pic/001.png";
	alert(goodsurl);
	$.post("goods", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl}, function (data) {
		alert("11");
		alert(data[0].name);
		buy1(data[0].name,payitem);
	}, "json");
	}
	
	function goods2(payitem,goodsmeta,goodsurl) {
	alert(2);
	$.post("goods", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl}, function (data) {
		buy2(data,payitem);
	}, "json");
	}
	
	function goods3(payitem,goodsmeta,goodsurl) {
	alert(3);
	$.post3("goods", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl}, function (data) {
		buy3(data,payitem);
	}, "json");
	}
	
	function buy1(url_param,payitem){
		fusion2.dialog.buy({
			disturb : true,//上线后去掉
			param : url_param,
			sandbox : true,
			context : "3tang",
			onSuccess : function (opt) { getFlash("FlashID").getBuyItem1(payitem);},
			onSend : function(opt) { alert("发货超时");}
		});
	}
	
	function buy2(url_param,payitem){
		fusion2.dialog.buy({
			disturb : true,//上线后去掉
			param : url_param,
			sandbox : true,
			context : "3tang",
			onSuccess : function (opt) { getFlash("FlashID").getBuyItem2(payitem);},
			onSend : function(opt) { alert("发货超时");}
		});
	}
	
	function buy3(url_param,payitem){
		fusion2.dialog.buy({
			disturb : true,
			param : url_param,
			sandbox : true,
			context : "3tang",
			onSuccess : function (opt) { getFlash("FlashID").getBuyItem3(payitem);},
			onSend : function(opt) { alert("发货超时");}
		});
	}
	
	function delivery() {
	$.post("delivery", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4}, function (data) {
		
	}, "json");
	}
	
	function token() {
	alert("token");
	$.post("token", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4}, function (data) {
	alert(data);
		openVipGift(data[0].name);
	}, "json");
	}
	function openVipGift(e){
	alert("openVipGift");
		fusion2.dialog.openVipGift({
			token:e,
			actid:"UM130704104643962",
			zoneid:"0",
			openid:d1,
			onSuccess : function (opt) {  getFlash("FlashID").getToken("92*650*10");}
		});
	}
 </script>
<script type="text/javascript">
	
function invite(){
alert("FlashID");
getFlash("FlashID").getBuyItem1("1*8*1");
fusion2.dialog.invite({
		msg  : "快来玩啊",
  		source : "<%=roleId%>",
  		context : "invite",
  		onSuccess : function (ret) {  
  			alert("Successded: " + opt.invitees.length); 
  			for(var i=0;i<opt.invitees.length;i++){inv();}
  		}
	});
}
function size(){
	for(var i=0;i<=2;i++){inv();}
}

function inv() {
	$.post("inv", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5}, function (data, status) {
		
	}, "json");
	}
	
function dianquan(){
	fusion2.dialog.recharge 
({ 
onClose : function () {} 
}); 
}
</script>
	<script type="text/javascript"> 
	var d1="<%=openid%>";
	var d2="<%=openkey%>";
	var d3="<%=pf%>";
	var d4="<%=pfkey%>";
	var d5="<%=roleId%>";
	var success="<%=success%>";	
	
	function cjinfens(){
	$.post('IsRoleServlet',{"id":d5},function(data,status){
		if(data[0].roleId ==0){
			alert("请先创建人物");
		}else{
			$.post('GetMoney',{"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5},function(data,status){
				pay(data[0].id);
			},'json');
		}
	},'json');
}
	
	function pay(id){
fusion2.dialog.pay ({ 
  		zoneid : "0",
  		sandbox : true, 
  		onClose : function () {
  		jieguo(id);
  		}
	}); 
}
	
	function jieguo(i){
	$.post('GetMoney',{"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5},function(data,status){
			if(data[0].id>i){
				//chongzhi(data[0].id-i);
				recharge(chongzhi(data[0].id-i));
				getFlash("FlashID").chongzhi();
			}
		},'json');
}

function chongzhi(d){
	$.post("Chongzhi", {"id":d5,"money":d,"openid":d1}, function (data, status) {
	thisMovie("FlashID").setChongzhi(data[0].roleId,data[0].data[0].money);
	}, "json");
	}
	
	function recharge(e) {
	$.post("recharge", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"modifyfee":e}, function (data, status) {
		
	}, "json");
	}
	
	function getMoney(){
	$.post('GetMoney',{"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5},function(data){
			
		},'json');
	}
 </script>
<script type="text/javascript">
	//分享
	function share1(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！新手闯关成功！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我成功通过了西游试炼之路，赶紧加入我的队伍，一起抓唐僧吧！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	function share2(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！闯关成功啦！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我已闯过战争的种种考验，快来与我一起颠倒西游闯荡吧！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	function share3(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！闯关成功啦！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我进入了新的关卡，前进的路途需要有你！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	function share4(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！魔将合成成功啦！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我成功合成了绿色魔将，想要和我一样厉害么！来西游探险吧！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	function share5(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！魔将合成成功啦！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我成功合成了蓝色魔将，想要和我一样厉害么！来西游探险吧！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	function share6(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！魔将合成成功啦！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我成功合成了红色魔将，想要和我一样厉害么！来西游探险吧！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	function share7(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！终于升级啦！!",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我升级了哈哈哈，快与我一起抓唐僧，戏悟空吧！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	function share8(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！装备合成成功啦！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我成功合成了绿色装备，想要和我一样厉害么！来西游探险吧！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	function share9(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！装备合成成功啦！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我成功合成了蓝色装备，想要和我一样厉害么！来西游探险吧！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	function share10(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！魔将转职成功啦！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"魔将成功晋级了，抓唐僧我的把握更大了，要来参加么！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data,status){},'json');
				thisMovie("FlashID").getShare();
			}
		});
	}
	
	
</script>
</html>