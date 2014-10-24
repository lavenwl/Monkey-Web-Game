package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.RoleAvatarDetail;


public interface IRoleAvatarService extends IBaseService<RoleAvatarDetail> {

	/**
	 * @method getRoleAvatarDetail
	 * @param param {Map<String,Object>} 
	 * @return {RoleAvatarDetail}
	 * @description 根据参数获得角色-装饰信息
	 */
	public RoleAvatarDetail getRoleAvatarDetail(Map<String,Object> param);
	
	/**
	 * @method findRoleAvatarsByRoleId
	 * @param roleId {Integer} 角色序列号 
	 * @return {List<RoleAvatarDetail>}
	 * @description 根据角色序列号查询角色所拥有的所有角色-装饰关系信息
	 */
	public List<RoleAvatarDetail> findRoleAvatarsByRoleId(Integer roleId);
	
	/**
	 * @method findFullRoleAvatarsByRoleId
	 * @param roleId {Integer} 角色序列号 
	 * @return {List<RoleAvatarFullDetail>}
	 * @description 根据角色序列号查询角色所拥有的所有装饰完全信息
	 */
	public List<RoleAvatarDetail> findUsingRoleAvatarsByRoleId(Integer roleId);

	/**
	 * @method updateRoleAvatarDetail  
	 * @param model {RoleAvatarDetail} 角色-装饰关系信息对象
	 * @return {int}
	 * @description 更新角色-装饰信息
	 */
	public int updateRoleAvatarDetail(RoleAvatarDetail model);
	
	/**
	 * @method updateRoleAvatarNotusedStatusByRoleId 
	 * @param roleId {Integer} 角色序列号
	 * @return {int}
	 * @description 根据角色序列号更新该角色所有的装饰信息为非使用状态
	 */
	public int updateRoleAvatarNotusedStatusByRoleId(Integer roleId);
	
	/**
	 * @method updateRoleAvatarUsedStatusByRoleIdAndIds
	 * @param roleId {Integer} 角色序列号 
	 * @return {int}
	 * @description 根据装饰序列号组设置角色使用的装饰信息
	 */
	public int updateRoleAvatarUsedStatusByRoleIdAndIds(Integer roleId,List<Integer> ids);
	
	/**
	 * @method updateRoleAvatarUsedStatusById 
	 * @param id {Integer} 角色-装饰关系信息
	 * @param roleId {Integer} 角色序列号
	 * @return {boolean}
	 * @description 根据序号更新该角色装饰信息为使用状态
	 */
	public boolean updateRoleAvatarUsedStatusById(Integer id,Integer roleId);
	
	/**
	 * @method updateRoleAvatarNotusedStatusById 
	 * @param id {Integer} 角色-装饰关系信息
	 * @param roleId {Integer} 角色序列号
	 * @return {boolean}
	 * @description 根据序号更新该角色装饰信息为非使用状态
	 */
	public boolean updateRoleAvatarNotusedStatusById(Integer id,Integer roleId);
	
	/**
	 * 
	 * @param param
	 * @return List<RoleAvatarDetail>
	 * @description 根据参数获得信息列表
	 */
	public List<RoleAvatarDetail> getRoleAvatars(Map<String, Object> param);
	
	/**
	 * 
	 * @param aDetail
	 * @return
	 * @description 插入一条数据
	 */
	public boolean insertRoleAvatar(RoleAvatarDetail aDetail);
	
	/**
	 * 
	 * @param param
	 * @return
	 * @description 删除一条数据
	 */
	public int deleteRoleAvatar(Map<String, Object> param);
	
	/**
	 * 
	 * @param ra
	 * @return
	 * @description 更新一条数据
	 */
	public int updateRoleAvatarById(RoleAvatarDetail ra);
	
	public int updateRoleAvatarIsNotUsedByAddress(Map<String, Object> param);
	
	public int findAvatarIdById(Map<String, Object> param);
	
}
