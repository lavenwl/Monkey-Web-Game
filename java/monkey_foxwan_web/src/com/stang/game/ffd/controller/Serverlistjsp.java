package com.stang.game.ffd.controller;

import java.util.List;

import com.stang.game.entity.detail.ServerDetail;

import apiinterface.Home;

public class Serverlistjsp {
	List<ServerDetail> serverlist = null;
	public String execute() throws Exception {
		Home home  = new Home();
		serverlist = home.getServerList();
		if(serverlist.size() != 0){
			return "success"; 
		}else{
			return "error";
		}
	}
	public List<ServerDetail> getServerlist() {
		return serverlist;
	}
	public void setServerlist(List<ServerDetail> serverlist) {
		this.serverlist = serverlist;
	}

}
