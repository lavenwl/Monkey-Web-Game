package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleInsDetail;

  public interface IRoleInsDao extends IEntityDao<RoleInsDetail>{

	
	public boolean insertRoleIns(RoleInsDetail aDetail);
	
	public boolean insertRoleInsRat(RoleInsDetail aDetail);

	public boolean updateIns(Map<String, Object> param);

	public List<RoleInsDetail> getRoleInsDetail(Map<String, Object> param);

	public List<RoleInsDetail> getRoleIns(int roleId);

}
