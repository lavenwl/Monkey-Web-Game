package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleChallengeDetail;

public interface IRoleChallengeService extends IBaseService<RoleChallengeDetail>{

	public boolean insertRoleChallenge(Map<String,Object> param);
	
	public boolean updateRoleChallenge(Map<String,Object> param);
	
	public List<RoleChallengeDetail> findRoleChallengeById(Map<String,Object> param);
	
}
