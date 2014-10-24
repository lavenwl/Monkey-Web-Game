package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleMilitaryDao;
import com.stang.game.dao.impl.RoleMilitaryDaoImpl;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.service.IRoleMilitaryService;

public class RoleMilitaryServiceImpl extends
		BaseServiceImpl<RoleMilitaryDetail> implements IRoleMilitaryService {
	protected IRoleMilitaryDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleMilitaryDaoImpl();
		}
		return (IRoleMilitaryDao) baseDao;
	}

	public List<RoleMilitaryDetail> getRoleMilitary(int roleId) {
		return getBaseDao().getRoleMilitary(roleId);
	}

	public boolean insertRoleMilitary(Map<String, Object> param) {
		return getBaseDao().insertRoleMilitary(param);
	}

	public boolean updateRoleMilitary(Map<String, Object> param) {
		return getBaseDao().updateRoleMilitary(param);
	}

	public List<RoleMilitaryDetail> getRoleMilitarylevel(int id) {
		return getBaseDao().getRoleMilitarylevel(id);
	}

	public List<RoleMilitaryDetail> getRoleMilitaryByparam(
			Map<String, Object> param) {
		return getBaseDao().getRoleMilitaryByparam(param);
	}

	public List<RoleMilitaryDetail> getRoleMilitarytime(int id, int roleid) {
		return getBaseDao().getRoleMilitarytime(id, roleid);
	}

	public boolean updateRoleMilitarytime(Map<String, Object> param) {
		return getBaseDao().updateRoleMilitarytime(param);
	}

	public List<RoleMilitaryDetail> getRoleMilitaryBynotType(
			Map<String, Object> param) {
		return getBaseDao().getRoleMilitaryBynotType(param);
	}

	public boolean addMilitayExp(Map<String, Object> param) {
		return getBaseDao().addMilitayExp(param);
	}

	public boolean deleteRoleMilitary(Map<String, Object> param) {
		return getBaseDao().deleteRoleMilitary(param);
	}

	public List<RoleMilitaryDetail> getRoleMilitaryByLevel(Map<String, Object> param) {
		return getBaseDao().getRoleMilitaryByLevel(param);
	}
}
