package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleBing;
import com.stang.game.dao.IRoleBingDao;
import com.stang.game.dao.impl.RoleBingDaoImpl;
import com.stang.game.entity.detail.RoleBingDetail;
import com.stang.game.service.IRoleBingService;

public class RoleBingServiceImpl extends BaseServiceImpl<RoleBingDetail> implements IRoleBingService{

	private static CacheRoleBing cacheRoleBing = null;
	private static CacheRoleBing getCacheRoleBing(){
		if(cacheRoleBing == null){
			cacheRoleBing = new CacheRoleBing();
		}
		return cacheRoleBing;
	}
	
	protected IRoleBingDao getBaseDao(){
		if(baseDao==null){
			baseDao = new RoleBingDaoImpl();
		}
		return (IRoleBingDao) baseDao;
	}
	
	@Override
	public List<RoleBingDetail> findRoleBingByParams(Map<String, Object> param) {
		//return getCacheRoleBing().findRoleBingByParams(param);
		return getBaseDao().findRoleBingByParams(param);
	}

	@Override
	public boolean insertRoleBing(Map<String, Object> param) {
		//return getCacheRoleBing().insertRoleBing(param);
		return getBaseDao().insertRoleBing(param);
	}

	@Override
	public boolean updateRoleBing(Map<String, Object> param) {
		//return getCacheRoleBing().updateRoleBing(param);
		return getBaseDao().updateRoleBing(param);
	}

	@Override
	public List<RoleBingDetail> findAllRoleBing() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleBing();
	}

	@Override
	public List<RoleBingDetail> findRoleBingByParam(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getCacheRoleBing().findRoleBingByParams(param);
	}

}
