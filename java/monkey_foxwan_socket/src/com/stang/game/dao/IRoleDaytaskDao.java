package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleDaytaskDetail;



public interface IRoleDaytaskDao extends IEntityDao<RoleDaytaskDetail> {
	public boolean updateRoleDaytask(RoleDaytaskDetail roleDaytaskDetail);
	public boolean insertRoleDaytask(RoleDaytaskDetail roleDaytaskDetail);
	public List<RoleDaytaskDetail> findAllRoleDayTask();
	public boolean updateRoleDaytask(Map<String, Object> param);
	public boolean updateRoleDaytaskzm(Map<String, Object> param);
	public RoleDaytaskDetail findRoleDaytaskByRId(int id);
	public boolean insertRoleDaytask(Map<String, Object> param);

}
