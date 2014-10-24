package com.stang.game.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameLevelDao;
import com.stang.game.dao.IGameRoleDao;
import com.stang.game.dao.impl.GameLevelDaoImpl;
import com.stang.game.dao.impl.GameRoleDaoImpl;
import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.service.IGameRoleService;

public class GameRoleServiceImpl extends BaseServiceImpl<GameRoleDetail>
		implements IGameRoleService {
	private IGameLevelDao gameLevelDao;
	private IGameRoleDao gameRoleDao;

	private IGameRoleDao getGameRoleDao() {
		if (gameRoleDao == null) {
			gameRoleDao = new GameRoleDaoImpl();
		}
		return gameRoleDao;
	}

	private IGameLevelDao getGameLevelDao() {
		if (gameLevelDao == null) {
			gameLevelDao = new GameLevelDaoImpl();
		}
		return gameLevelDao;
	}

	protected IGameRoleDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameRoleDaoImpl();
		}
		return (IGameRoleDao) baseDao;
	}

	public GameRoleDetail findRoleById(int id) {
		return getBaseDao().findRoleById(id);
	}

	public boolean insertRole(GameRoleDetail model) {
		return getBaseDao().insertRole(model);
	}

	public boolean updateRole(GameRoleDetail model) {
		return getBaseDao().updateRole(model);
	}

	public boolean updateMap(int mapid, int placeid, int roleId) {
		return getBaseDao().updateMap(mapid, placeid, roleId);
	}

	public boolean addRoleCoin(int roleId, int coin) {
		return getBaseDao().addRoleCoin(roleId, coin);
	}

	public boolean addRoleGongxun(int roleId, int gongxun) {
		return getBaseDao().addRoleGongxun(roleId, gongxun);
	}

	public boolean addRoleYin(int roleId, int yin) {
		return getBaseDao().addRoleYin(roleId, yin);
	}

	public boolean subRoleCoin(int roleId, int coin) {
		return getBaseDao().subRoleCoin(roleId, coin);
	}

	public boolean subRoleGongxun(int roleId, int gongxun) {
		return getBaseDao().subRoleGongxun(roleId, gongxun);
	}

	public boolean subRoleYin(int roleId, int yin) {
		return getBaseDao().subRoleYin(roleId, yin);
	}

	public boolean addRoleExp(int roleId, int exp) {
		boolean bo = false;
		// 获得用户信息
		GameRoleDetail gr = this.getGameRoleDao().findRoleById(roleId);
		int key = gr.getLevel();
		int roleexp = gr.getExp() + exp;
		// 得到模型数据
		GameLevelDetail gl = this.getGameLevelDao()
				.getGameLevelByRoleLevel(key);
		// 判断
		if (roleexp >= gl.getNeedexp()) {
			// 到升级的时候了
			roleexp = roleexp - gl.getNeedexp();
			this.getGameRoleDao().addRoleLevel(roleId, (key + 1), roleexp);
		} else {
			this.getGameRoleDao().addRoleExp(roleId, roleexp);
		}
		return bo;
	}

	public boolean addRoleLevel(int roleId, int level, int exp) {
		return getBaseDao().addRoleLevel(roleId, level, exp);
	}

	public boolean upRoleYin(int roleId, int yin) {
		return getBaseDao().upRoleYin(roleId, yin);
	}

	public boolean updateGameRoleGamblingInfo(Map<String, Object> updateMap) {
		return getBaseDao().updateGameRoleGamblingInfo(updateMap);
	}

	public boolean subRolejunling(int roleId, int num) {
		return getBaseDao().subRolejunling(roleId,num);
	}

	public boolean addRolejunling(int roleId, int num) {
		return getBaseDao().addRolejunling(roleId,num);
	}

	public boolean addRolejunlingtime(int roleId, long jltime) {
		return getBaseDao().addRolejunlingtime(roleId,jltime);
	}

	public boolean updateRolestate(Map<String, Object> param) {
		return getBaseDao().updateRolestate(param);
	}

	public boolean updateRolerefertime(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateRolerefertime(param);
	}

	public boolean updateRolestateseven(Map<String, Object> param) {
		return getBaseDao().updateRolestateseven(param);
	}

	public boolean updateRoleSupsign(Map<String, Object> param) {
		return getBaseDao().updateRoleSupsign(param);
	}

	public boolean updateRoleDaynumstate(Map<String, Object> param) {
		return getBaseDao().updateRoleDaynumstate(param);
	}

	public boolean addRolecoinspend(Map<String, Object> param) {
		return getBaseDao().addRolecoinspend(param);
	}

	public boolean updateRoleVip(Map<String, Object> param) {
		return getBaseDao().updateRoleVip(param);
	}

	public boolean updateRolenowtime(Map<String, Object> param) {
		
		return getBaseDao().updateRolenowtime(param);
	}
	
	public boolean updateRolehelpstep(Map<String, Object> param) {
		
		return getBaseDao().updateRolehelpstep(param);
	}

	public boolean updateRoleintegral(Map<String, Object> param) {
		return getBaseDao().updateRoleintegral(param);
	}
	public List<GameRoleDetail> getRoleByLevel(Map<String, Object> param) {
		return getBaseDao().getRoleByLevel(param);
	}

	public boolean updateRoleline(int roleId, int line) {
		return getBaseDao().updateRoleline(roleId, line);
	}
}
