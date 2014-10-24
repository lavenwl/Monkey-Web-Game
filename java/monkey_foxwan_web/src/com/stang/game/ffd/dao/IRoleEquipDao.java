package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.RoleEquipDetail;


public interface IRoleEquipDao extends IEntityDao<RoleEquipDetail> {

	public List<RoleEquipDetail> findRoleEquipsByRoleId(Integer roleId);
	
	public List<RoleEquipDetail> findUsingRoleEquipsByRoleId(Integer roleId);
	
	/**
	 * @method batchDeleteRoleItems 
	 * @param ids {List<Integer>}
	 * @return {int}
	 * @description 批量删除角色-装备关系信息
	 */
	public int batchDeleteRoleEquips(List<Integer> ids);
	
	/**
	 * 
	 * @param param
	 * @return
	 * @description 根据参数获得信息列表
	 */
	public List<RoleEquipDetail> getRoleEquips(Map<String, Object> param);
	
	/**
	 * 
	 * @param eDetail
	 * @return
	 * @description 插入一条数据
	 */
	public boolean insertRoleEquip(RoleEquipDetail eDetail);
	
	/**
	 * 
	 * @param param
	 * @return
	 * @description 删除一条数据
	 */
	public int deleteRoleEquip(Map<String, Object> param);
	
	/**
	 * 
	 * @param re
	 * @return
	 * @description 更新一条数据
	 */
	public int updateRoleEquipById(RoleEquipDetail re);
	
	
	public boolean updateRoleEquip(Map param);
	
	public List<RoleEquipDetail> findRoleEquipById(Integer id);

	public int updateRoleEquipDetailByRoleIdAndEquipId(Map<String, Object> param);

	public int updateRoleEquipDetailByPackageId(Map<String, Object> param);

	public int updateRoleUseingEquipsDetailByPlaneId(int id);

	public boolean insertRoleEquips(List<RoleEquipDetail> equipList);

	public int findEquipIdById(Map<String, Object> param);
}
