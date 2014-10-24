package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleChallengeDao;
import com.stang.game.dao.impl.RoleChallengeDaoImpl;
import com.stang.game.entity.detail.RoleChallengeDetail;
import com.stang.game.service.IRoleChallengeService;

public class RoleChallengeServiceImpl extends BaseServiceImpl<RoleChallengeDetail> implements IRoleChallengeService{

	protected IRoleChallengeDao getBaseDao(){
		if(baseDao == null){
			baseDao = new RoleChallengeDaoImpl();
		}
		return (IRoleChallengeDao) baseDao;
	}
	
	public boolean insertRoleChallenge(Map<String, Object> param) {
		return getBaseDao().insertRoleChallenge(param);
	}

	public boolean updateRoleChallenge(Map<String, Object> param) {
		return getBaseDao().updateRoleChallenge(param);
	}

	public List<RoleChallengeDetail> findRoleChallengeById(
			Map<String, Object> param) {
		return getBaseDao().findRoleChallengeById(param);
	}

}
