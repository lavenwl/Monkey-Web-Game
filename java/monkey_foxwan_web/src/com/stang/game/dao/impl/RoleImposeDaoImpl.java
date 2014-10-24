package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IRoleImposeDao;
import com.stang.game.entity.detail.RoleAvatarDetail;
import com.stang.game.entity.detail.RoleImposeDetail;

public class RoleImposeDaoImpl extends EntityDao<RoleImposeDetail> implements
		IRoleImposeDao {

	public List<RoleImposeDetail> getRoleImposeDetail(Map<String, Object> param) {
		List<RoleImposeDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleImposeDetail", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertRoleImpose(RoleImposeDetail detail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleImpose", detail);
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

	public boolean updateImpose(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateImpose", param);
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

	public boolean updateImposeNum() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateImposeNum");
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

	public List<RoleImposeDetail> getRoleImpose(int roleId) {
		List<RoleImposeDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleImpose", roleId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean updateImposeIsnew(int isnew) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateImposeIsnew", isnew);
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
