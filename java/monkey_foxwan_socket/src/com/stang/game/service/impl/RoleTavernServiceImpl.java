package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheRoleTarven;
import com.stang.game.dao.IRoleTavernDao;
import com.stang.game.dao.impl.RoleTavernDaoImpl;
import com.stang.game.entity.detail.RoleTavernDetail;
import com.stang.game.service.IRoleTavernService;

public class RoleTavernServiceImpl extends BaseServiceImpl<RoleTavernDetail>
		implements IRoleTavernService {
	private static CacheRoleTarven c;
	private static CacheRoleTarven getCacheRoleTarven(){
		if(c == null){
			c = new CacheRoleTarven();
		}
		return c;
	}
	protected IRoleTavernDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleTavernDaoImpl();
		}
		return (IRoleTavernDao) baseDao;
	}

	@Override
	public List<RoleTavernDetail> getRoleTavern(int roleId) {
		return this.getCacheRoleTarven().getRoleTavern(roleId);

		//return getBaseDao().getRoleTavern(roleId);
	}

	@Override
	public boolean insertRoleTavern(Map<String, Object> param) {
	//	System.out.println("___________RoleTavernServiceImpl.insertRoleTavern():______param:" + param.toString());
		return this.getCacheRoleTarven().insertRoleTavern(param);

		//return getBaseDao().insertRoleTavern(param);
	}

	@Override
	public boolean updateRoleTavern(Map<String, Object> param) {
		return this.getCacheRoleTarven().updateRoleTavern(param);

		//return getBaseDao().updateRoleTavern(param);
	}

	@Override
	public List<RoleTavernDetail> findAllRoleTavern() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleTavern();
	}
	@Override
	public void insertRoleTarven(RoleTavernDetail roleTavernDetail) {
		// TODO Auto-generated method stub
		this.getCacheRoleTarven().insertRoleTavern(roleTavernDetail);
	}
	@Override
	public void updateRoleTarven(RoleTavernDetail roleTavernDetail) {
		// TODO Auto-generated method stub
		this.getCacheRoleTarven().updateRoleTavern(roleTavernDetail);
	}

}
