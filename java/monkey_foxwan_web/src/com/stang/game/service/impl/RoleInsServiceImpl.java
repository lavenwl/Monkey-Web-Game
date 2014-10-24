package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleInsDao;
import com.stang.game.dao.impl.RoleInsDaoImpl;
import com.stang.game.entity.detail.RoleInsDetail;
import com.stang.game.service.IRoleInsService;

public class RoleInsServiceImpl extends BaseServiceImpl<RoleInsDetail>
implements IRoleInsService{
	

	protected IRoleInsDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleInsDaoImpl();
		}
		return (IRoleInsDao) baseDao;
	}

	public List<RoleInsDetail> getRoleIns(int roleId) {
		return getBaseDao().getRoleIns(roleId);
	}

	public List<RoleInsDetail> getRoleInsDetail(Map<String, Object> param) {
		return getBaseDao().getRoleInsDetail(param);
	}

	public boolean insertRoleIns(RoleInsDetail detail) {
		return getBaseDao().insertRoleIns(detail);
	}

	public boolean updateIns(Map<String, Object> param) {
		return getBaseDao().updateIns(param);
	}

	public boolean insertRoleInsRat(RoleInsDetail detail) {
		return getBaseDao().insertRoleInsRat(detail);
	}



}
