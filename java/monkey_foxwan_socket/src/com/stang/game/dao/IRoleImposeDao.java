package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleImposeDetail;

public interface IRoleImposeDao extends IEntityDao<RoleImposeDetail> {
	public boolean updateRoleImpose(RoleImposeDetail aDetail);
	public List<RoleImposeDetail> findAllRoleImpose();

	public boolean insertRoleImpose(RoleImposeDetail aDetail);

	public boolean updateImpose(Map<String, Object> param);

	public List<RoleImposeDetail> getRoleImposeDetail(Map<String, Object> param);

	public List<RoleImposeDetail> getRoleImpose(int roleId);

	public boolean updateImposeNum();

	public boolean updateImposeIsnew(int isnew);
}
