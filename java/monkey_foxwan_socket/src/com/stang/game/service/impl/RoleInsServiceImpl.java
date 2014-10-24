package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleIns;
import com.stang.game.dao.IRoleInsDao;
import com.stang.game.dao.impl.RoleInsDaoImpl;
import com.stang.game.entity.detail.RoleInsDetail;
import com.stang.game.service.IRoleInsService;

public class RoleInsServiceImpl extends BaseServiceImpl<RoleInsDetail>
implements IRoleInsService{
	
	private static CacheRoleIns cacheRoleIns = null;
	private static CacheRoleIns getCacheRoleIns(){
		if(cacheRoleIns == null){
			cacheRoleIns = new CacheRoleIns();
		}
		return cacheRoleIns;
	}
	
	protected IRoleInsDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleInsDaoImpl();
		}
		return (IRoleInsDao) baseDao;
	}

	@Override
	public List<RoleInsDetail> getRoleIns(int roleId) {
		return getCacheRoleIns().getRoleIns(roleId);
//		return getBaseDao().getRoleIns(roleId);
	}

	@Override
	public List<RoleInsDetail> getRoleInsDetail(Map<String, Object> param) {
		int roleId = Integer.valueOf(String.valueOf(param.get("roleId")));
		return getCacheRoleIns().getRoleIns(roleId);
//		return getBaseDao().getRoleInsDetail(param);
	}

	@Override
	public boolean insertRoleIns(RoleInsDetail detail) {
		return getCacheRoleIns().insertRoleIns(detail);
//		return getBaseDao().insertRoleIns(detail);
	}

	@Override
	public boolean updateIns(Map<String, Object> param) {
		return getCacheRoleIns().updateIns(param);
//		return getBaseDao().updateIns(param);
	}

	@Override
	public boolean insertRoleInsRat(RoleInsDetail detail) {
		return getCacheRoleIns().insertRoleIns(detail);
//		return getBaseDao().insertRoleInsRat(detail);
	}

	@Override
	public List<RoleInsDetail> findAlloleIns() {
		// TODO Auto-generated method stub
		return getBaseDao().findAlloleIns();
	}

	@Override
	public void updateIns(RoleInsDetail roleInsDetail) {
		// TODO Auto-generated method stub
		getCacheRoleIns().updateIns(roleInsDetail);
	}



}
