package com.stang.game.ffd.controller;

import java.util.List;

import com.stang.game.entity.detail.ServerDetail;

import apiinterface.Home;

public class AddServer {
	ServerDetail server = new ServerDetail();
	public String execute() throws Exception {
		server.setName("");
		server.setStatue_mag(3);
		server.setStatue_on(1);
		server.setStatue_tui(1);
		server.setStatue_xin(1);
		System.out.println("AddServer");
			return "success"; 
	}
	public ServerDetail getServer() {
		return server;
	}
	public void setServer(ServerDetail server) {
		this.server = server;
	}
	

}
