package com.stang.game.ffd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import apiinterface.Home;

import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;

public class MessageActiontwo {
	private String[] serverids;
	public String[] getServerids() {
		return serverids;
	}
	public void setServerids(String[] serverids) {
		this.serverids = serverids;
	}
	public String execute(){
		try{
			for(int i = 0; i < serverids.length; i++){
				int id = Integer.valueOf(serverids[i].split(" ")[0]);
				//System.out.println("MessageAction.id:" + id);
				//String IP = getServerIp(id);
				//System.out.println("MessageAction.IP:" + IP);
				//new Client(IP, 8008).start();
				HashMap<String, Object> papa = new HashMap<String, Object>();
				HashMap<String, Object> infoMap=new HashMap<String, Object>();
				infoMap.put("_guid", 0);
				infoMap.put("_cachekey", "noCachekey");
				infoMap.put("_sig", "robot");
				infoMap.put("_serverId", 1);
				infoMap.put("_pid", 1);
				infoMap.put("_cmd", "sys.clrcache");
				infoMap.put("_params", papa);
				infoMap.put("_key1", "1");
				infoMap.put("_key2", "0000");
				infoMap.put("_key3", "12");
				infoMap.put("_key3tang", "12");
				ClientManager cm = ClientManager.getInstance();
				cm.getClient(id).smcHander.sendData(infoMap);
			}
			return "succt";
		}catch(Exception e) {
			e.printStackTrace();
			return "errort";
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
