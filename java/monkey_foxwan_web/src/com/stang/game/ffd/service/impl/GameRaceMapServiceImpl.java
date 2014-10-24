package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceMapDao;
import com.stang.game.ffd.dao.impl.GameRaceMapDaoImpl;
import com.stang.game.ffd.entity.detail.GameRaceMapDetail;
import com.stang.game.ffd.service.IGameRaceMapService;

public class GameRaceMapServiceImpl extends BaseServiceImpl<GameRaceMapDetail>
		implements IGameRaceMapService {

	protected IGameRaceMapDao getBaseDao() {
		if(baseDao == null){
			baseDao = new GameRaceMapDaoImpl();
		}
		return (IGameRaceMapDao) baseDao;
		
	}

	public List<GameRaceMapDetail> getGameRaceMapDetail(
			Map<String, Object> map) {
		return getBaseDao().getGameRaceMapDetail(map);
	}

	public void insertGameRaceMapDetail(GameRaceMapDetail grid) {
		getBaseDao().insertGameRaceMapDetail(grid);
	}

	public void updateGameRaceMapDetail(GameRaceMapDetail grid) {
		getBaseDao().updateGameRaceMapDetail(grid);
	}
}


