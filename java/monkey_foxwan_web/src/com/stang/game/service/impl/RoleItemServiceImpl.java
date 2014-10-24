package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleItemDao;
import com.stang.game.dao.impl.RoleItemDaoImpl;
import com.stang.game.entity.detail.RoleItemDetail;
import com.stang.game.service.IRoleItemService;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司
 * @description 角色道具信息
 */
public class RoleItemServiceImpl extends BaseServiceImpl<RoleItemDetail>
		implements IRoleItemService {

	protected IRoleItemDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleItemDaoImpl();
		}
		return (IRoleItemDao) baseDao;
	}

	public boolean addRoleItemNum(Map<String, Object> param) {
		return getBaseDao().addRoleItemNum(param);
	}

	public List<RoleItemDetail> findRoleItemsByRoleId(int roleId) {
		return getBaseDao().findRoleItemsByRoleId(roleId);
	}

	public List<RoleItemDetail> getRoleItem(Map<String, Object> param) {
		return getBaseDao().getRoleItem(param);
	}

	public boolean insertRoleItem(RoleItemDetail detail) {
		return getBaseDao().insertRoleItem(detail);
	}

	public boolean sbRoleItemNum(Map<String, Object> param) {
		return getBaseDao().sbRoleItemNum(param);
	}

	public boolean delRoleItem(Map<String, Object> param) {
		return getBaseDao().delRoleItem(param);
	}

	public List<RoleItemDetail> findRoleItemsById(int id) {
		return getBaseDao().findRoleItemsById(id);
	}

	public List<RoleItemDetail> getRoleItemByitem(Map<String, Object> param) {
		return getBaseDao().getRoleItemByitem(param);
	}

	public boolean subRoleItem(Map<String, Object> param) {
		return getBaseDao().subRoleItem(param);
	}

	public List<RoleItemDetail> getRoleItemByNum(Map<String, Object> param) {
		return getBaseDao().getRoleItemByNum(param);
	}

}
