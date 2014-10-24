package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IRoleEquipDao;
import com.stang.game.entity.detail.RoleEquipDetail;
import com.stang.game.entity.detail.RoleItemDetail;

public class RoleEquipDaoImpl extends EntityDao<RoleEquipDetail> implements
		IRoleEquipDao {

	public boolean deleteRoleEquip(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.delete("deleteRoleEquip", param);
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

	public List<RoleEquipDetail> getRoleEquipDetail(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipDetail", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean insertRoleEquip(RoleEquipDetail detail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleEquip", detail);
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

	public boolean updateRoleEquip(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleEquip", param);
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

	public boolean addRoleEquipNum(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("addRoleEquipNum", param);
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

	public boolean sbRoleEquipNum(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("sbRoleEquipNum", param);
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

	public List<RoleEquipDetail> getRoleEquipById(int bid) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipById", bid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<RoleEquipDetail> getRoleEquip(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquip", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<RoleEquipDetail> getRoleEquipByEquipId(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipByEquipId", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean updateRoleEquipById(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleEquipById", param);
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

	public boolean subRoleEquipById(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("subRoleEquipById", param);
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

	public List<RoleEquipDetail> getRoleEquipByDengji(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipByDengji", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public List<RoleEquipDetail> getRoleEquipUser(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipUser", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}


}
