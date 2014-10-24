package com.stang.game.ffd.controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.service.IActivityService;
import com.stang.game.service.impl.ActivityServiceImpl;

public class ActivityListAction extends ActionSupport{

	List<ActivityDetail> activity;
	
	public String execute() throws Exception {
		IActivityService ser = new ActivityServiceImpl();
		activity = ser.getActivityByParams(null);
		if(activity.isEmpty()){
			return "error";
		}
		return SUCCESS;
	}
	
	public List<ActivityDetail> getActivity() {
		return activity;
	}
	public void setActivity(List<ActivityDetail> activity) {
		this.activity = activity;
	}
}
