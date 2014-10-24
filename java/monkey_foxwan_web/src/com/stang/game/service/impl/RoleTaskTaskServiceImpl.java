package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.dao.IRoleTaskTaskDao;
import com.stang.game.dao.impl.RoleTaskTaskDaoImpl;
import com.stang.game.entity.detail.RoleTaskTaskDetail;
import com.stang.game.service.IRoleTaskTaskService;

public class RoleTaskTaskServiceImpl extends BaseServiceImpl<RoleTaskTaskDetail>
implements IRoleTaskTaskService {
	protected IRoleTaskTaskDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleTaskTaskDaoImpl();
		}
		return (IRoleTaskTaskDao) baseDao;
	}


	public boolean deleteRoleTaskByTaskId0(Map<String, Object> param) {
		return getBaseDao().deleteRoleTaskByTaskId0(param);
	}

	public boolean insertRoleTask0(Map<String, Object> param) {
		return getBaseDao().insertRoleTask0(param);
	}

	public boolean updateRoleTaskState0(Map<String, Object> param) {
		return getBaseDao().updateRoleTaskState0(param);
	}


	public List<RoleTaskTaskDetail> findRoleTask0(Map<String, Object> param) {
		return getBaseDao().findRoleTask0(param);
	}


	public List<RoleTaskTaskDetail> findRoleTaskBytype0(
			Map<String, Object> param) {
		return getBaseDao().findRoleTaskBytype0(param);
	}


	public boolean updateRoleTaskProgress(Map<String, Object> param) {
		return getBaseDao().updateRoleTaskProgress(param);
	}


	public boolean updateRoleTaskNum(Map<String, Object> param) {
		return getBaseDao().updateRoleTaskNum(param);
	}

}
