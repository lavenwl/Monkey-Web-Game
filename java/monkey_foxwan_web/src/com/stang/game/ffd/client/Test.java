package com.stang.game.ffd.client;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;

import net.sf.json.JSONArray;
import net.sf.sojo.interchange.json.JsonSerializer;

import com.alibaba.fastjson.JSON;
import com.qq.open.OpenApiV3;
import com.qq.open.OpensnsException;

import dbconn.DBConnectionManager;
import entity.Huangzuan;

import buyapi.Send;
import apiinterface.Share;
import apiinterface.ThreadShare;

public class Test {
	private static PrintWriter log;
	final static String appid = "100719210";
	final static String appkey = "cd9da8b634c25e0e2eb683fe56c1f268";
	static OpenApiV3 sdk = new OpenApiV3(appid, appkey);
	static String Name = null;
	static String huangzuaninfo = null;
public static void main(String[] args) {
	
	
	
	
	
	
	int requestGiftBack = 0;
	String success = "roleid=32432342*serverid=78";
	ThreadShare.log("success1111:" + success);
	String str[] = success.split("\\*");
	System.out.println("str");
	String roleidstr = str[0];
	String roleid = roleidstr.substring(7, roleidstr.length());
	String serveridstr = str[1];
	String serverid =  serveridstr.substring(9, serveridstr.length());
	requestGiftBack = Integer.valueOf(serverid);
	success = roleid;
	System.out.println("success:" + success + " str[]:" + str.toString() + " roleidstr:" + roleidstr + " serveridstr:" + serveridstr + " roleid:" + roleid + " serverid:" + serverid + " requestGiftBack:" + requestGiftBack + " success:" + success);

	System.out.println("qqopenapi.............friends");
//	String serverName = "openapi.tencentyun.com";//正式上线用
	String serverName = "119.147.19.43";
	sdk.setServerName(serverName);
	String scriptName = "/v3/relation/get_app_friends";//
	String protocol = "http";
	String serverId ="3";
	// 填充URL请求参数
	HashMap<String, String> params = new HashMap<String, String>();
//	params.put("openid", request.getParameter("openid"));
//	params.put("openkey", request.getParameter("openkey"));
//	params.put("pf", request.getParameter("pf"));
	params.put("appid", appid);
	//int id = Integer.parseInt(request.getParameter("id"));
	
	//本地测试用
	params.put("openid", "B5F2D2E38B2E5135D90CFF93F7BEAAC3");
	params.put("openkey", "E38457A1280FC8B83B889F264041C758");
	params.put("pf", "qzone");
	try {
		String resp = sdk.api(scriptName, (HashMap<String, String>) params,
				protocol);
		System.out.println(resp+".............resp");
	//	response.setContentType("text/html;charset=UTF-8");
		//黄钻，更新数据库
		DBConnectionManager dbp = DBConnectionManager.getInstance();
		Connection co = dbp.getConnection("server" + serverId);
		Statement st = null;
		try {
			st = co.createStatement();
//			int id = 6004;
			List<Map> resList = JSON.parseArray(String.valueOf("["+resp+"]"), Map.class);
			if(resList.get(0).get("items")!=null){
				String openids = resList.get(0).get("items").toString();
				//int res = st.executeUpdate("update member set allfriends = '"+openids+"'where id = " + id);
			}
			st.close();
			co.close();
			dbp.freeConnection("server" + serverId, co);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	//	PrintWriter out = response.getWriter();
		List list = new ArrayList();
		Huangzuan h = new Huangzuan();
		h.setId(0);
		h.setName(resp);
		list.add(h);
		JSONArray obj = JSONArray.fromObject(list);
//		out.println(obj.toString());
//		out.close();
		
	} catch (OpensnsException e) {
		System.out.printf("Request Failed. code:%d, msg:%s\n", e
				.getErrorCode(), e.getMessage());
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.format("Request Failed. code:%d, msg:%s\n", e.getErrorCode(), e
//				.getMessage());
//		out.flush();
//		out.close();
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	
	
	
	
	
	//System.out.println(Integer);
	//ClientManager cm = ClientManager.getInstance();
//	//cm.getClient(3).smcHander.sendData(infoMap);
	//ClientManager cm2 = ClientManager.getInstance();
//	System.out.println("1:" + cm.getClient(1));
	
//	String logFile = "ClientManager.txt";
//	try {
//		log = new PrintWriter(new FileWriter(logFile, true), true);
//	} catch (IOException e) {
//		System.err.println("无法打开日志文件：" + logFile);
//		log = new PrintWriter(System.err);
//	}
//	log("ttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
//	
	
//	int i = 0;
//	if(i == 0)
//		i = 1;
//	else
//		i = 3;
	
	
	
//	String l = "4 sdfasdf";
//	String[] a = l.split(" ");
//	System.out.println("__________________________:" + a[0] + "a");
	
//	try{
//		InetAddress addr = InetAddress.getLocalHost();
//		String ip=addr.getHostAddress().toString();
//		System.out.println("ip:" + ip);
//	}catch(Exception e){
//		e.printStackTrace();
//	}
	
//	//测试特殊字符
//	HashMap<String, Object> papa = new HashMap<String, Object>();
//	 HashMap<String, Object> infoMap=new HashMap<String, Object>();
//		ClientManager cm = ClientManager.getInstance();
//	
//	
//	
////	String name = "\xF0\x9F\x91\x91 \xE6...";
//	char[] names = new char[24];
//	names[0] = '\\';
//	

//	
//			System.out.println("qqopenapi.............");
//			//String serverName = "openapi.tencentyun.com";//正式上线用
//			String serverName = "119.147.19.43";
//			sdk.setServerName(serverName);
//			String scriptName = "/v3/user/get_info";//获取用户的基本资料：昵称、性别、头像、所在地
//			String protocol = "http";
//			//String IP = request.getParameter("serverIp");
//			String serverId = "3";
//			int serverid = Integer.valueOf(serverId);
//			//String IP = getServerIp(Integer.valueOf(serverId));
//			// 填充URL请求参数
//			HashMap<String, String> params = new HashMap<String, String>();
//			params.put("openid", "B5F2D2E38B2E5135D90CFF93F7BEAAC3");
//			params.put("openkey", "02E313BC847067D09912A2C78F413547");
//			params.put("pf", "qzone");
//			try {
//				String resp = sdk.api(scriptName, (HashMap<String, String>) params, protocol);
//				System.out.println(resp+".............resp");
//				//更新名字
//				List<Map> list = JSON.parseArray("["+resp+"]",Map.class);
//				if(Integer.parseInt(String.valueOf(list.get(0).get("ret")))==0){
//					Name = String.valueOf(list.get(0).get("nickname"));
//					huangzuaninfo="["+resp+"]";
//					System.out.println("Name:" + Name);
//				}
//			} catch (OpensnsException e) {
//				System.out.printf("Request Failed. code:%d, msg:%s\n", e.getErrorCode(), e.getMessage());
//				e.printStackTrace();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			JsonSerializer json1 = new JsonSerializer();
//			System.out.println("SystemHandler.GameRoleThreee:huangzuaninfo:"+huangzuaninfo);
//			List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json1.deserialize(huangzuaninfo);
//			String name = String.valueOf(roleinfo.get(0).get("nickname"));
			
			
//			System.out.println("SystemHandler.GameRoleThreee:huangzuaninfo:"+huangzuaninfo);
//			List<Map<String, Object>> roleinfo = (List<Map<String, Object>>) json1.deserialize(huangzuaninfo);
//			String name = String.valueOf(roleinfo.get(0).get("nickname"));
//			String name2 = checkStr(name);
//			roleinfo.get(0).put("nickname", name2);
//			huangzuaninfo = (String) json1.serialize(roleinfo);
//			List<Map<String, Object>> roleinfot = (List<Map<String, Object>>) json1.deserialize(huangzuaninfo);
//			String namet = String.valueOf(roleinfot.get(0).get("nickname"));
//			System.out.println("namet:" + namet);
//			//huangzuaninfo = checkStr(huangzuaninfo);
//			System.out.println("SystemHandler.GameRoleThreee:huangzuaninfo:"+huangzuaninfo);
			
			
			
//			//String name = String.valueOf(list.get(0).get("nickname"));
//			System.out.println("name:" + name);
//			String name2 = checkStr(name);
//			System.out.println("name:" + name2);
//			roleinfo.get(0).put("nickname", name2);
//			name = String.valueOf(roleinfo.get(0).get("name"));
//			System.out.println("name:" + name);
//			huangzuaninfo = (String) json1.serialize(roleinfo);
			//huangzuaninfo = checkStr(huangzuaninfo);
//			System.out.println("SystemHandler.GameRoleThreee:huangzuaninfo:"+huangzuaninfo);
			
			
			
			
//			System.out.println("namename:" + checkStr(Name));
//	System.out.println("-__________________________________________________________________--");
	
	Send s = new Send();
	//Share sa = new Share();
	try {
		while(true){
			try{
				//String ZERO="00000000";
				Scanner in = new Scanner(System.in);
				int j = in.nextInt();
//				String named = in.nextLine();
//				System.out.println("Name:" + Name);
//				byte[] dd = Name.getBytes();
//				for(int i = 0;i<dd.length;i++){
//					String ss = Integer.toBinaryString(dd[i]);
//					if(ss.length() > 8){
//						ss=ss.substring(ss.length()-8);
//					}else if(ss.length() < 8){
//						ss=ZERO.substring(ss.length())+ss;
//					}
//					System.out.println(ss);
//					System.out.println("i:" + i + " byte[" + i + "]: " + Integer.toHexString(dd[i] & 0xFF) + "	["  + "] " + dd[i]);
//
//				}
//				for(int i = 0; i < dd.length; i++){
//					System.out.println("i:" + i + " byte[" + i + "]: " + Integer.toHexString(dd[i] & 0xFF) + "	["  + "] " + dd[i]);
//				}
//				char[] cc = Name.toCharArray();
//				for(int j = 0; j < Name.length(); j++){
//					System.out.println("j:" + j + " Char[" + j + "]:" + cc[j] + "	boolean:" + isValidChar(cc[j]));
//				}
				//System.out.println("Name:" + named);
				//String name = named;
				//String name = Name;
				//st.executeUpdate("update game_role set name = '"+name+"'where id = " + id);
				// new Client(IP, 8008).start();
//				 papa.clear();
//				 infoMap.clear();
//					papa.put("roleid", 12361791);
//					papa.put("name", Name);
//					infoMap.put("_guid", 0);
//					infoMap.put("_cachekey", "noCachekey");
//					infoMap.put("_sig", "robot");
//					infoMap.put("_serverId", 1);
//					infoMap.put("_pid", 1);
//					infoMap.put("_cmd", "sys.cacheGameRolethree");
//					infoMap.put("_params", papa);
//					infoMap.put("_key1", "1");
//					infoMap.put("_key2", "0000");
//					infoMap.put("_key3", "12");
//					infoMap.put("_key3tang", "12");
//					cm.getClient(3).smcHander.sendData(infoMap);
//					
//					
//					 papa.clear();
//					 infoMap.clear();
//						papa.put("roleid", 12361791);
//						papa.put("huangzuaninfo", huangzuaninfo);
//						infoMap.put("_guid", 0);
//						infoMap.put("_cachekey", "noCachekey");
//						infoMap.put("_sig", "robot");
//						infoMap.put("_serverId", 1);
//						infoMap.put("_pid", 1);
//						infoMap.put("_cmd", "sys.cacheGameRolethree");
//						infoMap.put("_params", papa);
//						infoMap.put("_key1", "1");
//						infoMap.put("_key2", "0000");
//						infoMap.put("_key3", "12");
//						infoMap.put("_key3tang", "12");
//						cm.getClient(3).smcHander.sendData(infoMap);
				for(int i = 0; i < 1; i++){
					long a = System.currentTimeMillis();
					System.out.println("a__________________________________________________:" + a);
					//s.service(j);
					long b = System.currentTimeMillis();
					System.out.println("b___________________________________________________:" + b + "用时：" + (b -a));
				}
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}
			
		}
		
//		while(true){
//			try{
//				Scanner in = new Scanner(System.in);
//				System.out.println("roleid:");
//				int roleid = in.nextInt();
//				System.out.println("serverid:");
//				int serverid = in.nextInt();
//				System.out.println("type:");
//				int type = in.nextInt();
//				System.out.println("i:");
//				int sharetype = in.nextInt();
//				
//				for(int i = 0; i < 1; i++){
//					long a = System.currentTimeMillis();
//					System.out.println("a__________________________________________________:" + a);
//					//sa.service(roleid, serverid, type, sharetype);
//					long b = System.currentTimeMillis();
//					System.out.println("b___________________________________________________:" + b + "用时：" + (b -a));
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//				continue;
//			}
//			
//		}
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
//	Test2 t = new Test2();
//	for(int i = 0; i < 1; i++){
//		//client();
//		//t.main("192.168.2.63");
//	}
	//t.main("192.168.2.28");

	//long a = System.currentTimeMillis();
	//String IP = "192.168.2.28";
//	try{
//		HashMap<String, Object> papa = new HashMap<String, Object>();
//		 HashMap<String, Object> infoMap=new HashMap<String, Object>();
//		// new Client(IP, 8008).start();
//		 papa.clear();
//		 infoMap.clear();
//			papa.put("roleid", 6004);
//			papa.put("idsold", 1);
//			infoMap.put("_guid", 0);
//			infoMap.put("_cachekey", "noCachekey");
//			infoMap.put("_sig", "robot");
//			infoMap.put("_serverId", 1);
//			infoMap.put("_pid", 1);
//			infoMap.put("_cmd", "sys.cacheGameRolethree");
//			infoMap.put("_params", papa);
//			infoMap.put("_key1", "1");
//			infoMap.put("_key2", "0000");
//			infoMap.put("_key3", "12");
//			infoMap.put("_key3tang", "12");
////			if(Client.smcHander == null){
////				Thread.sleep(500);
////				if(Client.smcHander == null){
////					Thread.sleep(500);
////					if(Client.smcHander == null){
////						Thread.sleep(500);
////					}
////				}
////			}
//			cm.getClient(3).smcHander.sendData(infoMap);
//			cm2.getClient(1).smcHander.sendData(infoMap);
//			while(true){
//				try{
//					Scanner in = new Scanner(System.in);
//					int i = in.nextInt();
//					if(i == 1){
//						for(int j = 0; j < 3; j++){
//							cm.getClient(666).smcHander.sendData(infoMap);
//							System.out.println("session:" + cm.getClient(3).smcHander.getSession().toString());
//						}
//						
//					}else{
//						for(int j = 0; j < 30; j++){
//							cm2.getClient(1).smcHander.sendData(infoMap);
//							System.out.println("session:" + cm2.getClient(1).smcHander.getSession().toString());
//
//						}
//						
//					}
//				}catch(Exception e){
//					e.printStackTrace();
//					continue;
//				}
//				
//			}
//			//Thread.sleep(30000);
//			//System.out.println("kkkkkkkkkkkkkkkkkkkkkkkk:" + (cm.getClient(1).smcHander==null));
//			//cm.getClient(3).smcHander.sessionClosed(cm.getClient(1).smcHander.getSession());
//			//System.out.println("kkkkkkkkkkkkkkkkkkkkkkkk:" + (cm.getClient(1).smcHander==null));
//	}catch(Exception e){
//		e.printStackTrace();
//	}
//	 HashMap<String, Object> infoMaps=new HashMap<String, Object>();
//	 infoMaps.put("tttttttttttttttt", "ddddddddddddddddddddddddddd");
//	Client.smcHander.sendData(infoMaps);
//	long b = System.currentTimeMillis();
//	System.out.println("用时：" + (b - a));
//	 IP = "192.168.2.64";
//	try{
//		HashMap<String, Object> papa = new HashMap<String, Object>();
//		 HashMap<String, Object> infoMap=new HashMap<String, Object>();
//		 new Client(IP, 8008).start();
//		 papa.clear();
//		 infoMap.clear();
//			papa.put("roleid", 6004);
//			papa.put("idsold", 1);
//			infoMap.put("_guid", 0);
//			infoMap.put("_cachekey", "noCachekey");
//			infoMap.put("_sig", "robot");
//			infoMap.put("_serverId", 1);
//			infoMap.put("_pid", 1);
//			infoMap.put("_cmd", "sys.cacheGameRolethree");
//			infoMap.put("_params", papa);
//			infoMap.put("_key1", "1");
//			infoMap.put("_key2", "0000");
//			infoMap.put("_key3", "12");
//			infoMap.put("_key3tang", "12");
//			if(Client.smcHander == null){
//				Thread.sleep(500);
//				if(Client.smcHander == null){
//					Thread.sleep(500);
//					if(Client.smcHander == null){
//						Thread.sleep(500);
//					}
//				}
//			}
//			Client.smcHander.sendData(infoMap);
//			Client.smcHander.sendData(infoMap);
//			Client.smcHander.sendData(infoMap);
//			Client.smcHander.sessionClosed(Client.smcHander.getSession());
//	}catch(Exception e){
//		e.printStackTrace();
//	}
//	long c = System.currentTimeMillis();
//	System.out.println("用时：" + (c - b));
}
public static String checkStr(String str){
	String s = null;
	char[] cc = str.toCharArray();
	for(int i = 0; i < cc.length; i++){
		boolean b = isValidChar(cc[i]);
		if(!b)
			cc[i] = ' ';
	}
	s = String.valueOf(cc);
	return s;
}

private static boolean isValidChar(char ch) {
    if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')|| (ch >= 'a' && ch <= 'z'))
        return true;
    if ((ch >= 0x4e00 && ch <= 0x7fff) || (ch >= 0x8000 && ch <= 0x952f))
        return true;// 简体中文汉字编码
    return false;
}



public static void log(String msg) {
	log.println(new Date() + ":" + msg);
}


static Client client = null;
static void client(){
	String IP = "192.168.2.28";
	
	if(client==null){
		System.out.println("1");
		client=new Client(IP, 8008);
		System.out.println("1Client:" + (client == null));
		client.start();
	}else{
		System.out.println("2");
		System.out.println("2Client:" + (client == null));
		client.start();
	}
}
}
