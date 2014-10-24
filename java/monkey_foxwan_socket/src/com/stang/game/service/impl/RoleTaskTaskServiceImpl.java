package com.stang.game.service.impl;

import java.util.List;
import com.stang.game.cache.CacheRoleTaskTask;
import java.util.Map;
import com.stang.game.dao.IRoleTaskTaskDao;
import com.stang.game.dao.impl.RoleTaskTaskDaoImpl;
import com.stang.game.entity.detail.RoleTaskTaskDetail;
import com.stang.game.service.IRoleTaskTaskService;

public class RoleTaskTaskServiceImpl extends BaseServiceImpl<RoleTaskTaskDetail>
implements IRoleTaskTaskService {
	
	private CacheRoleTaskTask cacheRoleTaskTask = null;
	private CacheRoleTaskTask getCacheRoleTaskTask(){
		if(cacheRoleTaskTask == null){
			cacheRoleTaskTask = new CacheRoleTaskTask();
		}
		return cacheRoleTaskTask;
	}
	
	protected IRoleTaskTaskDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleTaskTaskDaoImpl();
		}
		return (IRoleTaskTaskDao) baseDao;
	}

	public List<RoleTaskTaskDetail> findRoleTask(int roleId) {
		return getCacheRoleTaskTask().findRoleTask(roleId);
//		return getBaseDao().findRoleTask(roleId);
	}

	@Override
	public boolean deleteRoleTaskByTaskId0(Map<String, Object> param) {
		return getCacheRoleTaskTask().deleteRoleTaskByTaskId0(param);
//		return getBaseDao().deleteRoleTaskByTaskId0(param);
	}

	@Override
	public boolean insertRoleTask0(Map<String, Object> param) {
		return getCacheRoleTaskTask().insertRoleTaskTask(param);
//		return getBaseDao().insertRoleTask0(param);
	}

	@Override
	public boolean updateRoleTaskState0(Map<String, Object> param) {
		return getCacheRoleTaskTask().updateRoleTaskState0(param);
//		return getBaseDao().updateRoleTaskState0(param);
	}


	@Override
	public List<RoleTaskTaskDetail> findRoleTask0(Map<String, Object> param) {
		return getCacheRoleTaskTask().findRoleTask0(param);
//		return getBaseDao().findRoleTask0(param);
	}


	@Override
	public List<RoleTaskTaskDetail> findRoleTaskBytype0(
			Map<String, Object> param) {
		return getCacheRoleTaskTask().findRoleTaskBytype0(param);
//		return getBaseDao().findRoleTaskBytype0(param);
	}


	@Override
	public boolean updateRoleTaskProgress(Map<String, Object> param) {
		return getCacheRoleTaskTask().updateRoleTaskProgress(param);
//		return getBaseDao().updateRoleTaskProgress(param);
	}


	@Override
	public boolean updateRoleTaskNum(Map<String, Object> param) {
		return getCacheRoleTaskTask().updateRoleTaskNum(param);
//		return getBaseDao().updateRoleTaskNum(param);
	}

	@Override
	public List<RoleTaskTaskDetail> findAllRoleTaskTask() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllRoleTaskTask();
	}

	@Override
	public List<RoleTaskTaskDetail> findRoleTaskone(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findRoleTask0(param);
	}

	@Override
	public void updateTaskTask(RoleTaskTaskDetail roleTaskTaskDetail) {
		// TODO Auto-generated method stub
		getCacheRoleTaskTask().updateRoleTask(roleTaskTaskDetail);
	}

}
