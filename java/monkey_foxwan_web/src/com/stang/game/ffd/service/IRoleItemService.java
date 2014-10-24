package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.RoleItemDetail;


public interface IRoleItemService extends IBaseService<RoleItemDetail> {

	public List<RoleItemDetail> findRoleItemsByRoleId(Integer roleId);
	public List<RoleItemDetail> findItemsById(Integer id);
	
	public List<RoleItemDetail> findRoleItemsByRoleIds(List id);
	
	/**
	 * @method deleteRoleItem 
	 * @param Map
	 * @return {int}
	 * @description 删除角色-战斗性道具关系信息
	 */
	public int deleteRoleItem(Map<String, Object> param);
	
	/**
	 * 
	 * @param param
	 * @return {list}
	 * @description 根据参数获得信息列表
	 */
	public List<RoleItemDetail> getRoleItems(Map<String, Object> param);
	
	/**
	 * @method addBpRoleItem
	 * @param param
	 * @return {boolean}
	 * @description 插入数据
	 */
	public boolean insertRoleItem(RoleItemDetail iDetail);
	
	/**
	 * 
	 * @param iDetail {RoleItemDetail}
	 * @return {int}
	 * @description 更新
	 */
	public int updateRoleItem(RoleItemDetail iDetail);
	
	/**
	 * 
	 * @param itemId
	 * @return
	 * @description 使用一个道具（更新数量）
	 */
	public boolean deleteItemById(Integer itemId);
	
	public boolean deleteRoleItems(List<Integer> list);
	
	public boolean updateRoleItemNum(Map<String,Object> param);
	public boolean insertRoleItems(List<RoleItemDetail> insertList);
	public boolean updateRoleItems(List<RoleItemDetail> updateList);
	public boolean updateRoleItemDetailNum(List<RoleItemDetail> updateList);
	public List<RoleItemDetail> findRoleItemsByItemIds(List<Integer> itemIds,
			int playId);
	public int findItemIdById(Map<String,Object> param);
}
