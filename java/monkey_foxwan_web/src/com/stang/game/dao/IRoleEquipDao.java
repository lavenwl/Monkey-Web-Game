package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleEquipDetail;

public interface IRoleEquipDao extends IEntityDao<RoleEquipDetail> {
	public boolean insertRoleEquip(RoleEquipDetail aDetail);

	public boolean updateRoleEquip(Map<String, Object> param);

	public boolean deleteRoleEquip(Map<String, Object> param);

	public List<RoleEquipDetail> getRoleEquipDetail(Map<String, Object> param);

	public List<RoleEquipDetail> getRoleEquipById(int bid);

	public boolean sbRoleEquipNum(Map<String, Object> param);

	public boolean addRoleEquipNum(Map<String, Object> param);

	public List<RoleEquipDetail> getRoleEquipByEquipId(Map<String, Object> param);

	

	public List<RoleEquipDetail> getRoleEquip(Map<String, Object> param);
	
	public boolean updateRoleEquipById(Map<String, Object> param);;//更新获得强化值
	
	public boolean subRoleEquipById(Map<String, Object> param);;//降级减少相应值
	
	public List<RoleEquipDetail> getRoleEquipByDengji(Map<String, Object> param);
	
	public List<RoleEquipDetail> getRoleEquipUser(Map<String, Object> param);
}
