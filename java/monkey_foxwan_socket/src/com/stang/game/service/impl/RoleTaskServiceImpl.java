package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.stang.game.cache.CacheRoleTask;
import com.stang.game.dao.IRoleTaskDao;
import com.stang.game.dao.impl.RoleTaskDaoImpl;
import com.stang.game.entity.detail.RoleTaskDetail;
import com.stang.game.service.IRoleTaskService;

public class RoleTaskServiceImpl extends BaseServiceImpl<RoleTaskDetail>
	implements IRoleTaskService {
	
	private static CacheRoleTask cacheRoleTask = null;
	private static CacheRoleTask getCacheRoleTask(){
		if(cacheRoleTask == null){
			cacheRoleTask = new CacheRoleTask();
		}
		return cacheRoleTask;
	}
	
	//增加
	protected IRoleTaskDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleTaskDaoImpl();
		}
		return (IRoleTaskDao) baseDao;
	}

	@Override
	public boolean insertRoleTask(Map<String, Object> param) {
		return getCacheRoleTask().insertRoleTask(param);
//		return getBaseDao().insertRoleTask(param);
	}

	@Override
	public List<RoleTaskDetail> findRoleTask(int roleId) {
		return getCacheRoleTask().findRoleTask(roleId);
//		return getBaseDao().findRoleTask(roleId);
	}

	@Override
	public boolean updateRoleTaskTye(int roleid,int type) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleid);
		param.put("type", type);
		return getCacheRoleTask().updateRoleTask(param);
//		return getBaseDao().updateRoleTaskTye(roleid,type);
	}

	@Override
	public boolean updateRoleTaskTime(int roleid,long time,int taskid) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", roleid);
		param.put("taskid", taskid);
		param.put("time", time);
		return getCacheRoleTask().updateRoleTask(param);
//		return getBaseDao().updateRoleTaskTime(roleid,time,taskid);
	}

	@Override
	public boolean updateRoleTasknumday(Map<String, Object> param) {
		return getCacheRoleTask().updateRoleTask(param);
//		return getBaseDao().updateRoleTasknumday(param);
	}

	@Override
	public boolean updateRoleTaskDailynum(Map<String, Object> param) {
		return getCacheRoleTask().updateRoleTaskDailynum(param);
//		return getBaseDao().updateRoleTaskDailynum(param);
	}

	@Override
	public boolean updateRoleTaskStatus(Map<String, Object> param) {
		return getCacheRoleTask().updateRoleTask(param);
//		return getBaseDao().updateRoleTaskStatus(param);
	}

	@Override
	public List<RoleTaskDetail> findAllRoleTask() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleTask();
	}

	@Override
	public void insertRoleTask(RoleTaskDetail roleTaskDetail) {
		// TODO Auto-generated method stub
		getCacheRoleTask().insertRoleTask(roleTaskDetail);
	}

	@Override
	public void updateRoleTaskc(RoleTaskDetail roleTaskDetail) {
		// TODO Auto-generated method stub
		getCacheRoleTask().updateRoleTask(roleTaskDetail);
	}



}
