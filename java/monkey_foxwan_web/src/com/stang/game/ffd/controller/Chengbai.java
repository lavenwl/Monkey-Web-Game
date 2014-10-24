package com.stang.game.ffd.controller;

import java.util.HashMap;

import com.stang.game.ffd.client.Client;

public class Chengbai {
	public void chenggong(String message,String href){
		new Client("localhost", 8008).start();
		HashMap<String, Object> papa = new HashMap<String, Object>();
		 HashMap<String, Object> infoMap=new HashMap<String, Object>();
		papa.put("msg", message);
		papa.put("href", href);
		infoMap.put("_guid", 0);
		infoMap.put("_cachekey", "noCachekey");
		infoMap.put("_sig", "robot");
		infoMap.put("_serverId", 1);
		infoMap.put("_pid", 1);
		infoMap.put("_cmd", "xiu.systemMessage");
		infoMap.put("_params", papa);
		
		
		System.out.println(papa.get("msg")+"=======infoMes=========="+infoMap.get("href"));
		System.out.println(infoMap);
		System.out.println("================111=========================");
		//Client.smcHander.sendData(infoMap);
		System.out.println("===============2111=========================");
	}

}
