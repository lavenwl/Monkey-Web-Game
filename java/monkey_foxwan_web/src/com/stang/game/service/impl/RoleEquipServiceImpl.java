package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleEquipDao;
import com.stang.game.dao.impl.RoleEquipDaoImpl;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.service.IRoleEquipService;

public class RoleEquipServiceImpl extends BaseServiceImpl<RoleEquipDetail>
implements IRoleEquipService{

	protected IRoleEquipDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleEquipDaoImpl();
		}
		return (IRoleEquipDao) baseDao;
	}

	public boolean deleteRoleEquip(Map<String, Object> param) {
		return getBaseDao().deleteRoleEquip(param);
	}

	public List<RoleEquipDetail> getRoleEquipDetail(Map<String, Object> param) {
		return getBaseDao().getRoleEquipDetail(param);
	}

	public boolean insertRoleEquip(RoleEquipDetail detail) {
		return getBaseDao().insertRoleEquip(detail);
	}

	public boolean updateRoleEquip(Map<String, Object> param) {
		return getBaseDao().updateRoleEquip(param);
	}

	public boolean addRoleEquipNum(Map<String, Object> param) {
		return getBaseDao().addRoleEquipNum(param);
	}

	public boolean sbRoleEquipNum(Map<String, Object> param) {
		return getBaseDao().sbRoleEquipNum(param);
	}

	public List<RoleEquipDetail> getRoleEquipById(int bid) {
		return getBaseDao().getRoleEquipById(bid);
	}
 
	public List<RoleEquipDetail> getRoleEquip(Map<String, Object> param) {
		return getBaseDao().getRoleEquip(param);
	}

	public List<RoleEquipDetail> getRoleEquipByEquipId(Map<String, Object> param) {
		return getBaseDao().getRoleEquipByEquipId(param);
	}

	public boolean updateRoleEquipById(Map<String, Object> param) {
		return getBaseDao().updateRoleEquipById(param);
	}

	public boolean subRoleEquipById(Map<String, Object> param) {
		return getBaseDao().subRoleEquipById(param);
	}

	public List<RoleEquipDetail> getRoleEquipByDengji(Map<String, Object> param) {
		return getBaseDao().getRoleEquipByDengji(param);
	}

	public List<RoleEquipDetail> getRoleEquipUser(Map<String, Object> param) {
		return getBaseDao().getRoleEquipUser(param);
	}

}
