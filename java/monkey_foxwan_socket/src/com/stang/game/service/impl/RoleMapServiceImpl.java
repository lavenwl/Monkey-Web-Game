package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleMap;
import com.stang.game.dao.IRoleMapDao;
import com.stang.game.dao.impl.RoleMapDaoImpl;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.service.IRoleMapService;

public class RoleMapServiceImpl extends BaseServiceImpl<RoleMapDetail>
		implements IRoleMapService {
	
	private static CacheRoleMap cacheRoleMap = null;
	private static CacheRoleMap getCacheRoleMap(){
		if(cacheRoleMap == null){
			cacheRoleMap = new CacheRoleMap();
		}
		return cacheRoleMap;
	}
	
	protected IRoleMapDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleMapDaoImpl();
		}
		return (IRoleMapDao) baseDao;
	}

	@Override
	public List<RoleMapDetail> getRoleMap(int roleId) {
		return getCacheRoleMap().getRoleMap(roleId);
//		return getBaseDao().getRoleMap(roleId);
	}

	@Override
	public boolean insertRoleMap(Map<String, Object> param) {
		return getCacheRoleMap().insertRoleMap(param);
//		return getBaseDao().insertRoleMap(param);
	}

	@Override
	public boolean updateRoleMap(Map<String, Object> param) {
		return getCacheRoleMap().updateRoleMap(param);
//		return getBaseDao().updateRoleMap(param);
	}

	@Override
	public List<RoleMapDetail> getRoleMapByParam(Map<String, Object> param) {
		//避免大循环  
		return getCacheRoleMap().getRoleMapByParam(param);
		//System.out.println("	return getBaseDao().getRoleMapByParam(param);param:" + param.toString());
		//return getBaseDao().getRoleMapByParam(param);
	}

	@Override
	public List<RoleMapDetail> getRoleMapByMapPlace(Map<String, Object> param) {
		return getCacheRoleMap().getRoleMapByParam(param);
//		return getBaseDao().getRoleMapByMapPlace(param);
	}

	@Override
	public List<RoleMapDetail> findAllRoleMap() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleMap();
	}

	@Override
	public void updateMap(RoleMapDetail roleMapDetail) {
		// TODO Auto-generated method stub
		getCacheRoleMap().updateRoleMap(roleMapDetail);
	}

}
