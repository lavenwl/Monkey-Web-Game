package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleAvatarDao;
import com.stang.game.dao.impl.RoleAvatarDaoImpl;
import com.stang.game.entity.detail.RoleAvatarDetail;
import com.stang.game.service.IRoleAvatarService;

public class RoleAvatarServiceImpl extends BaseServiceImpl<RoleAvatarDetail>
		implements IRoleAvatarService {

	protected IRoleAvatarDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleAvatarDaoImpl();
		}
		return (IRoleAvatarDao) baseDao;
	}

	public boolean deleteRoleAvatar(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().deleteRoleAvatar(param);
	}

	public List<RoleAvatarDetail> getRoleAvatarDetail(Map<String, Object> param) {
		return getBaseDao().getRoleAvatarDetail(param);
	}

	public boolean insertRoleAvatar(RoleAvatarDetail detail) {
		return getBaseDao().insertRoleAvatar(detail);
	}

	public boolean updateAvatar(Map<String, Object> param) {
		return getBaseDao().updateAvatar(param);
	}

}
