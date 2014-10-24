package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRoleEquipDao;
import com.stang.game.ffd.dao.impl.RoleEquipDaoImpl;
import com.stang.game.ffd.entity.detail.RoleEquipDetail;
import com.stang.game.ffd.service.IRoleEquipService;


/**
 * @author jianbo.feng 
 * @company 上海三唐信息科技有限公司
 * @description 角色拥有的装备信息(相关信息存储于XML)
 */
public class RoleEquipServiceImpl extends BaseServiceImpl<RoleEquipDetail> implements
		IRoleEquipService {

	protected IRoleEquipDao getBaseDao() {
		if(baseDao == null) {
			baseDao = new RoleEquipDaoImpl();
		}
		return (IRoleEquipDao)baseDao;
	}

	public List<RoleEquipDetail> findRoleEquipsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return getBaseDao().findRoleEquipsByRoleId(roleId);
	}

	public int batchDeleteRoleEquips(List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().batchDeleteRoleEquips(ids);
	}
	
	public List<RoleEquipDetail> getRoleEquips(Map<String, Object> param){
		return getBaseDao().getRoleEquips(param);
	}
	
	public boolean insertRoleEquip(RoleEquipDetail eDetail){
		return getBaseDao().insertRoleEquip(eDetail);
	}
	
	public int deleteRoleEquip(Map<String, Object> param){
		return getBaseDao().deleteRoleEquip(param);
	}
	
	public int updateRoleEquipById(RoleEquipDetail re){
		return getBaseDao().updateRoleEquipById(re);
	}
	
	public List<RoleEquipDetail> findRoleEquipById(Integer id){
		return getBaseDao().findRoleEquipById(id);
	}
	
	public List<RoleEquipDetail> findUsingRoleEquipsByRoleId(Integer roleId) {
		return getBaseDao().findUsingRoleEquipsByRoleId(roleId);
	}

	public boolean updateRoleEquip(Map param) {
		return getBaseDao().updateRoleEquip(param);
	}
	
	public int updateRoleEquipDetailByRoleIdAndEquipId(Map<String, Object> param) {
		return getBaseDao().updateRoleEquipDetailByRoleIdAndEquipId(param);
	}

	public int updateRoleEquipDetailByPackageId(Map<String, Object> param) {
		return getBaseDao().updateRoleEquipDetailByPackageId(param);
	}

	public int updateRoleUseingEquipsDetailByPlaneId(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRoleUseingEquipsDetailByPlaneId(id);
	}

	public boolean insertRoleEquips(List<RoleEquipDetail> equipList) {
		// TODO Auto-generated method stub
		return getBaseDao().insertRoleEquips(equipList);
	}

	public int findEquipIdById(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findEquipIdById(param);
	}
}
