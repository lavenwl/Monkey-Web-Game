package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.HostStatusDetail;
import com.stang.game.service.IHostStatusService;
import com.stang.game.service.impl.HostStatusServiceImpl;
import com.sun.mail.imap.protocol.Status;

public class UpdateFuwu {

	private static IHostStatusService hostSatatusService=new HostStatusServiceImpl();
	Map<String,Object> param = new HashMap<String,Object>();
	int status;
	String message;
	int id;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String execute() throws Exception {
		System.out.println(id+"=====id号======="+status+"======status状态======="+message);
		param.put("status",status);
		param.put("message",message);
		param.put("id",id);
		hostSatatusService.updateHostStatus(param);
		//List<HostStatusDetail> hoststatus=hostSatatusService.getHostStatus();
	System.out.println("========更新开停服状态成功=============================================");
	
		return "success";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



}
