package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleQuicktime;
import com.stang.game.dao.IRoleQuicktimeDao;
import com.stang.game.dao.impl.RoleQuicktimeDaoImpl;
import com.stang.game.entity.detail.RoleQuicktimeDetail;
import com.stang.game.service.IRoleQuicktimeService;

public class RoleQuicktimeServiceImpl extends BaseServiceImpl<RoleQuicktimeDetail>
implements IRoleQuicktimeService {
	 
	private static CacheRoleQuicktime cacheRoleQuicktime = null;
	private static CacheRoleQuicktime getCacheRoleQuicktime(){
		if(cacheRoleQuicktime == null){
			cacheRoleQuicktime = new CacheRoleQuicktime();
		}
		return cacheRoleQuicktime;
	}
	
	protected IRoleQuicktimeDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleQuicktimeDaoImpl();
		}
		return (IRoleQuicktimeDao) baseDao;
	}

	@Override
	public List<RoleQuicktimeDetail> getQuicktime(Map<String, Object> param) {
		return getCacheRoleQuicktime().getQuicktime(param);
//		return getBaseDao().getQuicktime(param);
	}

	@Override
	public boolean updateQuicktime(Map<String, Object> param) {
		return getCacheRoleQuicktime().udpateQuicktime(param);
//		return getBaseDao().updateQuicktime(param);
	}

	@Override
	public boolean insertRolequicktime(RoleQuicktimeDetail detail) {
		return getCacheRoleQuicktime().insertRolequicktime(detail);
//		return getBaseDao().insertRolequicktime(detail);
	}

	@Override
	public List<RoleQuicktimeDetail> findAllRolequicktime() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRolequicktime();
		
	}

	@Override
	public void updateQuicktime(RoleQuicktimeDetail roleQuicktimeDetail) {
		// TODO Auto-generated method stub
		getCacheRoleQuicktime().udpateQuicktime(roleQuicktimeDetail);
	}

}
