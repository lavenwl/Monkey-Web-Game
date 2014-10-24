package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleBingDetail;

public interface IRoleBingService extends IBaseService<RoleBingDetail>{
	public List<RoleBingDetail> findAllRoleBing();
	public List<RoleBingDetail> findRoleBingByParams(Map<String,Object> param);
	
	public boolean insertRoleBing(Map<String,Object> param);
	
	public boolean updateRoleBing(Map<String,Object> param);
	public List<RoleBingDetail> findRoleBingByParam(Map<String, Object> param);
}
