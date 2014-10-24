package com.stang.game.ffd.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import apiinterface.Home;

import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.ffd.client.Client;
import com.stang.game.ffd.client.ClientManager;
import com.stang.game.ffd.common.Config;
import com.stang.game.ffd.common.GameConstants;
import com.stang.game.ffd.common.StringUtil;
import com.stang.game.ffd.entity.detail.MessageManagerDetail;
import com.stang.game.service.impl.ServerServiceImpl;

public class MessageAction{
	private String message;
	private String href;
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	private String[] serverids;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String[] getServerids() {
		return serverids;
	}
	public void setServerids(String[] serverids) {
		this.serverids = serverids;
	}
	public String execute() {
		if (message == null) {
			return "success";
		}else{
			
			try{
				for(int i = 0; i < serverids.length; i++){
					int id = Integer.valueOf(serverids[i].split(" ")[0]);
					//System.out.println("MessageAction.id:" + id);
					//String IP = getServerIp(id);
					//System.out.println("MessageAction.IP:" + IP);
					//new Client(IP, 8008).start();
					HashMap<String, Object> papa = new HashMap<String, Object>();
					HashMap<String, Object> infoMap=new HashMap<String, Object>();
					papa.put("mess", message);
					papa.put("url", href);
					infoMap.put("_guid", 0);
					infoMap.put("_cachekey", "noCachekey");
					infoMap.put("_sig", "robot");
					infoMap.put("_serverId", 1);
					infoMap.put("_pid", 1);
					infoMap.put("_cmd", "sys.message");
					infoMap.put("_params", papa);
					infoMap.put("_key1", "1");
					infoMap.put("_key2", "0000");
					infoMap.put("_key3", "12");
					infoMap.put("_key3tang", "12");
					ClientManager cm = ClientManager.getInstance();
					cm.getClient(id).smcHander.sendData(infoMap);
				}
				return "succ";
			}catch(Exception e) {
				e.printStackTrace();
				return "error";
			}
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


