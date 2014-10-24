package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleAvatarDetail;

public interface IRoleAvatarDao extends IEntityDao<RoleAvatarDetail> {
	public List<RoleAvatarDetail> findAllRoleAvatar();
	public boolean insertRoleAvatar(RoleAvatarDetail aDetail);
	public boolean updateRoleAvatar(RoleAvatarDetail aDetail);
	public boolean updateAvatar(Map<String, Object> param);

	public boolean deleteRoleAvatar(Map<String, Object> param);

	public List<RoleAvatarDetail> getRoleAvatarDetail(Map<String, Object> param);
}
