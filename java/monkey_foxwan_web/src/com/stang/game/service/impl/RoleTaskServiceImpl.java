package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IRoleTaskDao;
import com.stang.game.dao.impl.RoleTaskDaoImpl;
import com.stang.game.entity.detail.RoleTaskDetail;
import com.stang.game.service.IRoleTaskService;

public class RoleTaskServiceImpl extends BaseServiceImpl<RoleTaskDetail>
	implements IRoleTaskService {
	//增加
	protected IRoleTaskDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new RoleTaskDaoImpl();
		}
		return (IRoleTaskDao) baseDao;
	}

	public boolean insertRoleTask(Map<String, Object> param) {
		return getBaseDao().insertRoleTask(param);
	}

	public List<RoleTaskDetail> findRoleTask(int roleId) {
		return getBaseDao().findRoleTask(roleId);
	}

	public boolean updateRoleTaskTye(int roleid,int type) {
		return getBaseDao().updateRoleTaskTye(roleid,type);
	}

	public boolean updateRoleTaskTime(int roleid,long time,int taskid) {
		return getBaseDao().updateRoleTaskTime(roleid,time,taskid);
	}

	public boolean updateRoleTasknumday(Map<String, Object> param) {
		return getBaseDao().updateRoleTasknumday(param);
	}

	public boolean updateRoleTaskDailynum(Map<String, Object> param) {
		return getBaseDao().updateRoleTaskDailynum(param);
	}

	public boolean updateRoleTaskStatus(Map<String, Object> param) {
		return getBaseDao().updateRoleTaskStatus(param);
	}


}
