package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.ActivityDetail;

public interface IActivityService extends IBaseService<ActivityDetail>{

	public List<ActivityDetail> getActivityByParams(Map<String,Object> param);
	
	public boolean updateActivityById(Map<String,Object> param);
}
