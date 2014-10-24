package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleMapDetail;

public interface IRoleMapDao extends IEntityDao<RoleMapDetail> {
	public boolean insertRoleMap(RoleMapDetail roleMapDetail);
	public boolean updateRoleMap(RoleMapDetail roleMapDetail);
	public List<RoleMapDetail> findAllRoleMap();
	public boolean insertRoleMap(Map<String, Object> param);

	public boolean updateRoleMap(Map<String, Object> param);

	public List<RoleMapDetail> getRoleMap(int roleId);

	public List<RoleMapDetail> getRoleMapByParam(Map<String, Object> param);

	public List<RoleMapDetail> getRoleMapByMapPlace(Map<String, Object> param);
}
