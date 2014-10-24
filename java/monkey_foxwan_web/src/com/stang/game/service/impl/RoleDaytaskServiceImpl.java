package com.stang.game.service.impl;

import java.util.Map;

import com.stang.game.dao.IGameRoleDao;
import com.stang.game.dao.IRoleDaytaskDao;
import com.stang.game.dao.impl.RoleDaytaskDaoImpl;

import com.stang.game.entity.detail.RoleDaytaskDetail;
import com.stang.game.service.IRoleDaytaskService;



public class RoleDaytaskServiceImpl  extends BaseServiceImpl<RoleDaytaskDetail>
implements IRoleDaytaskService {
	protected IRoleDaytaskDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleDaytaskDaoImpl();
		}
		return (IRoleDaytaskDao) baseDao;
	}

	public RoleDaytaskDetail findRoleDaytaskByRId(int id) {
		return getBaseDao().findRoleDaytaskByRId(id);
		}

	public boolean updateRoleDaytask(Map<String, Object> param) {
		return getBaseDao().updateRoleDaytask(param);
	}

	public boolean insertRoleDaytask(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().insertRoleDaytask(param);
	}

}
