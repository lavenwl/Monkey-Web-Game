package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoletotemDetail;

public interface IRoletotemService extends IBaseService<RoletotemDetail> {
	public List<RoletotemDetail> getallroletotem();
	public boolean insertRoletotem(RoletotemDetail detail);
	public boolean sbRoletotemNum(Map<String, Object> param);
	public boolean addRoletotemNum(Map<String, Object> param);
	public boolean delRoletotem(Map<String, Object> param);
	public List<RoletotemDetail> getRoletotem(Map<String, Object> param);
	public List<RoletotemDetail> getRoletotemtwo(Map<String, Object> param);
	public void updateTotem(RoletotemDetail roletotemDetail);
	
}

