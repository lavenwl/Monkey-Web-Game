package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IActivityDao;
import com.stang.game.dao.impl.ActivityDaoImpl;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.service.IActivityService;

public class ActivityServiceImpl extends BaseServiceImpl<ActivityDetail> implements IActivityService{

	protected IActivityDao getBaseDao(){
		if(baseDao==null){
			baseDao = new ActivityDaoImpl();
		}
		return (IActivityDao) baseDao;
	}
	
	
	public List<ActivityDetail> getActivityByParams(Map<String, Object> param) {
		return getBaseDao().getActivityByParams(param);
	}


	public boolean updateActivityById(Map<String,Object> param) {
		return getBaseDao().updateActivityById(param);
	}

}
