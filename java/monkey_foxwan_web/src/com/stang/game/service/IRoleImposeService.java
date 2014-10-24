package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleAvatarDetail;
import com.stang.game.entity.detail.RoleImposeDetail;

public interface IRoleImposeService extends IBaseService<RoleImposeDetail> {
	public boolean insertRoleImpose(RoleImposeDetail aDetail);

	public boolean updateImpose(Map<String, Object> param);

	public List<RoleImposeDetail> getRoleImposeDetail(Map<String, Object> param);

	public boolean updateImposeNum();

	public List<RoleImposeDetail> getRoleImpose(int roleId);

	public boolean updateImposeIsnew(int isnew);

}
