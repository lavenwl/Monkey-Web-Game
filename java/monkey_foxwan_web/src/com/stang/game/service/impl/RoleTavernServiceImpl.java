package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleTavernDao;
import com.stang.game.dao.impl.RoleTavernDaoImpl;
import com.stang.game.entity.detail.RoleTavernDetail;
import com.stang.game.service.IRoleTavernService;

public class RoleTavernServiceImpl extends BaseServiceImpl<RoleTavernDetail>
		implements IRoleTavernService {
	protected IRoleTavernDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleTavernDaoImpl();
		}
		return (IRoleTavernDao) baseDao;
	}

	public List<RoleTavernDetail> getRoleTavern(int roleId) {
		return getBaseDao().getRoleTavern(roleId);
	}

	public boolean insertRoleTavern(Map<String, Object> param) {
		return getBaseDao().insertRoleTavern(param);
	}

	public boolean updateRoleTavern(Map<String, Object> param) {
		return getBaseDao().updateRoleTavern(param);
	}

}
