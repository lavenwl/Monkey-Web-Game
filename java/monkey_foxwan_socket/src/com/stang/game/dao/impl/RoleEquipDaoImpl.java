package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IRoleEquipDao;
import com.stang.game.entity.detail.RoleEquipDetail;

public class RoleEquipDaoImpl extends EntityDao<RoleEquipDetail> implements
		IRoleEquipDao {

	@Override
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

	@Override
	public List<RoleEquipDetail> getRoleEquipDetail(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipDetail", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
	public List<RoleEquipDetail> getRoleEquipById(int bid) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipById", bid);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<RoleEquipDetail> getRoleEquip(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquip", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<RoleEquipDetail> getRoleEquipByEquipId(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipByEquipId", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
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

	@Override
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

	@Override
	public List<RoleEquipDetail> getRoleEquipByDengji(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipByDengji", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<RoleEquipDetail> getRoleEquipUser(Map<String, Object> param) {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleEquipUser", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public boolean updateRoleEquipByIdtwo(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleEquipByIdtwo", param);
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
	public List<RoleEquipDetail> findAllRoleEquip() {
		List<RoleEquipDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllRoleEquip");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public boolean deleteRoleEquip(RoleEquipDetail detail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("deleteRoleEquiptwo", detail);
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
	public boolean updateRoleEquip(RoleEquipDetail detail) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			//GameConstants.log.warn("equipid:" + detail.getEquipId() + "  id:" + detail.getId() + "  roleid:" + detail.getRoleId() + "   user:" + detail.getUser());
//			System.out.println("roleEquipDetail:" + detail.getAttack());
//			System.out.println("roleEquipDetail:" + detail.getDengji());
//			System.out.println("roleEquipDetail:" + detail.getEquipId());
//			System.out.println("roleEquipDetail:" + detail.getEquiptype());
//			System.out.println("roleEquipDetail:" + detail.getFlag());
//			System.out.println("roleEquipDetail:" + detail.getHpMax());
//			System.out.println("roleEquipDetail:" + detail.getId());
//			System.out.println("roleEquipDetail:" + detail.getIsUpdate());
//			System.out.println("roleEquipDetail:" + detail.getLevelexp());
//			System.out.println("roleEquipDetail:" + detail.getRectlength());
//			System.out.println("roleEquipDetail:" + detail.getRoleId());
//			System.out.println("roleEquipDetail:" + detail.getSpeed());
//			System.out.println("roleEquipDetail:" + detail.getStarlevel());
//			System.out.println("roleEquipDetail:" + detail.getType());
//			System.out.println("roleEquipDetail:" + detail.getUser());
//			System.out.println("roleEquipDetail:" + detail.getClass());
			sqlMapper.insert("updateRoleEquiptwo", detail);
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
