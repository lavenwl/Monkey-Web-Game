package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleBingDetail;

public interface IRoleBingDao extends IEntityDao<RoleBingDetail>{
	public boolean insertRoleBing(RoleBingDetail roleBingDetail);
	public boolean updateRoleBing(RoleBingDetail roleBingDetail);
	public List<RoleBingDetail> findAllRoleBing();
	
	public List<RoleBingDetail> findRoleBingByParams(Map<String,Object> param);
	
	public boolean insertRoleBing(Map<String,Object> param);
	
	public boolean updateRoleBing(Map<String,Object> param);
}
