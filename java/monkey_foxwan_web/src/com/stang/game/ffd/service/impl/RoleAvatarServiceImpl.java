package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRoleAvatarDao;
import com.stang.game.ffd.dao.impl.RoleAvatarDaoImpl;
import com.stang.game.ffd.entity.detail.RoleAvatarDetail;
import com.stang.game.ffd.service.IRoleAvatarService;


public class RoleAvatarServiceImpl extends BaseServiceImpl<RoleAvatarDetail> implements
		IRoleAvatarService {

	protected IRoleAvatarDao getBaseDao() {
		if(baseDao == null) {
			baseDao = new RoleAvatarDaoImpl();
		}
		return (IRoleAvatarDao)baseDao; 
	}

	public List<RoleAvatarDetail> findRoleAvatarsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return getBaseDao().findRoleAvatarsByRoleId(roleId);
	}

	public int updateRoleAvatarNotusedStatusByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRoleAvatarNotusedStatusByRoleId(roleId);
	}

	public int updateRoleAvatarUsedStatusByRoleIdAndIds(Integer roleId,
			List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRoleAvatarUsedStatusByRoleIdAndIds(roleId, ids);
	}

	public int updateRoleAvatarDetail(RoleAvatarDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().update(model);
	}

	public RoleAvatarDetail getRoleAvatarDetail(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getRoleAvatarDetail(param);
	}
	
	public List<RoleAvatarDetail> getRoleAvatars(Map<String, Object> param){
		return getBaseDao().getRoleAvatars(param);
	}
	
	public boolean insertRoleAvatar(RoleAvatarDetail aDetail){
		return getBaseDao().insertRoleAvatar(aDetail);
	}
	
	public int deleteRoleAvatar(Map<String, Object> param){
		return getBaseDao().deleteRoleAvatar(param);
	}
	
	public int updateRoleAvatarById(RoleAvatarDetail ra){
		return getBaseDao().updateRoleAvatarById(ra);
	}

	public boolean updateRoleAvatarNotusedStatusById(Integer id, Integer roleId) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRoleAvatarNotusedStatusById(id, roleId);
	}

	public boolean updateRoleAvatarUsedStatusById(Integer id, Integer roleId) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRoleAvatarUsedStatusById(id, roleId);
	}

	public List<RoleAvatarDetail> findUsingRoleAvatarsByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return getBaseDao().findUsingRoleAvatarsByRoleId(roleId);
	}
	
	public int updateRoleAvatarIsNotUsedByAddress(Map<String, Object> param){
		return getBaseDao().updateRoleAvatarIsNotUsedByAddress(param);
	}

	public int findAvatarIdById(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAvatarIdById(param);
	}
}
