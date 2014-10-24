package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;

import com.stang.game.entity.detail.ServerDetail;
import com.stang.game.ffd.client.ClientManager;
import com.stang.game.service.impl.ServerServiceImpl;

import apiinterface.Home;

public class Serverlist2Action {
	ServerDetail server = new ServerDetail();
	int id;
	String name;
	int statue_mag;
	int statue_tui;
	int statue_xin;
	int statue_on;
	public ServerDetail getServer() {
		return server;
	}
	public void setServer(ServerDetail server) {
		this.server = server;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatue_mag() {
		return statue_mag;
	}
	public void setStatue_mag(int statue_mag) {
		this.statue_mag = statue_mag;
	}
	public int getStatue_tui() {
		return statue_tui;
	}
	public void setStatue_tui(int statue_tui) {
		this.statue_tui = statue_tui;
	}
	public int getStatue_xin() {
		return statue_xin;
	}
	public void setStatue_xin(int statue_xin) {
		this.statue_xin = statue_xin;
	}
	public int getStatue_on() {
		return statue_on;
	}
	public void setStatue_on(int statue_on) {
		this.statue_on = statue_on;
	}
	List<ServerDetail> serverlist = null;
	public String execute() throws Exception {
		boolean update = false;
		Home home  = new Home();
		serverlist = home.getServerList();
		for(int j = 0; j < serverlist.size(); j++){
			if(serverlist.get(j).getId() == id && serverlist.get(j).getStatue_on() == 1 && statue_on == 0){
				update = true;
			}
		}
		if(update){
			HashMap<String, Object> papa = new HashMap<String, Object>();
			HashMap<String, Object> infoMap=new HashMap<String, Object>();
			infoMap.put("_guid", 0);
			infoMap.put("_cachekey", "noCachekey");
			infoMap.put("_sig", "robot");
			infoMap.put("_serverId", 1);
			infoMap.put("_pid", 1);
			infoMap.put("_cmd", "sys.shutdown");
			infoMap.put("_params", papa);
			infoMap.put("_key1", "1");
			infoMap.put("_key2", "0000");
			infoMap.put("_key3", "12");
			infoMap.put("_key3tang", "12");
			ClientManager cm = ClientManager.getInstance();
			cm.getClient(id).smcHander.sendData(infoMap);
		}
		
		server.setId(id);
		server.setName(name);
		server.setStatue_mag(statue_mag);
		server.setStatue_tui(statue_tui);
		server.setStatue_xin(statue_xin);
		server.setStatue_on(statue_on);
		boolean a = home.updateServer(server);
		if(a){
			return "success";
		}else{
			return "false";
		}
			
		
	}
	
}
