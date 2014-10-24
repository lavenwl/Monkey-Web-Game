package com.stang.game.server.handler;

import com.stang.game.cache.GlobalData;

public class UtilHandler {
	private SystemHandler systemHandler;
	
	private SystemHandler getsystemHandler() {
		if (systemHandler == null) {
			systemHandler = new SystemHandler();
		}
		return systemHandler;
	}
	
	/**
	 * 该方法是发送广播用的
	 * 在GlobalData可以通过改变静态变量来通用的改变显示颜色值
	 */
	public void sendGetMessage(String name,int vip,String where,int pinzhi,String goodsName,String apiName,int roleid){
		String[] str = {"豪掷千金!","大手一挥!","砸锅卖铁!","孤注一掷!","豪气冲天!","惊天地泣鬼神!"};
		String thing = str[(int)(Math.random()*str.length)];
		System.out.println("where.equals寻宝?"+where.equals("寻宝"));
		if(vip != 0){
			String message = 
				"寻宝_玩家 <font color="+"\"" + GlobalData.messageColor.get("player")+"\">" + name + "</font> "
				+ "<font color="+"\"" + GlobalData.messageColor.get("vip")+"\">" + "VIP"+vip + "</font> "
				+ thing
				+"获得了"+ " <font color="+"\"" + GlobalData.color.get(pinzhi)+ "\">" +goodsName + "</font>"
				+"~"+roleid;
//			GameConstants.log.warn(apiName+".compose:" + message);
			this.getsystemHandler().addMessage(message);
		}else if(vip == 0){
			String message = 
				"寻宝_玩家 <font color="+"\"" + GlobalData.messageColor.get("player")+"\">" + name + "</font> "
				+ thing
				+"获得了"+ " <font color="+"\"" + GlobalData.color.get(pinzhi)+ "\">" +goodsName + "</font>"
				+"~"+roleid;
//			GameConstants.log.warn(apiName+".compose:" + message);
			this.getsystemHandler().addMessage(message);
		}
	}
	
	public void sendGetMessage(String name,int vip,String where,int pinzhi,String goodsName,String apiName){
		String[] str = {"豪掷千金!","大手一挥!","砸锅卖铁!","孤注一掷!","豪气冲天!","惊天地泣鬼神!"};
		String thing = str[(int)(Math.random()*str.length)];
		if(vip != 0){
			String message = 
				"玩家 <font color="+"\"" + GlobalData.messageColor.get("player")+"\">" + name + "</font> "
				+ "<font color="+"\"" + GlobalData.messageColor.get("vip")+"\">" + "VIP"+vip + "</font> "
				+ thing
				+" 通过 <font color=" +"\"" + GlobalData.messageColor.get("where")+"\">" + where + "</font> "
				+"获得了"+ " <font color="+"\"" + GlobalData.color.get(pinzhi)+ "\">" +goodsName + "</font>";
//			GameConstants.log.warn(apiName+".compose:" + message);
			this.getsystemHandler().addMessage(message);
		}else{
			String message = 
				"玩家 <font color="+"\"" + GlobalData.messageColor.get("player")+"\">" + name + "</font> "
				+ thing
				+" 通过 <font color=" +"\"" + GlobalData.messageColor.get("where")+"\">" + where + "</font> "
				+"获得了"+ " <font color="+"\"" + GlobalData.color.get(pinzhi)+ "\">" +goodsName + "</font>";
//			GameConstants.log.warn(apiName+".compose:" + message);
			this.getsystemHandler().addMessage(message);
		}
	}
	
	public void sendCustomsMessage(String name,int vip,String where,int pinzhi,int xing,String goodsName,String apiName){
		String nandu= null;
		switch (pinzhi) {
		case 0:
			nandu = "普通";
			where = "娴熟的手法";
			break;
		case 1:
			nandu = "困难";
			where = "惊人的操作";
			break;
		case 2:
			nandu = "噩梦";
			where = "弹钢琴的手速";
			break;
		case 3:
			nandu = "地狱";
			where = "砸坏鼠标的破坏力";
			break;
		default:
			break;
		}
		if(vip != 0){
			String message = 
				"玩家 <font color="+"\"" + GlobalData.messageColor.get("player")+"\">" + name + "</font> "
				+ "<font color="+"\"" + GlobalData.messageColor.get("vip")+"\">" + "VIP"+vip + "</font> "
				+"以 <font color=" +"\"" + GlobalData.messageColor.get("where")+"\">" + where + "</font> "
				+xing+"星成绩通关了"+ " <font color="+"\"" + GlobalData.colorMission.get(pinzhi)+ "\">"+nandu+" "+goodsName + "</font>";
//			GameConstants.log.warn(apiName+".compose:" + message);
			this.getsystemHandler().addMessage(message);
		}else{
			String message = 
				"玩家 <font color="+"\"" + GlobalData.messageColor.get("player")+"\">" + name + "</font> "
				+ "以 <font color=" +"\"" + GlobalData.messageColor.get("where")+"\">" + where + "</font> "
				+xing+"星成绩通关了"+ " <font color="+"\"" + GlobalData.colorMission.get(pinzhi)+ "\">"+nandu+" "+goodsName + "</font>";
//			GameConstants.log.warn(apiName+".compose:" + message);
			this.getsystemHandler().addMessage(message);
		}
	}
}
