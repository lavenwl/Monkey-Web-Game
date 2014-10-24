package com.stang.game.ffd.client;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;

import buyapi.Send;

public class Test2 {
public static void main(String[] args) {
	
	String s1 = "      👑浪子回头";
	String s2 = "👑";
	String s3 = "" + 
"" +
"👑浪子回头";
	System.out.println("s2.length:" + s2.length());
	System.out.println("s3:" + s3);
	
	SimpleDateFormat sdfb = new SimpleDateFormat("yyyy-MM-dd '00:00:00'");
	SimpleDateFormat sdfe = new SimpleDateFormat("yyyy-MM-dd '23:59:59'");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 'HH:mm:ss'");
	try {
		Date startTimeb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdfb.format(new Date()));
		Date startTimee = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdfe.format(new Date()));
		//System.out.println("starttimeb:" + sdf.parse("1397522418187"));
		long lon = 1397522418187L;
		long lon2 = startTimeb.getTime();
		long lo = lon - lon2;
		
		
		System.out.println("h:" + lo);
		System.out.println("statb:" + startTimeb.getTime());
		System.out.println("state:" + startTimee.getTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	System.out.println("byte:" + Integer.toBinaryString(-10));
	
	//ClientManager cm = ClientManager.getInstance();
//	//cm.getClient(3).smcHander.sendData(infoMap);
	//ClientManager cm2 = ClientManager.getInstance();
//	System.out.println("1:" + cm.getClient(1));
	
//	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//	map.put(1, 1);
//	map.put(2, 2);
//	map.put(3, 3);
//	map.put(4, 4);
//	map.put(5, 5);
//	map.put(6, 6);
//	map.put(7, 7);
//	Map<Integer, Integer> m = map;
//	System.out.println("3:" + m.get(3));
//	map.put(3, 0);
//	System.out.println("3:" + m.get(3));
	
//	String l = "4 sdfasdf";
//	String[] a = l.split(" ");
//	System.out.println("__________________________:" + a[0] + "a");
	
//	Send s = new Send();
//	try {
//		
//		
//		for(int i = 0; i < 100; i++){
//			long a = System.currentTimeMillis();
//			System.out.println("a__________________________________________________:" + a);
//			s.service();
//			long b = System.currentTimeMillis();
//			System.out.println("b___________________________________________________:" + b + "用时：" + (b -a));
//		}
//		
//	
//		
//	} catch (ServletException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	} catch (IOException e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	
	
	
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
