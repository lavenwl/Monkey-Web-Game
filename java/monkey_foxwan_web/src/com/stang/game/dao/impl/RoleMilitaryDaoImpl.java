package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IRoleMilitaryDao;
import com.stang.game.entity.detail.RoleMilitaryDetail;

public class RoleMilitaryDaoImpl extends EntityDao<RoleMilitaryDetail>
		implements IRoleMilitaryDao {

	public List<RoleMilitaryDetail> getRoleMilitary(int roleId) {
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMilitary", roleId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertRoleMilitary(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleMilitary", param);
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

	public boolean updateRoleMilitary(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleMilitary", param);
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

	public List<RoleMilitaryDetail> getRoleMilitarylevel(int id) {
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMilitarylevel", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<RoleMilitaryDetail> getRoleMilitaryByparam(
			Map<String, Object> param) {
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMilitaryByparam",param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<RoleMilitaryDetail> getRoleMilitarytime(int id, int roleId) {
		List<RoleMilitaryDetail> list = null;
		try {
			Map<String,Object> params=new HashMap<String, Object>();
			params.put("militaryid", id);
			params.put("roleId", roleId);
			list = sqlMapper.queryForList("getRoleMilitarytime", params);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean updateRoleMilitarytime(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleMilitarytime", param);
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

	public List<RoleMilitaryDetail> getRoleMilitaryBynotType(
			Map<String, Object> param) {
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMilitaryBynotType", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean addMilitayExp(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("addMilitayExp", param);
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

	public boolean deleteRoleMilitary(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("deleteRoleMilitary", param);
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

	public List<RoleMilitaryDetail> getRoleMilitaryByLevel(Map<String, Object> param) {
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMilitaryByLevel", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
