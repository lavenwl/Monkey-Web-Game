package com.stang.game.ffd.controller;

import java.util.List;

import com.stang.game.entity.detail.ServerDetail;

import apiinterface.Home;

public class AddServer2 {
	ServerDetail server = new ServerDetail();
	public String execute() throws Exception {
		Home home = new Home();
		boolean a = home.addServer(server);
		System.out.println("AddServer2");
		if(a){
			return "success";
		}else{
			return "false";
		}
			 
	}
	public ServerDetail getServer() {
		return server;
	}
	public void setServer(ServerDetail server) {
		this.server = server;
	}
	

}
