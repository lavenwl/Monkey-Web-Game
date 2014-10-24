package com.stang.game.service;

import java.util.List;
import java.util.Map;


import com.stang.game.entity.detail.RoleInsDetail;

public interface IRoleInsService extends IBaseService<RoleInsDetail>{
	public boolean insertRoleIns(RoleInsDetail aDetail);

	public boolean updateIns(Map<String, Object> param);
	
	public boolean insertRoleInsRat(RoleInsDetail aDetail);

	public List<RoleInsDetail> getRoleInsDetail(Map<String, Object> param);

	public List<RoleInsDetail> getRoleIns(int roleId);

	
}
