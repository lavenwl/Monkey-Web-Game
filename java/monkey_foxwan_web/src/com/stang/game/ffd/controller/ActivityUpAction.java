package com.stang.game.ffd.controller;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.service.IActivityService;
import com.stang.game.service.impl.ActivityServiceImpl;

public class ActivityUpAction extends ActionSupport{

	ActivityDetail activity;
	
	public String execute() throws Exception {
		System.out.println(activity.getDayend());
		if(activity!=null){
			System.out.println(">>>>>");
			System.out.println(activity.getId());
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("id", activity.getId());
			param.put("url", activity.getUrl());
			param.put("type", activity.getType());
			param.put("conditions", activity.getConditions());
			param.put("reward", activity.getReward());
			param.put("flag", activity.getFlag());
			param.put("month", activity.getMonth());
			param.put("monthend", activity.getMonthend());
			param.put("day", activity.getDay());
			param.put("dayend", activity.getDayend());
			param.put("description", activity.getDescription());
			param.put("tipurl", activity.getTipurl());
			param.put("isnew", activity.getIsnew());
			
			IActivityService ser = new ActivityServiceImpl();
			boolean bo = ser.updateActivityById(param);
			System.out.println(bo);
			param = null;
		}else{
			return "error";
		}
		return SUCCESS;
	}
	
	public ActivityDetail getActivity() {
		return activity;
	}
	public void setActivity(ActivityDetail activity) {
		this.activity = activity;
	}
}
