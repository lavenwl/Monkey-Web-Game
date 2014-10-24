package com.stang.game.dao;

import java.util.Map;

import com.stang.game.entity.detail.RoleDaytaskDetail;



public interface IRoleDaytaskDao extends IEntityDao<RoleDaytaskDetail> {
	public boolean updateRoleDaytask(Map<String, Object> param);
	public RoleDaytaskDetail findRoleDaytaskByRId(int id);
	public boolean insertRoleDaytask(Map<String, Object> param);

}
