package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IRoleTaskDao;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.entity.detail.RoleTaskDetail;


public class RoleTaskDaoImpl extends EntityDao<RoleTaskDetail> implements
	IRoleTaskDao{

	public boolean insertRoleTask(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleTask", param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	public List<RoleTaskDetail> findRoleTask(int roleId) {
		List<RoleTaskDetail> list = null;
		try {
			list = sqlMapper.queryForList("findRoleTask", roleId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean updateRoleTaskTye(int roleid,int type) {
		boolean isSuccess = false;
		try {
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("roleId", roleid);
			params.put("type", type);
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleTaskTye", params);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	public boolean updateRoleTaskTime(int roleid,long time,int taskid) {
		boolean isSuccess = false;
		try {
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("roleId", roleid);
			params.put("time", time);
			params.put("taskid", taskid);
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleTaskTime", params);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	public boolean updateRoleTasknumday(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("updateRoleTasknumday", param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	public boolean updateRoleTaskDailynum(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("updateRoleTaskDailynum", param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}

	public boolean updateRoleTaskStatus(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("updateRoleTaskStatus", param);
			sqlMapper.commitTransaction();
			isSuccess = true;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return isSuccess;
	}


}
