package com.stang.game.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleMilitary;
import com.stang.game.dao.IRoleMilitaryDao;
import com.stang.game.dao.impl.RoleMilitaryDaoImpl;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.service.IRoleMilitaryService;

public class RoleMilitaryServiceImpl extends
		BaseServiceImpl<RoleMilitaryDetail> implements IRoleMilitaryService {
	
	private static CacheRoleMilitary cacheRoleMilitary = null;
	private static CacheRoleMilitary getCacheRoleMilitary(){
		if(cacheRoleMilitary == null){
			cacheRoleMilitary = new CacheRoleMilitary();
		}
		return cacheRoleMilitary;
	}
	
	protected IRoleMilitaryDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleMilitaryDaoImpl();
		}
		return (IRoleMilitaryDao) baseDao;
	}

	@Override
	public List<RoleMilitaryDetail> getRoleMilitary(int roleId) {
		//避免大循环  
	//	System.out.println("//避免大循环_____________________________________________RoleMilitary.getRoleMilitary:");
		return getCacheRoleMilitary().getRoleMilitary(roleId);
		//return getBaseDao().getRoleMilitary(roleId);
	}

	@Override
	public boolean insertRoleMilitary(Map<String, Object> param) {
		//System.out.println("_____________________________________________RoleMilitary.insertRoleMilitary:");

		return getCacheRoleMilitary().insertRoleMilitary(param);
//		return getBaseDao().insertRoleMilitary(param);
	}

	@Override
	public boolean updateRoleMilitary(Map<String, Object> param) {
		return getCacheRoleMilitary().updateRoleMilitary(param);
//		return getBaseDao().updateRoleMilitary(param);
	}
	@Override
	public boolean updateRoleMilitary(RoleMilitaryDetail detail) {
		return getCacheRoleMilitary().updateRoleMilitary(detail);
//		return getBaseDao().updateRoleMilitary(param);
	}
	
	@Override
	public void updateRoleMilitaryc(RoleMilitaryDetail detail) {
		getCacheRoleMilitary().updateRoleMilitaryc(detail);
//		return getBaseDao().updateRoleMilitary(param);
	}

	@Override
	public List<RoleMilitaryDetail> getRoleMilitarylevel(int id) {
		return getCacheRoleMilitary().getRoleMilitarylevel(id);
//		return getBaseDao().getRoleMilitarylevel(id);
	}

	@Override
	public List<RoleMilitaryDetail> getRoleMilitaryByparam(
			Map<String, Object> param) {
		return getCacheRoleMilitary().getRoleMilitaryByparam(param);
//		return getBaseDao().getRoleMilitaryByparam(param);
	}

	@Override
	public List<RoleMilitaryDetail> getRoleMilitarytime(int id, int roleid) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("militaryid", id);
		param.put("roleId", roleid);
		return getCacheRoleMilitary().getRoleMilitaryByparam(param);
//		return getBaseDao().getRoleMilitarytime(id, roleid);
	}

	@Override
	public boolean updateRoleMilitarytime(Map<String, Object> param) {
		return getCacheRoleMilitary().updateRoleMilitary(param);
//		return getBaseDao().updateRoleMilitarytime(param);
	}

	@Override
	public List<RoleMilitaryDetail> getRoleMilitaryBynotType(
			Map<String, Object> param) {
		return getCacheRoleMilitary().getRoleMilitaryBynotType(param);
//		return getBaseDao().getRoleMilitaryBynotType(param);
	}

	@Override
	public boolean addMilitayExp(Map<String, Object> param) {
		return getCacheRoleMilitary().updateRoleMilitary(param);
//		return getBaseDao().addMilitayExp(param);
	}

	@Override
	public boolean deleteRoleMilitary(Map<String, Object> param) {
		return getCacheRoleMilitary().deleteRoleMilitary(param);
//		return getBaseDao().deleteRoleMilitary(param);
	}

	@Override
	public List<RoleMilitaryDetail> getRoleMilitaryByLevel(Map<String, Object> param) {
		return getCacheRoleMilitary().getRoleMilitaryByLevel(param);
//		return getBaseDao().getRoleMilitaryByLevel(param);
	}

	@Override
	public boolean updateRoleMilitarytwo(Map<String, Object> param) {
		return getCacheRoleMilitary().updateRoleMilitary(param);
//		return getBaseDao().updateRoleMilitarytwo(param);
	}

	@Override
	public List<RoleMilitaryDetail> getRoleMilitarylevel2(
			Map<String, Object> param) {
		return getCacheRoleMilitary().getRoleMilitaryByparam(param);
//		return getBaseDao().getRoleMilitarylevel2(param);
	}

	@Override
	public List<RoleMilitaryDetail> findAllRoleMilitary() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleMilitary();
	}

	@Override
	public void insertRoleMilitary(RoleMilitaryDetail roleMilitaryDetail) {
		// TODO Auto-generated method stub
		getCacheRoleMilitary().insertRoleMilitary(roleMilitaryDetail);
	}

	@Override
	public RoleMilitaryDetail getRoleMilitaryById(int id) {
		// TODO Auto-generated method stub
		return getCacheRoleMilitary().getRoleMilitaryById(id).get(0);
	}
	
	public List<RoleMilitaryDetail> getRoleMilitaryByMilitaryId(int id) {
		// TODO Auto-generated method stub
		return getCacheRoleMilitary().getRoleMilitaryByMilitaryId(id);
	}
}
