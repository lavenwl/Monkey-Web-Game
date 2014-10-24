package com.stang.game.ffd.controller;

import java.util.List;

import com.stang.game.entity.detail.HostStatusDetail;
import com.stang.game.service.IBuyService;
import com.stang.game.service.IHostStatusService;
import com.stang.game.service.impl.HostStatusServiceImpl;

public class Geifuwu {
	private static IHostStatusService hostSatatusService=new HostStatusServiceImpl();
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
		List<HostStatusDetail> hoststatus=hostSatatusService.getHostStatus();
		int size=hoststatus.size();
		for(int i=0;i<size;i++){
			int id0=hoststatus.get(i).getId();
			if(id0==1){
				status=hoststatus.get(i).getStatus();
				message=hoststatus.get(i).getMessage();
				id=hoststatus.get(i).getId();
			}
		}
//		status=hoststatus.get(0).getStatus();
//		message=hoststatus.get(0).getMessage();
//		id=hoststatus.get(0).getId();
		// TODO Auto-generated method stub
		//String url = (String) request.getSession().getAttribute("urlTip");
		System.out.println("========转发给gift.jsp=============================================");
//		if(url!=null){
//			System.out.println("login1"+url);
//			response.sendRedirect(url);
//		}
//		System.out.println("login2"+url);
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
