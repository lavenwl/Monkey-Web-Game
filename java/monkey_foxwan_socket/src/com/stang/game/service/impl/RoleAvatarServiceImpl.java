package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheRoleAvatar;
import com.stang.game.dao.IRoleAvatarDao;
import com.stang.game.dao.impl.RoleAvatarDaoImpl;
import com.stang.game.entity.detail.RoleAvatarDetail;
import com.stang.game.service.IRoleAvatarService;

public class RoleAvatarServiceImpl extends BaseServiceImpl<RoleAvatarDetail>
		implements IRoleAvatarService {
	private static CacheRoleAvatar cr;
	private static CacheRoleAvatar getCacheRoleAvatar(){
		if(cr == null){
			cr = new CacheRoleAvatar();
		}
		return cr;
	}
	protected IRoleAvatarDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleAvatarDaoImpl();
		}
		return (IRoleAvatarDao) baseDao;
	}

	@Override
	public boolean deleteRoleAvatar(Map<String, Object> param) {
		// TODO Auto-generated method stub
		//return getBaseDao().deleteRoleAvatar(param);
		return this.getCacheRoleAvatar().deleteRoleAvatar(param);
	}

	@Override
	public List<RoleAvatarDetail> getRoleAvatarDetail(Map<String, Object> param) {
		//return getBaseDao().getRoleAvatarDetail(param);
		return this.getCacheRoleAvatar().getRoleAvatarDetail(param);
	}

	@Override
	public boolean insertRoleAvatar(RoleAvatarDetail detail) {
		//return getBaseDao().insertRoleAvatar(detail);
		return this.getCacheRoleAvatar().insertRoleAvatar(detail);
	}

	@Override
	public boolean updateAvatar(Map<String, Object> param) {
		//return getBaseDao().updateAvatar(param);
		return this.getCacheRoleAvatar().updateAvatar(param);
	}

	@Override
	public List<RoleAvatarDetail> findAllRoleAvatar() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleAvatar();
	}

}
