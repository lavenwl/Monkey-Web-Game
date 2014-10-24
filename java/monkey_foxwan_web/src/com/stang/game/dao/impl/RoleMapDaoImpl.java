package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IRoleMapDao;
import com.stang.game.entity.detail.GameTowerDetail;
import com.stang.game.entity.detail.RoleMapDetail;

public class RoleMapDaoImpl extends EntityDao<RoleMapDetail> implements
		IRoleMapDao {

	public List<RoleMapDetail> getRoleMap(int roleId) {
		List<RoleMapDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMap", roleId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertRoleMap(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleMap", param);
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

	public boolean updateRoleMap(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleMap", param);
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

	public List<RoleMapDetail> getRoleMapByParam(Map<String, Object> param) {
		List<RoleMapDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMapByParam", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<RoleMapDetail> getRoleMapByMapPlace(Map<String, Object> param) {
		List<RoleMapDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMapByMapPlace", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
