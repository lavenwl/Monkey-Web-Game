package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.*;
import com.stang.game.cache.CacheGameRole;
import com.stang.game.dao.IActivityDao;
import com.stang.game.dao.impl.ActivityDaoImpl;
import com.stang.game.entity.detail.ActivityDetail;
import com.stang.game.service.IActivityService;

public class ActivityServiceImpl extends BaseServiceImpl<ActivityDetail> implements IActivityService{

	private CacheActivity cacheActivity;
	private CacheActivity getCacheActivity(){
		if(cacheActivity == null){
			cacheActivity = new CacheActivity();
		}
		return cacheActivity;
	}
	
	protected IActivityDao getBaseDao(){
		if(baseDao==null){
			baseDao = new ActivityDaoImpl();
		}
		return (IActivityDao) baseDao;
	}
	
	@Override
	public List<ActivityDetail> getActivityByParams(Map<String, Object> param) {
		return getCacheActivity().getActivityByParams(param);
//		return getBaseDao().getActivityByParams(param);
	}

	@Override
	public List<ActivityDetail> findAllActivity() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllActivity();
	}

}
