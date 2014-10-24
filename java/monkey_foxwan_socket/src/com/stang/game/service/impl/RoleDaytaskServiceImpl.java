package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleDaytask;
import com.stang.game.dao.IGameRoleDao;
import com.stang.game.dao.IRoleDaytaskDao;
import com.stang.game.dao.impl.RoleDaytaskDaoImpl;

import com.stang.game.entity.detail.RoleDaytaskDetail;
import com.stang.game.service.IRoleDaytaskService;



public class RoleDaytaskServiceImpl  extends BaseServiceImpl<RoleDaytaskDetail>
implements IRoleDaytaskService {
	
	private static CacheRoleDaytask cacheRoleDaytask = null;
	private static CacheRoleDaytask getCacheRoleDaytask(){
		if(cacheRoleDaytask == null){
			cacheRoleDaytask = new CacheRoleDaytask();
		}
		return cacheRoleDaytask;
	}
	
	protected IRoleDaytaskDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleDaytaskDaoImpl();
		}
		return (IRoleDaytaskDao) baseDao;
	}

	@Override
	public RoleDaytaskDetail findRoleDaytaskByRId(int id) {
		return getCacheRoleDaytask().findRoleDaytaskByRId(id);
//		return getBaseDao().findRoleDaytaskByRId(id);
		}

	@Override
	public boolean updateRoleDaytask(Map<String, Object> param) {
		return getCacheRoleDaytask().udpateRoleDaytask(param);
//		return getBaseDao().updateRoleDaytask(param);
	}
	
	@Override
	public boolean updateRoleDaytaskzm(Map<String, Object> param) {
		return getCacheRoleDaytask().udpateRoleDaytask(param);
//		return getBaseDao().updateRoleDaytask(param);
	}

	@Override
	public boolean insertRoleDaytask(Map<String, Object> param) {
		return getCacheRoleDaytask().insertRoleDaytask(param);
//		return getBaseDao().insertRoleDaytask(param);
	}

	@Override
	public List<RoleDaytaskDetail> findAllRoleDayTask() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleDayTask();
	}

	@Override
	public void updateRoleDaytask(RoleDaytaskDetail roleDaytaskDetail) {
		// TODO Auto-generated method stub
		getCacheRoleDaytask().updateRoleDaytask(roleDaytaskDetail);
	}

	@Override
	public void insertRoleDaytask(RoleDaytaskDetail roleDaytaskDetail) {
		// TODO Auto-generated method stub
		getCacheRoleDaytask().insertRoleDaytask(roleDaytaskDetail);
	}

}
