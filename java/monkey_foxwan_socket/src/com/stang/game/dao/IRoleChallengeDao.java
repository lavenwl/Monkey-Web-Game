package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleChallengeDetail;

public interface IRoleChallengeDao extends IEntityDao<RoleChallengeDetail>{
	public List<RoleChallengeDetail> findAllRoleChallenge();
	public boolean insertRoleChallenge(RoleChallengeDetail model);
	public boolean insertRoleChallenge(Map<String,Object> param);	
	public boolean updateRoleChallenge(RoleChallengeDetail model);
	public boolean updateRoleChallenge(Map<String,Object> param);
	
	public List<RoleChallengeDetail> findRoleChallengeById(Map<String,Object> param);
	public List<RoleChallengeDetail> findRoleChallengeById2(Map<String,Object> param);
	
}
