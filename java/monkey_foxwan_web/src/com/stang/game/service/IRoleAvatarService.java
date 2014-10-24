package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleAvatarDetail;

public interface IRoleAvatarService extends IBaseService<RoleAvatarDetail> {
	public boolean insertRoleAvatar(RoleAvatarDetail aDetail);

	public boolean updateAvatar(Map<String, Object> param);

	public boolean deleteRoleAvatar(Map<String, Object> param);

	public List<RoleAvatarDetail> getRoleAvatarDetail(Map<String, Object> param);
}
