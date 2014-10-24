package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.service.IActivityService;
import com.stang.game.service.impl.ActivityServiceImpl;

public class ActivityList2Action extends ActionSupport{

	int id;
	ActivityDetail activity;

	public String execute(){
		IActivityService ser = new ActivityServiceImpl();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		List<ActivityDetail> list = ser.getActivityByParams(param);
		System.out.println("id:"+id);
		if(list.isEmpty()){
			return "error";
		}
		activity = list.get(0);
		System.out.println(list.size());
		System.out.println(activity.getDayend());
		list = null;
		return SUCCESS;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ActivityDetail getActivity() {
		return activity;
	}

	public void setActivity(ActivityDetail activity) {
		this.activity = activity;
	}
	
	
}
