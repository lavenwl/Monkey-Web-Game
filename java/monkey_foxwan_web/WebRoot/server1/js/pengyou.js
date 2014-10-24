var jsReady = false;
	pageInit();
	function getIsNew(){
		return isNew;
	}
	function getPid(){
		return d5;
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
}
	function YellowVip() {
	alert("YellowVip");
	$.post("QQOpenApi", {"openid":d1,"openkey":d2,"pf":d3,"id":d5,"success":success}, function (data, status) {
	
	}, "json");
	}
	function isYellowVip() {
	alert("isYellowVip");
	$.post("QQOpenApi", {"openid":d1,"openkey":d2,"pf":d3,"id":d5,"success":success}, function (data, status) {
		getFlash("FlashID").getYellowVip(data[0].name);
	}, "json");
	}
	function getFriends() {
	alert("getFriends");
	$.post("Friends", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"id":d5}, function (data, status) {
		
	}, "json");
	}
	
	function login(e) {
	alert("login");
	$.post("login", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"level":e}, function (data, status) {
		
	}, "json");
	}
	
	function register() {
	alert("register");
	$.post("register", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5}, function (data, status) {
		
	}, "json");
	}
	
	function access() {
	alert("access");
	$.post("access", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5}, function (data, status) {
		
	}, "json");
	}
	
	
	function consume(e) {
	alert("consume");
	$.post("consume", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"modifyfee":e}, function (data, status) {
		
	}, "json");
	}
	
	function quit(e,d) {
	alert("quit");
	$.post("quit", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"onlinetime":e,"level":d}, function (data, status) {
		
	}, "json");
	}
	
	function report(e,d) {
	alert("report");
	$.post("report", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"actionid":e,"level":d}, function (data, status) {
		
	}, "json");
	}
	
	function goods1(payitem,goodsmeta,goodsurl) {
	alert("goods1");
	$.post("goods", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl}, function (data) {
		buy1(data[0].name,payitem);
	}, "json");
	}
	
	function goods2(payitem,goodsmeta,goodsurl) {
	alert("goods2");
	$.post("goods", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl}, function (data) {
		buy2(data[0].name,payitem);
	}, "json");
	}
	
	function goods3(payitem,goodsmeta,goodsurl) {
	alert("goods3");
	$.post("goods", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl}, function (data) {
		buy3(data[0].name,payitem);
	}, "json");
	}
	
	function buy1(url_param,payitem){
	alert("buy1");
		fusion2.dialog.buy({
			disturb : true,
			param : url_param,
			sandbox : false,//上线后去掉
			context : "3tang",
			onSuccess : function (opt) {  getFlash("FlashID").getBuyItem1(payitem);},
			onSend : function(opt) { alert("发货超时");}
		});
	}
	function buy2(url_param,payitem){
	alert("buy2");
		fusion2.dialog.buy({
			disturb : true,
			param : url_param,
			sandbox : false,//上线后去掉
			context : "3tang",
			onSuccess : function (opt) {  getFlash("FlashID").getBuyItem2(payitem);},
			onSend : function(opt) { alert("发货超时");}
		});
	}
	
	function buy3(url_param,payitem){
	alert("buy2");
		fusion2.dialog.buy({
			disturb : true,
			param : url_param,
			sandbox : false,//上线后去掉
			context : "3tang",
			onSuccess : function (opt) {  getFlash("FlashID").getBuyItem3(payitem);},
			onSend : function(opt) { alert("发货超时");}
		});
	}
	
	function delivery() {
	alert("delivery");
	$.post("delivery", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4}, function (data) {
		
	}, "json");
	}
	
	function token() {
	alert("token");
	$.post("token", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4}, function (data) {
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
	
	
function invite(){
alert("invite");
fusion2.dialog.invite({
		msg  : "快来玩啊",
  		source : d5,
  		context : "invite",
  		onSuccess : function (opt) {  
  			var len = opt.invitees.length;
  			for(var i=0;i<len;i++){
  				inv();
  			} 
  		}
	});
}

function inv() {
alert("inv");
	$.post("inv", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5}, function (data, status) {
		
	}, "json");
	}
	
function dianquan(){
	fusion2.dialog.recharge 
({ 
onClose : function () {} 
}); 
}


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
  		sandbox : false, 
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
alert("chongzhi");
	$.post("Chongzhi", {"id":d5,"money":d,"openid":d1}, function (data, status) {
	thisMovie("FlashID").setChongzhi(data[0].roleId,data[0].data[0].money);
	}, "json");
	}
	
	function recharge(e) {
	$.post("recharge", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5,"modifyfee":e}, function (data) {
		
	}, "json");
	}
	
	function getMoney(){
	$.post('GetMoney',{"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"uid":d5},function(data){
		
		},'json');
	}
	
	
	
//分享
	function share1(i){
	alert("share1");
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！新手闯关成功！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我成功通过了西游试炼之路，赶紧加入我的队伍，一起抓唐僧吧！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i},function(data){},'json');
				alert("share1");
				getFlash("FlashID").getShare();
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
				getFlash("FlashID").getShare();
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
				getFlash("FlashID").getShare();
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
				getFlash("FlashID").getShare();
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
				getFlash("FlashID").getShare();
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
				getFlash("FlashID").getShare();
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
				getFlash("FlashID").getShare();
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
				getFlash("FlashID").getShare();
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
				getFlash("FlashID").getShare();
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
				getFlash("FlashID").getShare();
			}
		});
	}
	