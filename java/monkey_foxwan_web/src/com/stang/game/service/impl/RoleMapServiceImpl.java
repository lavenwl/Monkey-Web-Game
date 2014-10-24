package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleMapDao;
import com.stang.game.dao.impl.RoleMapDaoImpl;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.service.IRoleMapService;

public class RoleMapServiceImpl extends BaseServiceImpl<RoleMapDetail>
		implements IRoleMapService {
	protected IRoleMapDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleMapDaoImpl();
		}
		return (IRoleMapDao) baseDao;
	}

	public List<RoleMapDetail> getRoleMap(int roleId) {
		return getBaseDao().getRoleMap(roleId);
	}

	public boolean insertRoleMap(Map<String, Object> param) {
		return getBaseDao().insertRoleMap(param);
	}

	public boolean updateRoleMap(Map<String, Object> param) {
		return getBaseDao().updateRoleMap(param);
	}

	public List<RoleMapDetail> getRoleMapByParam(Map<String, Object> param) {
		return getBaseDao().getRoleMapByParam(param);
	}

	public List<RoleMapDetail> getRoleMapByMapPlace(Map<String, Object> param) {
		return getBaseDao().getRoleMapByMapPlace(param);
	}

}
