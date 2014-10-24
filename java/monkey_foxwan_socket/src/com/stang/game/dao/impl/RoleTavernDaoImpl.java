package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IRoleTavernDao;
import com.stang.game.entity.detail.RoleTavernDetail;

public class RoleTavernDaoImpl extends EntityDao<RoleTavernDetail> implements
		IRoleTavernDao {

	@Override
	public List<RoleTavernDetail> getRoleTavern(int roleId) {
		List<RoleTavernDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleTavern", roleId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public boolean insertRoleTavern(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleTavern", param);
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

	@Override
	public boolean updateRoleTavern(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleTavern", param);
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

	@Override
	public boolean insertRoleTavern(RoleTavernDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleTaverntwo", model);
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

	@Override
	public boolean updateRoleTavern(RoleTavernDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleTaverntwo", model);
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
	
	@Override
	public List<RoleTavernDetail> findAllRoleTavern() {
		List<RoleTavernDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllRoleTavern");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
