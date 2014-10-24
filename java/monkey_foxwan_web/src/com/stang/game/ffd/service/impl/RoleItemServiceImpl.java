package com.stang.game.ffd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRoleItemDao;
import com.stang.game.ffd.dao.impl.RoleItemDaoImpl;
import com.stang.game.ffd.entity.detail.RoleItemDetail;
import com.stang.game.ffd.service.IRoleItemService;


/**
 * @author jianbo.feng 
 * @company 上海三唐信息科技有限公司
 * @description 角色拥有的战斗道具信息(相关信息存储于XML)
 */
public class RoleItemServiceImpl extends BaseServiceImpl<RoleItemDetail> implements
		IRoleItemService {

	protected IRoleItemDao getBaseDao() {
		if(baseDao == null) {
			baseDao = new RoleItemDaoImpl();
		}
		return (IRoleItemDao)baseDao;
	}

	public List<RoleItemDetail> findRoleItemsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return getBaseDao().findRoleItemsByRoleId(roleId);
	}

	public int deleteRoleItem(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().deleteRoleItem(param);
	}
	
	public List<RoleItemDetail> getRoleItems(Map<String, Object> param){
		return getBaseDao().getRoleItems(param);
	}

	
	public boolean insertRoleItem(RoleItemDetail iDetail){
		return getBaseDao().insertRoleItem(iDetail);
	}
	
	public int updateRoleItem(RoleItemDetail iDetail){
		return getBaseDao().updateRoleItem(iDetail);
	}
	
	public boolean deleteItemById(Integer itemId){
		//先得到数据，判断数量，更新数量或是删除
		boolean bo = false;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", itemId);
		param.put("flag", 1);
		List<RoleItemDetail> list = this.getRoleItems(param);
		if(list.size() == 1){
			RoleItemDetail ri = list.get(0);
			//判断
			if(ri.getNum().intValue() == 1){
				//直接删除
				getBaseDao().deleteOneItem(itemId);
				bo = true;
			}
			else{
				//更新
				RoleItemDetail rit = new RoleItemDetail();
				rit.setNum(ri.getNum().intValue() - 1);
				rit.setRoleId(ri.getRoleId());
				rit.setId(itemId);
				this.updateRoleItem(rit);
				bo = true;
				rit = null;
			}
			ri = null;
		}
		param = null;
		list = null;
		return bo;
	}

	public List<RoleItemDetail> findRoleItemsByRoleIds(List id) {
		return getBaseDao().findRoleItemsByRoleIds(id);
	}

	public boolean deleteRoleItems(List<Integer> list) {
		return getBaseDao().deleteRoleItems(list);
	}

	public List<RoleItemDetail> findItemsById(Integer id) {
		return getBaseDao().findItemsById(id);
	}

	public boolean updateRoleItemNum(Map<String, Object> param) {
		return getBaseDao().updateRoleItemNum(param);
	}

	public boolean insertRoleItems(List<RoleItemDetail> insertList) {
		// TODO Auto-generated method stub
		return getBaseDao().insertRoleItems(insertList);
	}

	public boolean updateRoleItems(List<RoleItemDetail> updateList) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRoleItems(updateList);
	}
	public List<RoleItemDetail> findRoleItemsByItemIds(List<Integer> itemIds,
			int playId) {
		// TODO Auto-generated method stub
		return  getBaseDao().findRoleItemsByItemIds(itemIds,playId);
	}

	public boolean updateRoleItemDetailNum(List<RoleItemDetail> updateList) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRoleItemDetailNum(updateList);
	}

	public int findItemIdById(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findItemIdById(param);
	}
	
	
}
