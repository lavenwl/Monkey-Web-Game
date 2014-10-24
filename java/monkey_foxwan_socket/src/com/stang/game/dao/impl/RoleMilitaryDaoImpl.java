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

	@Override
	public List<RoleMilitaryDetail> getRoleMilitary(int roleId) {
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMilitary", roleId);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
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

	@Override
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

	@Override
	public List<RoleMilitaryDetail> getRoleMilitarylevel(int id) {
	//	System.out.println("getRoleMilitarylevel");
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMilitarylevel", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
	public List<RoleMilitaryDetail> getRoleMilitaryByLevel(Map<String, Object> param) {
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMilitaryByLevel", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public boolean updateRoleMilitarytwo(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleMilitarytwo", param);
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
	public List<RoleMilitaryDetail> getRoleMilitarylevel2(
			Map<String, Object> param) {
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleMilitarylevel2",param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<RoleMilitaryDetail> findAllRoleMilitary() {
		List<RoleMilitaryDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllRoleMilitary");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public boolean deleteRoleMilitary(RoleMilitaryDetail roleMilitaryDetail) {
//		System.out.println("delete!!roleid:" + roleMilitaryDetail.getRoleId() + "  militaryid:" + roleMilitaryDetail.getMilitaryid() + "  name:" + roleMilitaryDetail.getName() + "   id:" + roleMilitaryDetail.getId() + "   wuqi:" + roleMilitaryDetail.getWuqi() + "   xiezi:" + roleMilitaryDetail.getXiezi() + "   touguan:" + roleMilitaryDetail.getTouguan() + "   huwan:" + roleMilitaryDetail.getHuwan());
		//GameConstants.log.warn("delete!!roleid:" + roleMilitaryDetail.getRoleId() + "  militaryid:" + roleMilitaryDetail.getMilitaryid() + "  name:" + roleMilitaryDetail.getName() + "   id:" + roleMilitaryDetail.getId() + "   wuqi:" + roleMilitaryDetail.getWuqi() + "   xiezi:" + roleMilitaryDetail.getXiezi() + "   touguan:" + roleMilitaryDetail.getTouguan() + "   huwan:" + roleMilitaryDetail.getHuwan());
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("deleteRoleMilitarytwo", roleMilitaryDetail);
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
	public boolean insertRoleMilitary(RoleMilitaryDetail roleMilitaryDetail) {
//		System.out.println("insert!!roleid:" + roleMilitaryDetail.getRoleId() + "  militaryid:" + roleMilitaryDetail.getMilitaryid() + "  name:" + roleMilitaryDetail.getName() + "   id:" + roleMilitaryDetail.getId() + "   wuqi:" + roleMilitaryDetail.getWuqi() + "   xiezi:" + roleMilitaryDetail.getXiezi() + "   touguan:" + roleMilitaryDetail.getTouguan() + "   huwan:" + roleMilitaryDetail.getHuwan());
		//GameConstants.log.warn("insert!!roleid:" + roleMilitaryDetail.getRoleId() + "  militaryid:" + roleMilitaryDetail.getMilitaryid() + "  name:" + roleMilitaryDetail.getName() + "   id:" + roleMilitaryDetail.getId() + "   wuqi:" + roleMilitaryDetail.getWuqi() + "   xiezi:" + roleMilitaryDetail.getXiezi() + "   touguan:" + roleMilitaryDetail.getTouguan() + "   huwan:" + roleMilitaryDetail.getHuwan());
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRoleMilitarytwo", roleMilitaryDetail);
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
	public boolean updateRoleMilitary(RoleMilitaryDetail roleMilitaryDetail) {
//		System.out.println("update!!roleid:" + roleMilitaryDetail.getRoleId() + "  militaryid:" + roleMilitaryDetail.getMilitaryid() + "  name:" + roleMilitaryDetail.getName() + "   id:" + roleMilitaryDetail.getId() + "   wuqi:" + roleMilitaryDetail.getWuqi() + "   xiezi:" + roleMilitaryDetail.getXiezi() + "   touguan:" + roleMilitaryDetail.getTouguan() + "   huwan:" + roleMilitaryDetail.getHuwan());
//GameConstants.log.warn("update!!roleid:" + roleMilitaryDetail.getRoleId() + "  militaryid:" + roleMilitaryDetail.getMilitaryid() + "  name:" + roleMilitaryDetail.getName() + "   id:" + roleMilitaryDetail.getId() + "   wuqi:" + roleMilitaryDetail.getWuqi() + "   xiezi:" + roleMilitaryDetail.getXiezi() + "   touguan:" + roleMilitaryDetail.getTouguan() + "   huwan:" + roleMilitaryDetail.getHuwan() + "   yifu:" + roleMilitaryDetail.getYifu() + "   shipin:" + roleMilitaryDetail.getShipin());
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("updateRoleMilitary2", roleMilitaryDetail);
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
