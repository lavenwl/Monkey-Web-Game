package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleImpose;
import com.stang.game.dao.IRoleImposeDao;
import com.stang.game.dao.impl.RoleImposeDaoImpl;
import com.stang.game.entity.detail.RoleImposeDetail;
import com.stang.game.service.IRoleImposeService;

public class RoleImposeServiceImpl extends BaseServiceImpl<RoleImposeDetail>
		implements IRoleImposeService {

	private static CacheRoleImpose cacheRoleImpose = null;
	private static CacheRoleImpose getCacheRoleImpose(){
		if(cacheRoleImpose == null){
			cacheRoleImpose = new CacheRoleImpose();
		}
		return cacheRoleImpose;
	}
	
	protected IRoleImposeDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleImposeDaoImpl();
		}
		return (IRoleImposeDao) baseDao;
	}

	@Override
	public List<RoleImposeDetail> getRoleImposeDetail(Map<String, Object> param) {
		return getCacheRoleImpose().getRoleImposeDetail(param);
//		return getBaseDao().getRoleImposeDetail(param);
	}

	@Override
	public boolean insertRoleImpose(RoleImposeDetail detail) {
		return getCacheRoleImpose().insertRoleImpose(detail);
//		return getBaseDao().insertRoleImpose(detail);
	}

	@Override
	public boolean updateImpose(Map<String, Object> param) {
		return getCacheRoleImpose().updateImpose(param);
//		return getBaseDao().updateImpose(param);
	}

	@Override
	public boolean updateImposeNum() {
		System.out.println("RoleImposeServiceImpl.updateImposeNum执行了没有传参数的方法！！！");
		return getBaseDao().updateImposeNum();
	}

	@Override
	public List<RoleImposeDetail> getRoleImpose(int roleId) {
		return getCacheRoleImpose().getRoleImposeDetail(roleId);
//		return getBaseDao().getRoleImpose(roleId);
	}

	@Override
	public boolean updateImposeIsnew(int isnew) {
		getCacheRoleImpose().updateImposeIsnew(isnew);
		System.out.println("RoleImposeServiceImpl.updateImposeIsnew()方法，数据库与缓存同时更新！");
		return getBaseDao().updateImposeIsnew(isnew);
	}

	@Override
	public List<RoleImposeDetail> findAllRoleImpose() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleImpose();
	}

	@Override
	public void updateImpose(RoleImposeDetail roleImposeDetail) {
		// TODO Auto-generated method stub
		getCacheRoleImpose().updateImpose(roleImposeDetail);
	}

}
