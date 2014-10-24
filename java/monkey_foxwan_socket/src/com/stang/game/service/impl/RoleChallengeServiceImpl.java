package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheRoleChallenge;
import com.stang.game.dao.IRoleChallengeDao;
import com.stang.game.dao.impl.RoleChallengeDaoImpl;
import com.stang.game.entity.detail.RoleChallengeDetail;
import com.stang.game.service.IRoleChallengeService;

public class RoleChallengeServiceImpl extends BaseServiceImpl<RoleChallengeDetail> implements IRoleChallengeService{

	private CacheRoleChallenge cacheRoleChallenge = null;
	private CacheRoleChallenge getCacheRoleChallenge(){
		if(cacheRoleChallenge == null){
			cacheRoleChallenge = new CacheRoleChallenge();
		}
		return cacheRoleChallenge;
	}
	
	protected IRoleChallengeDao getBaseDao(){
		if(baseDao == null){
			baseDao = new RoleChallengeDaoImpl();
		}
		return (IRoleChallengeDao) baseDao;
	}
	
	@Override
	public boolean insertRoleChallenge(Map<String, Object> param) {
		return getCacheRoleChallenge().insertRoleChallenge(param);
//		return getBaseDao().insertRoleChallenge(param);
	}

	@Override
	public boolean updateRoleChallenge(Map<String, Object> param) {
		return getCacheRoleChallenge().updateRoleChallenge(param);
//		return getBaseDao().updateRoleChallenge(param);
	}
	@Override
	public void updateroleChallenge(RoleChallengeDetail detail) {
		getCacheRoleChallenge().updateRoleChallenge(detail);
//		return getBaseDao().updateRoleChallenge(param);
	}
	
	@Override
	public List<RoleChallengeDetail> findRoleChallengeById(Map<String, Object> param) {
		return getCacheRoleChallenge().findRoleChallengeById(param);
//		return getBaseDao().findRoleChallengeById(param);
	}

	@Override
	public List<RoleChallengeDetail> findRoleChallengeById2(Map<String, Object> param) {
		return getCacheRoleChallenge().findRoleChallengeById(param);
//		return getBaseDao().findRoleChallengeById2(param);
	}

	@Override
	public List<RoleChallengeDetail> findAllRoleChallenge() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleChallenge();
	}

	
	
}
