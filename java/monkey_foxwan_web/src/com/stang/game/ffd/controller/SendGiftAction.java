package com.stang.game.ffd.controller;


import java.io.PrintWriter;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import apiinterface.Home;

import com.opensymphony.xwork2.Action;
import com.stang.game.common.GameConstants;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.entity.detail.GameItemDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.MemberDetail;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.entity.detail.SendgiftlogDetail;
import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;
import com.stang.game.service.IAutoIdService;
import com.stang.game.service.IGameItemService;
import com.stang.game.service.IGameRoleService;
import com.stang.game.service.IMemberService;
import com.stang.game.service.IRoleItemService;
import com.stang.game.service.SendgiftlogService;
import com.stang.game.service.impl.AutoIdServiceImpl;
import com.stang.game.service.impl.GameItemServiceImpl;
import com.stang.game.service.impl.GameRoleServiceImpl;
import com.stang.game.service.impl.MemberServiceImpl;
import com.stang.game.service.impl.RoleItemServiceImpl;
import com.stang.game.service.impl.SendgiftlogServiceImpl;
public class SendGiftAction implements ServletResponseAware,ServletRequestAware{
	private static IGameRoleService gameRoleService=new GameRoleServiceImpl();
	private static IGameItemService gameItemService=new GameItemServiceImpl();
	private static IMemberService memberservice=new MemberServiceImpl();
	private static SendgiftlogService sendgiftlogservice=new SendgiftlogServiceImpl();
	private static IRoleItemService roleItemService;
	private static IAutoIdService autoIdService;
	private HttpServletResponse response;
	private String[] unames;
	private String[] serverids;
	private String[] gifts;
	private HashMap<String, Object>infoMap = new HashMap<String, Object>();
	private HashMap<String,Object> imfoMapGiftBag= new HashMap<String,Object>();
	private HttpServletRequest request;
	public static ConcurrentHashMap<String,HashMap<String,Object>> cacheSqlMap= new ConcurrentHashMap<String,HashMap<String,Object>>();
	List<String> allgift=new ArrayList<String>();
	List<String> alluser=new ArrayList<String>();
	StringBuilder giftslog= new StringBuilder();
	StringBuilder roleslog= new StringBuilder();
	Map<String,Object> para = new HashMap<String,Object>();
	protected static IAutoIdService getAutoIdService() {
		if (autoIdService == null) {
			autoIdService = new AutoIdServiceImpl();
		}
		return autoIdService;
	}
	private IRoleItemService getRoleItemService() {
		if (roleItemService == null) {
			roleItemService = new RoleItemServiceImpl();
		}
		return roleItemService;
	}
	public String execute() throws Exception {
		
		System.out.println("unames========"+unames[0]+serverids[0]+"======serverids");
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		HttpSession session = ((HttpServletRequest)request).getSession();

		if(unames==null||gifts==null){
			return "error";
			
		}else{
			for(String gift:gifts){//得到所有的礼品
				
				System.out.println(gifts);
				String[] gift2=gift.split("-");
				int length=gift2.length;
				String gif=gift2[length-1];
				allgift.add(gif);
				giftslog.append(gif);
				giftslog.append(",");//把所有的礼品追加一起成字符串类型
				System.out.println(gif);
			}
			
			/****/
			
			String stgift=giftslog.toString();//得到了所有的礼品字符串
		   String menage=(String) session.getAttribute("uname");//发放礼品管理者
		           Date dt=new Date();
			SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dqtime=matter1.format(dt);//得到当前时间
			System.out.println(stgift+"所有的礼品====================="+menage+"发放礼品用户名=============");
			//InetAddress ips= InetAddress.getLocalHost();
			
			//String ip=String.valueOf(ips);
			//String st[]=ip.split("/");
			
			//String realIP=st[1];
			
			String realIP=request.getRemoteAddr();
			System.out.println(realIP+"获得ip====================");
		//for(String uname:unames){//先查看unames里面有没有�?�?��用户”，有就把奖品给�?��玩家，没有，就遍历需要更新的玩家，并更新
			for(int j=0;j<unames.length;j++){
				String uname=unames[j];
			if(uname.equals("所有用户")){//更新�?��用户表的礼品，并跳出循环
		//首先查找到所有的用户
				List<GameRoleDetail> gameroles =gameRoleService.getRoleByLevel(para);
			for(GameRoleDetail gamerole:gameroles){
				
				int roleId=gamerole.getId();
			
				int length=allgift.size();
				for(int i=0;i<length;i++){//遍历出所有的礼物，根据礼物名查询Id
					String onegift=allgift.get(i);
					List<GameItemDetail> gameitem=gameItemService.getGameItemId(onegift);
					
					int itemId=gameitem.get(0).getId();
					getLiveItem(roleId,itemId,1,5);
					System.out.println("======================所有===================");
				}
				
			}
		
			SendgiftlogDetail lr=new SendgiftlogDetail();
			lr.setWanjiaid(00001111);
			lr.setLipin(stgift);
			lr.setMenage(menage);
			lr.setTime(dqtime);
			lr.setIp(realIP);
			sendgiftlogservice.insertsendgift(lr);
			System.out.println("插入所有用户成功===========================");
			break;
			}else{
				//根据Id更新部分用户的礼品，主要逻辑在此
				//根据uname(就是openid)去member表查询对应的roleid
				System.out.println(uname+"uname==========================");
				System.out.println(serverids[j]+"serverid==========================");
				param.clear();
				param.put("openid", uname);
				param.put("serverid", serverids[j]);
				//List<MemberDetail> members=memberservice.findMemberByOpenid(uname);
				List<MemberDetail> members=memberservice.findMemberByParam(param);
				
				if(members.size()==0){
					return "error";
				}
				int roleId=members.get(0).getId();
				//int roleId=NumberUtils.createInteger(String.valueOf(uname));
				int length=allgift.size();
				for(int i=0;i<length;i++){//遍历出所有的礼物，根据礼物名查询Id
					String onegift=allgift.get(i);
					List<GameItemDetail> gameitem=gameItemService.getGameItemId(onegift);
					
					int itemId=gameitem.get(0).getId();
					getLiveItem(roleId,itemId,1,5);
				}
				//给不同的玩家发送的礼品，保存到日志表里面
				SendgiftlogDetail lr=new SendgiftlogDetail();
				lr.setWanjiaid(roleId);
				lr.setLipin(stgift);
				lr.setMenage(menage);
				lr.setTime(dqtime);
				lr.setIp(realIP);
				sendgiftlogservice.insertsendgift(lr);
			System.out.println("插入不同玩家礼品发送成功=====================");
			}
		}
			return "success";
		}
	}
	
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}
	
	
	
	public String[] getServerids() {
		return serverids;
	}
	public void setServerids(String[] serverids) {
		this.serverids = serverids;
	}
	public String[] getUnames() {
		return unames;
	}
	public void setUnames(String[] unames) {
		this.unames = unames;
	}
	public String[] getGifts() {
		return gifts;
	}
	public void setGifts(String[] gifts) {
		this.gifts = gifts;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
//	public static void insertMember(String name, String serverid){
//		//new Client("10.142.35.79", 8008).start();
//		//System.out.println("tomcat请求socket开始______________________________insertMember:name:" + name + " serverid:" + serverid);
//	    new Client("192.168.2.64", 8008).start();
//		HashMap<String, Object> papa = new HashMap<String, Object>();
//		 HashMap<String, Object> infoMap=new HashMap<String, Object>();
//		 papa.put("name", name);
//		 papa.put("serverid", serverid);
//		infoMap.put("_guid", 0);
//		infoMap.put("_cachekey", "noCachekey");
//		infoMap.put("_sig", "robot");
//		infoMap.put("_serverId", 1);
//		infoMap.put("_pid", 1);
//		infoMap.put("_cmd", "sys.cacheMember");
//		infoMap.put("_params", papa);
//		infoMap.put("_key1", "1");
//		infoMap.put("_key2", "0000");
//		infoMap.put("_key3", "12");
//		infoMap.put("_key3tang", "12");
//		Client.smcHander.sendData(infoMap);
//		System.out.println("tomcat请求socket结束____________________________________");
//	}
	
	void getLiveItem(int roleId,int id,int num,int type){
		try{
			for(int i = 0; i < serverids.length; i++){
				int ids = Integer.valueOf(serverids[i].split(" ")[0]);
				//System.out.println("MessageAction.id:" + id);
				//String IP = getServerIp(ids);
				//System.out.println("MessageAction.IP:" + IP);
				//new Client(IP, 8008).start();
				HashMap<String, Object> papa = new HashMap<String, Object>();
				HashMap<String, Object> infoMap=new HashMap<String, Object>();
				papa.put("roleid", roleId);
				papa.put("itemid", id);
				infoMap.put("_guid", 0);
				infoMap.put("_cachekey", "noCachekey");
				infoMap.put("_sig", "robot");
				infoMap.put("_serverId", 1);
				infoMap.put("_pid", 1);
				infoMap.put("_cmd", "sys.cacheRoleItem");
				infoMap.put("_params", papa);
				infoMap.put("_key1", "1");
				infoMap.put("_key2", "0000");
				infoMap.put("_key3", "12");
				infoMap.put("_key3tang", "12");
				ClientManager cm = ClientManager.getInstance();
				cm.getClient(ids).smcHander.sendData(infoMap);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private String getServerIp(int id){
		String IP = "";
		List<ServerDetail> serverlist = null;
		List<String> l = null;
		Home home  = new Home();
		serverlist = home.getServerList();
		l = new ArrayList<String>();
		for(int i = 0; i < serverlist.size(); i++){
			if(serverlist.get(i).getId() == id){
				IP = serverlist.get(i).getIp();
			}
		}
		return IP;
	}
}
