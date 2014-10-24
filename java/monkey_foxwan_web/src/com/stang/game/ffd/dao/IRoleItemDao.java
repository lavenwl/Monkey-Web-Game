package com.stang.game.ffd.dao;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.RoleItemDetail;


public interface IRoleItemDao extends IEntityDao<RoleItemDetail> {

	public List<RoleItemDetail> findRoleItemsByRoleId(Integer roleId);
	
	public List<RoleItemDetail> findItemsById(Integer id);
	
	public List<RoleItemDetail> findRoleItemsByRoleIds(List id);
	/**
	 * @method deleteRoleItem
	 * @param {Map}
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
	 * @method addRoleItem
	 * @param iDetail{RoleItemDetail}
	 * @return {int}
	 * @description 插入数据
	 */	
	public boolean insertRoleItem(RoleItemDetail iDetail);
	
	/**
	 * @method updateRoleItem
	 * @param iDetail{RoleItemDetail}
	 * @return{int}
	 * @description 更新
	 */
	public int updateRoleItem(RoleItemDetail iDetail);
	
	/**
	 * 
	 * @param itemId
	 * @return
	 * @description 删除用户一个道具数据（使用道具后）
	 */
	public int deleteOneItem(Integer itemId);
	/**
	 * @method deleteRoleItems
	 * @param list
	 * @return boolean
	 * @description 根据id[],删除信息
	 */
	public boolean deleteRoleItems(List<Integer> list);
	
	/**
	 * @method upRoleItems
	 * @param list{List},num{Integer}
	 * @return boolean
	 * @description 更新信息
	 */
	public boolean upRoleItems(List<Integer> list, Integer num);
	
	/**
	 * @method updateRoleItemNum
	 * @param {Map<String,Object>}
	 * @return boolean
	 * @description 更新信息
	 */
	public boolean updateRoleItemNum(Map<String,Object> param);

	public boolean insertRoleItems(List<RoleItemDetail> insertList);

	public boolean updateRoleItems(List<RoleItemDetail> updateList);

	public List<RoleItemDetail> findRoleItemsByItemIds(List<Integer> itemIds,
			int playId);

	public boolean updateRoleItemDetailNum(List<RoleItemDetail> updateList);

	public int findItemIdById(Map<String, Object> param);
}
