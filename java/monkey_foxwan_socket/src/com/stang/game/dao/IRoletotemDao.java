package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoletotemDetail;

public interface IRoletotemDao extends IEntityDao<RoletotemDetail> {
	public boolean insertRoletotem(RoletotemDetail detail);
	public boolean updateRoletotem(RoletotemDetail detail);
	public boolean deleteRoletotem(RoletotemDetail detail);
	public boolean sbRoletotemNum(Map<String, Object> param);
	public boolean addRoletotemNum(Map<String, Object> param);
	public boolean delRoletotem(Map<String, Object> param);
	public List<RoletotemDetail> getRoletotem(Map<String, Object> param);
	public List<RoletotemDetail> getallroletotem();
	
	
}
