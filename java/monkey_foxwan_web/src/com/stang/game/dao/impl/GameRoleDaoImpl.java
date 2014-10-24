package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameRoleDao;
import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.entity.detail.RoleImposeDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;
import com.stang.game.entity.detail.RoleQuicktimeDetail;

public class GameRoleDaoImpl extends EntityDao<GameRoleDetail> implements
		IGameRoleDao {

	public GameRoleDetail findRoleById(int id) {
		List<GameRoleDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findRoleById", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!roles.isEmpty()) {
			return roles.get(0);
		} else {
			return null;
		}
	}

	public boolean insertRole(GameRoleDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.insert("insertRole", model);
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

	public boolean updateRole(GameRoleDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRole", model);
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

	public boolean updateMap(int mapid, int placeid, int roleId) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("mapid", mapid);
			param.put("placeid", placeid);
			param.put("id", roleId);
			sqlMapper.startTransaction();
			sqlMapper.update("updateMap", param);
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

	public boolean addRoleCoin(int roleId, int coin) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", roleId);
			param.put("coin", coin);
			sqlMapper.startTransaction();
			sqlMapper.update("addRoleCoin", param);
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

	public boolean addRoleGongxun(int roleId, int gongxun) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", roleId);
			param.put("gongxun", gongxun);
			sqlMapper.startTransaction();
			sqlMapper.update("addRoleGongxun", param);
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

	public boolean addRoleYin(int roleId, int yin) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", roleId);
			param.put("yin", yin);
			sqlMapper.startTransaction();
			sqlMapper.update("addRoleYin", param);
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

	public boolean subRoleCoin(int roleId, int coin) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", roleId);
			param.put("coin", coin);
			sqlMapper.startTransaction();
			sqlMapper.update("subRoleCoin", param);
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

	public boolean subRoleGongxun(int roleId, int gongxun) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", roleId);
			param.put("gongxun", gongxun);
			sqlMapper.startTransaction();
			sqlMapper.update("subRoleGongxun", param);
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

	public boolean subRoleYin(int roleId, int yin) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", roleId);
			param.put("yin", yin);
			sqlMapper.startTransaction();
			sqlMapper.update("subRoleYin", param);
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

	public boolean addRoleExp(int roleId, int exp) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", roleId);
			param.put("exp", exp);
			sqlMapper.startTransaction();
			sqlMapper.update("addRoleExp", param);
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

	public boolean addRoleLevel(int roleId, int level, int exp) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", roleId);
			param.put("level", level);
			param.put("exp", exp);
			sqlMapper.startTransaction();
			sqlMapper.update("addRoleLevel", param);
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

	public boolean upRoleYin(int roleId, int yin) {
		boolean isSuccess = false;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", roleId);
			params.put("yin", yin);
			sqlMapper.startTransaction();
			sqlMapper.update("upRoleYin", params);
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

	public boolean updateGameRoleGamblingInfo(Map<String, Object> updateMap) {
		boolean flag = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateGameRoleGamblingInfo", updateMap);
			sqlMapper.commitTransaction();
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (SQLException e) {
				GameConstants.log.warn("", e);
			}
		}
		return flag;
	}

	//开始游戏，减少1个军令
	public boolean subRolejunling(int roleId, int num) {
		boolean isSuccess = false;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", roleId);
			params.put("junling", num);
			sqlMapper.startTransaction();
			sqlMapper.update("subRolejunling", params);
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
	
	//军令小于15，每小时增加1 
	public boolean addRolejunling(int roleId, int num) {
		boolean isSuccess = false;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", roleId);
			params.put("junling", num);
			sqlMapper.startTransaction();
			sqlMapper.update("addRolejunling", params);
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

	//军令时间增加1小时 
	public boolean addRolejunlingtime(int roleId, long jltime) {
		boolean isSuccess = false;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", roleId);
			params.put("jltime", jltime);
			sqlMapper.startTransaction();
			sqlMapper.update("addRolejunlingtime", params);
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

	public boolean updateRolestate(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRolestate", param);
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

	public boolean updateRolerefertime(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRolerefertime", param);
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

	public boolean updateRolestateseven(Map<String, Object> param) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRolestateseven", param);
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

	public boolean updateRoleSupsign(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleSupsign", param);
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

	public boolean updateRoleDaynumstate(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleDaynumstate", param);
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


	
	public boolean addRolecoinspend(Map<String, Object> param) {

		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("addRolecoinspend", param);
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

	public boolean updateRoleVip(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleVip", param);
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

	public boolean updateRolenowtime(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRolenowtime", param);
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
	public boolean updateRolehelpstep(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRolehelpstep", param);
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

	public boolean updateRoleintegral(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleintegral", param);
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
	public List<GameRoleDetail> getRoleByLevel(Map<String, Object> param) {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevel", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	public boolean updateRoleline(int roleId, int line) {
		boolean isSuccess = false;
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("id", roleId);
			param.put("roleline", line);
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleline", param);
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
