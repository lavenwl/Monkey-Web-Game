var jsReady = false;
	pageInit();
	function toDesktop(sUrl,sName)
	{
		sUrl = document.URL;
		sName = document.title;
	try
	{
	var WshShell = new ActiveXObject("WScript.Shell");
	var oUrlLink = WshShell.CreateShortcut(WshShell.SpecialFolders("Desktop") + "//" + sName + ".url");
	oUrlLink.TargetPath = sUrl;
	oUrlLink.Save();
	}
	catch(e)
	{
	alert("当前IE安全级别不允许操作！请设置后在操作.");
	}
	}
	function addfavorite()
	{
	   if (document.all)
	   {
		   window.external.addFavorite(document.URL,document.title);
	   }
	   else if (window.sidebar)
	   {
		   window.sidebar.addPanel(document.title, document.URL, ""); 
	   }else{
	   }
	} 
	function getIsNew(){
		return isNew;
	}
	function getPid(){
		return d5;
	}
	function getRequestGiftBack(){
		return requestGiftBack;
	}
	function getSIp(){
		return d7;
	}
	function getSId(){
		return d6;
	}
	function getrole(){
		return d8;
	}
	function getOpenid(){
		return d1;
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
//	function YellowVip() {
//	$.post("QQOpenApi", {"openid":d1,"openkey":d2,"pf":d3,"id":d5,"success":success, "serverId":d6, "serverIp":d7}, function (data, status) {
//	
//	}, "json");
//	}
//	function isYellowVip() {
//	$.post("QQOpenApi", {"openid":d1,"openkey":d2,"pf":d3,"id":d5,"success":success, "serverId":d6, "serverIp":d7}, function (data, status) {
//		getFlash("FlashID").getYellowVip(data[0].name);
//	}, "json");
//	}
//	function getFriends() {
//	$.post("Friends", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"id":d5, "serverId":d6}, function (data, status) {
//		
//	}, "json");
//	}
//	function getGroupFriends() {
//		$.post("GroupFriends", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"id":d5, "serverId":d6}, function (data, status) {
////			alert(data[0].name);
////			getFlash("FlashID").getGroupFriends(data[0].name);
//		}, "json");
//		}
	
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
	
	function newname(name) {
		$.post("NewName", {"openid":d1,"name":name,"serverId":d6,"id":d5}, function (data,status) {
			getFlash("FlashID").getNewName(data[0].name,name);
		}, "json");
		}
	
	function goods1(payitem,goodsmeta,goodsurl) {
	$.post("goods", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl,"zoneid":d6}, function (data) {
		buy1(data[0].name,payitem);
	}, "json");
	}
	
	function goods2(payitem,goodsmeta,goodsurl) {
	$.post("goods", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl,"zoneid":d6}, function (data) {
		buy2(data[0].name,payitem);
	}, "json");
	}
	
	function goods3(payitem,goodsmeta,goodsurl) {
	$.post("goods", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl,"zoneid":d6}, function (data) {
		buy3(data[0].name,payitem);
	}, "json");
	}
	
	function goods4(payitem,goodsmeta,goodsurl) {
	$.post("goods2", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"payitem":payitem,"goodsmeta":goodsmeta,"goodsurl":goodsurl,"zoneid":d6}, function (data) {
		buy2(data[0].name,payitem);
	}, "json");
	}
	
	function buy1(url_param,payitem){
		getFlash("FlashID").addMask();
		fusion2.dialog.buy({
			disturb : false,
			param : url_param,
			sandbox : false,//上线后去掉
			context : "3tang",
			onSuccess : function (opt) {  getFlash("FlashID").removeMask();},
			onSend : function(opt) { alert("发货超时");},
			onClose : function (opt) {  getFlash("FlashID").removeMask();} 
		});
	}
	function buy2(url_param,payitem){
		getFlash("FlashID").addMask();
		fusion2.dialog.buy({
			disturb : false,
			param : url_param,
			sandbox : false,//上线后去掉
			context : "3tang",
			onSuccess : function (opt) {  getFlash("FlashID").removeMask();},
			onSend : function(opt) { alert("发货超时");},
			onClose : function (opt) {  getFlash("FlashID").removeMask();} 
		});
	}
	
	function buy3(url_param,payitem){
		getFlash("FlashID").addMask();
		fusion2.dialog.buy({
			disturb : false,
			param : url_param,
			sandbox : false,//上线后去掉
			context : "3tang",
			onSuccess : function (opt) {  getFlash("FlashID").removeMask();},
			onSend : function(opt) { alert("发货超时");},
			onClose : function (opt) {  getFlash("FlashID").removeMask();} 
		});
	}
	
	function delivery() {
	$.post("delivery", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"zoneid":d6}, function (data) {
	}, "json");
	}
	
	function token() {
	$.post("token", {"openid":d1,"openkey":d2,"pf":d3,"pfkey":d4,"zoneid":d6}, function (data) {
		openVipGift(data[0].name);
	}, "json");
	}
	function openVipGift(e){
		fusion2.dialog.openVipGift({
			token:e,
			actid:"UM130704104643962",
			zoneid:d6,
			openid:d1,
			onSuccess : function (opt) {  getFlash("FlashID").getToken("92*650*10");}
		});
	}
	
	function invite(){
		fusion2.dialog.invite({
				msg  : "快来玩啊",
		  		source : "roleidd"+d5+"*"+"serveridd"+d6, 
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
		pay();
		}
	},'json');
}
	
	function pay(){
fusion2.dialog.pay ({ 
  		zoneid : d6,
  		sandbox : false, 
  		onClose : function () {
  		}
	}); 
}
	
//分享
	function share1(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！新手闯关成功！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我成功通过了西游试炼之路，赶紧加入我的队伍，一起抓唐僧吧！",
			onSuccess:function(opt){
			$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
				getFlash("FlashID").getShare();
			},'json');
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
				$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
					getFlash("FlashID").getShare();
				},'json');
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
				$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
					getFlash("FlashID").getShare();
				},'json');
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
				$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
					getFlash("FlashID").getShare();
				},'json');
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
				$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
					getFlash("FlashID").getShare();
				},'json');
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
				$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
					getFlash("FlashID").getShare();
				},'json');
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
				$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
					getFlash("FlashID").getShare();
				},'json');
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
				$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
					getFlash("FlashID").getShare();
				},'json');
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
				$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
					getFlash("FlashID").getShare();
				},'json');
			}
		});
	}
	
	function mul_server(){
		alert('调用了mul_server');
	}
	
	function share10(i){
		fusion2.dialog.sendStory(
		{
			title:"恭喜您！魔将转职成功啦！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/image.png",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"魔将成功晋级了，抓唐僧我的把握更大了，要来参加么！",
			onSuccess:function(opt){
				$.post('share',{"id":d5,"num":i,"type":0,"serverIp":d7,"serverId":d6},function(data,status){
					getFlash("FlashID").getShare();
				},'json');
			}
		});
	}
	//分享
	function share(openid){
		fusion2.dialog.sendStory(
		{
			title:"颠倒西游！",
			img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/fengxiang_1.jpg",
			summary:"2013年打破传统观念的塔防游戏《颠倒西游》诞生啦！欢迎各路玩家前来，抓唐僧，体验非一般的西游记",
			msg:"我成功通过了西游试炼之路，赶紧加入我的队伍，一起抓唐僧吧！",
			onSuccess:function(opt){
			$.post('share',{"id":d5,"type":1,"serverIp":d7,"serverId":d6},function(data){
				getFlash("FlashID").getflaunt(1);
			},'json');
			}
		});
	}
	
	function challenge(openid){
				fusion2.dialog.brag(
				{
					type : "pk", 
		     title : "向好友挑战一下",
		     msg : "你弱爆啦！！不服气的话来找我再战吧！", 
		       receiver : [openid],
		     img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/tiaozhan_1.jpg",
		     context : "challenge", 
		     onSuccess : function (opt) 
		     {  
					$.post('share',{"id":d5,"type":4,"serverIp":d7,"serverId":d6},function(data){
						getFlash("FlashID").getflaunt(4);
					},'json');
		     }
				});
			}
			
//	  function flaunt(openid){
//				fusion2.dialog.brag(
//				{
//			 type : "brag", 
//		     title : "向好友炫耀一下",
//		     msg : "你弱爆啦！！不服气的话来找我再战吧！", 
//		     receiver : [openid],
//		     img:"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/xuanyao_1.jpg",
//		     context : "flaunt", 
//		     onSuccess : function (opt) 
//		     {  
//					  $.post('share',{"id":d5,"type":2,"serverIp":d7,"serverId":d6},function(data){
//							getFlash("FlashID").getflaunt(2);
//						},'json');
//		     }
//				});
//			}
	  
			function freegift(openid){
			fusion2.dialog.sendRequest
		    ({
		    type : 'freegift',
		    receiver : [""],
		    stat:'action_id',
		    title : '诛仙令',
		    msg : '送你一个诛仙令，赶快去争霸战去吧！',
		    img:'http://app24341.qzoneapp.com/app24341/feed_clown.png',
		    source :"ref=freegift&zoneid=2",
		    context : "freegift",
		     onSuccess : function (opt)
		     {
		        $.post('freegift',{"id":d5},function(data,status){
					   getFlash("FlashID").getfreegift();
						},'json');
		      }
		      });
			}
			
			function friendrequest(openid){
			   fusion2.dialog.sendRequest
		       ({
		        type : 'request',
		        receiver : [""],
		        stat:'action_id',
		        title : '诛仙令',
		        msg : '请你给我一个诛仙令，我好去争霸战！',
		        img:'http://app24341.qzoneapp.com/app24341/feed_clown.png',
		        source :"ref=freegift&zoneid=2",
		        context : "friendrequest",
		        onSuccess : function (opt)
		        {
		        $.post('friendrequest',{"id":d5},function(data,status){
					  getFlash("FlashID").getfriendrequest();
						},'json');
		        }
		        });
			}
			
		function sharedemo(openid){
			fusion2.dialog.shareDemo
		    ({
		     title :"2013创新双模式塔防大作《颠倒西游》",
		     summary :"什么，你还不知道《颠倒西游》！你OUT啦，快点击图片试试吧！",
		    msg :"我刚在《颠倒西游》里干翻了孙悟空！",
		    img :"http://app100719210.imgcache.qzoneapp.com/app100719210/pic/shiwan.jpg",
		    flashlink :"http://app100719210.imgcache.qzoneapp.com/app100719210/res/demo/diandaoxiyoushiwan.swf",
		    context :"sharedemo",
		    onSuccess : function (opt) 
		    {  
		    	  $.post('share',{"id":d5,"type":3,"serverIp":d7,"serverId":d6},function(data){
						getFlash("FlashID").getflaunt(3);
					},'json');
		     }
		});
			}
		
      function askoldfriend(i){
    	  fusion2.dialog.reactive
  		({
  		     title : "颠倒西游", 
  		     receiveImg: "http://app100719210.imgcache.qzoneapp.com/app100719210/pic/zhaohuanpengyou1.png",
  		     sendImg: "http://app100719210.imgcache.qzoneapp.com/app100719210/pic/zhaohuanpengyou2.png",
  		     msg: "赶快回来和我一起玩颠倒西游这个应用吧，没有你很孤单啊。", 
  		     source : d5,
  		    context : "reactive_12345", 
  		    onSuccess : function (opt) 
  		    {   // 通过opt.context可获取接口中传入的context透传参数，以识别请求
   			   $.post('share',{"id":d5,"type":5,"serverIp":d7,"serverId":d6},function(data){
   					getFlash("FlashID").getoldfriend(i);
   				},'json');
  		    }
  		 }); 
      }
      
      
      
      
      
//      function qqgroup(){
//    	  fusion2.dialog.inviteToGroup
//    	  ({
//    	    msg : "快来加入颠倒西游官方群吧，与群好友互动，让你的游戏更加充满激情！",
//    	    img : "http://qzonestyle.gtimg.cn/open_proj/proj_app_store_v2/ac/app/popup/bg_text_tip.png",
//    	    officialGroup : "EC640425CBF78133C3D1C44FE3042F58",
//    	    onSuccess : function (opt) { getGroupFriends() },
//    	    onClose : function (opt) { getGroupFriends() }
//    	  });
//      }
      
      function freegift(itemid, type, receiver, title, msg, img, source, desc){
    	  fusion2.dialog.sendRequest
    	  ({
    	  type : type,
    	  receiver : [receiver],
    	  title : title,
    	  msg : msg,
    	  img:img,
    	  source :source,
    	  desc : desc,
    	  onSuccess : function (opt)
    	  {
    		  getFlash("FlashID").saveGiftData();
    	  },
    	  onCancel : function (opt) { },
    	  onClose : function (opt) { }
    	  });
      }
		
    