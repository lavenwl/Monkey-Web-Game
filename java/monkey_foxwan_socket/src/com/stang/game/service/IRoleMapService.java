package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleMapDetail;

public interface IRoleMapService extends IBaseService<RoleMapDetail> {
	public boolean insertRoleMap(Map<String, Object> param);
	public List<RoleMapDetail> findAllRoleMap();
	public boolean updateRoleMap(Map<String, Object> param);

	public List<RoleMapDetail> getRoleMap(int roleId);

	public List<RoleMapDetail> getRoleMapByParam(Map<String, Object> param);

	public List<RoleMapDetail> getRoleMapByMapPlace(Map<String, Object> param);
	public void updateMap(RoleMapDetail roleMapDetail);
}
