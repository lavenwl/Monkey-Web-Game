package com.stang.game.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.common.PageProperty;

import com.stang.game.dao.IRoleDaytaskDao;
import com.stang.game.entity.detail.RoleDaytaskDetail;

public class RoleDaytaskDaoImpl extends EntityDao<RoleDaytaskDetail> implements IRoleDaytaskDao {

	public RoleDaytaskDetail findRoleDaytaskByRId(int id) {
		List<RoleDaytaskDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findRoleDaytaskByRId", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!roles.isEmpty()) {
			return roles.get(0);
		} else {
			return null;
		}
	}

	public boolean insertRoleDaytask(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleDaytask", param);
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

	public boolean updateRoleDaytask(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleDaytask", param);
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
