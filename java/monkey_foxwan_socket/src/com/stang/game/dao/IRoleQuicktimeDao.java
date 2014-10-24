package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleImposeDetail;
import com.stang.game.entity.detail.RoleQuicktimeDetail;

public interface IRoleQuicktimeDao extends IEntityDao<RoleQuicktimeDetail>{
	public boolean updateRoleQuicktime(RoleQuicktimeDetail roleQuicktimeDetail);
	public boolean insertRoleQuicktime(RoleQuicktimeDetail roleQuicktimeDetail);
	public List<RoleQuicktimeDetail> findAllRolequicktime();
	public boolean updateQuicktime(Map<String, Object> param);
	public List<RoleQuicktimeDetail> getQuicktime(Map<String, Object> param);
	
	public boolean insertRolequicktime(RoleQuicktimeDetail detail);
}
