package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.RoleItemDetail;

public interface IRoleItemService extends IBaseService<RoleItemDetail> {
	public boolean insertRoleItem(RoleItemDetail iDetail);

	public boolean sbRoleItemNum(Map<String, Object> param);

	public boolean addRoleItemNum(Map<String, Object> param);

	public List<RoleItemDetail> findRoleItemsByRoleId(int roleId);

	public List<RoleItemDetail> getRoleItem(Map<String, Object> param);

	public boolean delRoleItem(Map<String, Object> param);

	public List<RoleItemDetail> findRoleItemsById(int id);
	
	public List<RoleItemDetail> getRoleItemByitem(Map<String, Object> param);//查找该道具
	
	public boolean subRoleItem(Map<String, Object> param);//减掉物品
	
	public List<RoleItemDetail> getRoleItemByNum(Map<String, Object> param);//查找该道具

}
