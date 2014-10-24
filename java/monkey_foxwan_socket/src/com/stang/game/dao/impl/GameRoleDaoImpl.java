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
     
	
	@Override
	public boolean insertGameRole(GameRoleDetail model) {
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
	@Override
	public boolean updateGameRole(GameRoleDetail model) {
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
	
	@Override
	public List<GameRoleDetail> findAllGameRole() {
		List<GameRoleDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findAllGameRole");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!roles.isEmpty()) {
			return roles;
		} else {
			return null;
		}
	}
	
	@Override
	public GameRoleDetail findRoleById(int id) {
		
		//System.out.println("===========调用findRoleById===========");
		List<GameRoleDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findRoleById", id);//
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
			System.out.println(e);
		}
		if (!roles.isEmpty()) {
			return roles.get(0);
		} else {
			return null;
		}
	}

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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
	@Override
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
	@Override
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
	@Override
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

	@Override
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

	@Override
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

	@Override
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

	@Override
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
	
	@Override
	public boolean updateRoleVipGiftTime(Map<String, Object> param) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleVipGiftTime", param);
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


	@Override
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

	@Override
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

	@Override
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
	@Override
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

	@Override
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
	@Override
	public List<GameRoleDetail> getRoleByLevel(Map<String, Object> param) {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevel", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
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

	@Override
	public List<GameRoleDetail> getRoleByLevels(Map<String, Object> param) {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public GameRoleDetail findRoleByName(String name) {
		List<GameRoleDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findRoleByName", name);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!roles.isEmpty()) {
			return roles.get(0);
		} else {
			return null;
		}
	
	
	}

	@Override
	public boolean updateJingji(int jjstatus) {
		boolean bo = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateJingji",jjstatus);
			sqlMapper.commitTransaction();
			bo = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (Exception e) {
				GameConstants.log.warn("", e);
			}
		}  
		return bo;
	}
	
	@Override
	public boolean updateDeskcheck(int jjstatus) {
		boolean bo = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateDeskcheck",jjstatus);
			sqlMapper.commitTransaction();
			bo = true;
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		} finally {
			try {
				sqlMapper.endTransaction();
			} catch (Exception e) {
				GameConstants.log.warn("", e);
			}
		}  
		return bo;
	}

	@Override
	public boolean updatefrinedchallenge() {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updatefrinedchallenge");
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
	public boolean updateRoleGift(GameRoleDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleGift", model);
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
	public boolean updateRoleGift2(GameRoleDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleGift2", model);
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
	public boolean updateRoleGift3(GameRoleDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleGift3", model);
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
	public boolean updateRoleGift4(GameRoleDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleGift4", model);
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
	public boolean updateRoleGift5(GameRoleDetail model) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateRoleGift5", model);
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
	public List<GameRoleDetail> getRoleByLevels2() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels2");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels3() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels3");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels4() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels4");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels5() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels5");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels6() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels6");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels7() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels7");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels1() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels1");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public GameRoleDetail findRoleById2(int id) {
		List<GameRoleDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findRoleById2", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!roles.isEmpty()) {
			return roles.get(0);
		} else {
			return null;
		}
	}

	@Override
	public GameRoleDetail findRoleById3(int id) {

		//System.out.println("===========调用findRoleById3===========");
		List<GameRoleDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findRoleById3", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!roles.isEmpty()) {
			return roles.get(0);
		} else {
			return null;
		}
	}

	@Override
	public GameRoleDetail findRoleById4(int id) {
		
		//System.out.println("===========调用findRoleById4===========");
		List<GameRoleDetail> roles = null;
		try {
			roles = sqlMapper.queryForList("findRoleById4", id);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		if (!roles.isEmpty()) {
			return roles.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels01() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels01");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels02() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels02");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels03() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels03");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels04() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels04");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels05() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels05");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels06() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels06");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRoleDetail> getRoleByLevels07() {
		List<GameRoleDetail> list = null;
		try {
			list = sqlMapper.queryForList("getRoleByLevels07");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public boolean upactivitygift(Map<String, Object> param) {
		boolean flag = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("upactivitygift", param);
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

	@Override
	public boolean upoldfriendgift(Map<String, Object> param) {
		boolean flag = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("upoldfriendgift", param);
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

	@Override
	public boolean updateTotem(Map<String, Object> param) {
		boolean flag = false;
		try {
			sqlMapper.startTransaction();
			sqlMapper.update("updateTotem", param);
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
	@Override
	public boolean updatefrinedchallenge(int i) {
		boolean isSuccess = false;
		try {
			sqlMapper.startTransaction();
			if(i==0){
				sqlMapper.update("updatefrinedchallenge");	
				//System.out.println("数据库更新用户补偿礼包：1：：");
			}
			if(i==1){
				sqlMapper.update("updatefrinedchallengetwo");
				//System.out.println("数据库更新用户补偿礼包：2：：");
			}
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
