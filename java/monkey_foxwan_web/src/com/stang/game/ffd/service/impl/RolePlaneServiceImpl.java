package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IRolePlaneDao;
import com.stang.game.ffd.dao.impl.RolePlaneDaoImpl;
import com.stang.game.ffd.entity.detail.RolePlaneDetail;
import com.stang.game.ffd.service.IRolePlaneService;


public class RolePlaneServiceImpl extends BaseServiceImpl<RolePlaneDetail> implements IRolePlaneService {

	protected IRolePlaneDao getBaseDao() {
		if(baseDao == null) {
			baseDao = new RolePlaneDaoImpl();
		}
		return (IRolePlaneDao)baseDao;
	}

	public List<RolePlaneDetail> findRolePlanesByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return getBaseDao().findRolePlanesByRoleId(roleId);
	}

	public int batchDeleteRolePlanes(List<Integer> ids) {
		// TODO Auto-generated method stub
		return getBaseDao().batchDeleteRolePlanes(ids);
	}

	public List<RolePlaneDetail> findRolePlanesByRoleIds(List<Integer> roleIds) {
		// TODO Auto-generated method stub
		return getBaseDao().findRolePlanesByRoleIds(roleIds);
	}

	public RolePlaneDetail findRolePlaneByRoleAndPlaneId(Integer roleId,
			Integer planeId) {
		// TODO Auto-generated method stub
		return getBaseDao().findRolePlaneByRoleAndPlaneId(roleId, planeId);
	}

	public List<RolePlaneDetail> findUsingRolePlanesByRoleId(Integer roleId) {
		// TODO Auto-generated method stub
		return getBaseDao().findUsingRolePlanesByRoleId(roleId);
	}
	
	public List<RolePlaneDetail> getRolePlanes(Map<String, Object> param){
		return getBaseDao().getRolePlanes(param);
	}
	
	public boolean insertRolePlane(RolePlaneDetail rpDetail){
		return getBaseDao().insertRolePlane(rpDetail);
	}
	
	public int deleteRolePlane(Map<String, Object> param){
		return getBaseDao().deleteRolePlane(param);
	}
	
	public int updateRolePlaneById(RolePlaneDetail rp){
		return getBaseDao().updateRolePlaneById(rp);
	}
	
	public int updateRolePlaneByRoleId(RolePlaneDetail rp){
		return getBaseDao().updateRolePlaneByRoleId(rp);
	}
	
	public int updateRolePlaneDetailByRoleIdAndPlaneId(Map<String, Object> param){
		return getBaseDao().updateRolePlaneDetailByRoleIdAndPlaneId(param);

	}
	
	public List<RolePlaneDetail> topRolePlanes(Map<String, Object> param){
		return getBaseDao().topRolePlanes(param);
	}

	public int updateRolePlaneByPackageId(Map<String, Object> param) {
		
		return getBaseDao().updateRolePlaneByPackageId(param);
	}

	public boolean insertRolePlanes(List<RolePlaneDetail> planeList) {
		// TODO Auto-generated method stub
		return getBaseDao().insertRolePlanes(planeList);
	}

	public int findPlaneIdById(Map<String, Object> param) {
		return getBaseDao().findPlaneIdById(param);
	}
	
}
