package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleImposeDao;
import com.stang.game.dao.impl.RoleImposeDaoImpl;
import com.stang.game.entity.detail.RoleImposeDetail;
import com.stang.game.service.IRoleImposeService;

public class RoleImposeServiceImpl extends BaseServiceImpl<RoleImposeDetail>
		implements IRoleImposeService {

	protected IRoleImposeDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleImposeDaoImpl();
		}
		return (IRoleImposeDao) baseDao;
	}

	public List<RoleImposeDetail> getRoleImposeDetail(Map<String, Object> param) {
		return getBaseDao().getRoleImposeDetail(param);
	}

	public boolean insertRoleImpose(RoleImposeDetail detail) {
		return getBaseDao().insertRoleImpose(detail);
	}

	public boolean updateImpose(Map<String, Object> param) {
		return getBaseDao().updateImpose(param);
	}

	public boolean updateImposeNum() {
		return getBaseDao().updateImposeNum();
	}

	public List<RoleImposeDetail> getRoleImpose(int roleId) {
		return getBaseDao().getRoleImpose(roleId);
	}

	public boolean updateImposeIsnew(int isnew) {
		return getBaseDao().updateImposeIsnew(isnew);
	}

}
