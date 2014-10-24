package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceRoleDao;
import com.stang.game.ffd.dao.impl.GameRaceRoleDaoImpl;
import com.stang.game.ffd.entity.detail.GameRaceRoleDetail;
import com.stang.game.ffd.service.IGameRaceRoleService;

public class GameRaceRoleServiceImpl extends
		BaseServiceImpl<GameRaceRoleDetail> implements IGameRaceRoleService {
	protected IGameRaceRoleDao getBaseDao() {
		if(baseDao == null){
			baseDao = new GameRaceRoleDaoImpl();
		}
		return (IGameRaceRoleDao) baseDao;
		
	}

	public List<GameRaceRoleDetail> getGameRaceRoleDetail(
			Map<String, Object> map) {
		return getBaseDao().getGameRaceRoleDetail(map);
	}

	public void insertGameRaceRoleDetail(GameRaceRoleDetail grrd) {
		getBaseDao().insertGameRaceRoleDetail(grrd);
	}

	public void updateGameRaceRoleDetail(GameRaceRoleDetail grrd) {
		getBaseDao().updateGameRaceRoleDetail(grrd);
	}
}
