package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleDaytaskDetail;
public interface IRoleDaytaskService extends IBaseService<RoleDaytaskDetail>{
	public boolean updateRoleDaytask(Map<String, Object> param);
	public boolean updateRoleDaytaskzm(Map<String, Object> param);
	public RoleDaytaskDetail findRoleDaytaskByRId(int id);
	public boolean insertRoleDaytask(Map<String, Object> param);
	
	public List<RoleDaytaskDetail> findAllRoleDayTask();
	public void updateRoleDaytask(RoleDaytaskDetail roleDaytaskDetail);
	public void insertRoleDaytask(RoleDaytaskDetail roleDaytaskDetail);

}
