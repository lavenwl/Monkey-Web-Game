package com.stang.game.ffd.controller;

import java.util.List;

import com.stang.game.entity.detail.SendgiftlogDetail;
import com.stang.game.service.SendgiftlogService;
import com.stang.game.service.impl.SendgiftlogServiceImpl;

public class LogrecordAction {
	
	
	private static SendgiftlogService sendgiftlogservice=new SendgiftlogServiceImpl();
	List<SendgiftlogDetail>	lg;


	public List<SendgiftlogDetail> getLg() {
		return lg;
	}


	public void setLg(List<SendgiftlogDetail> lg) {
		this.lg = lg;
	}


	public String execute() throws Exception {
		
	lg=sendgiftlogservice.getAllsfg();
		return "success";
	}



}
