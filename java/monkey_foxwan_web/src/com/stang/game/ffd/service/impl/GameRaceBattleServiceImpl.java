package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceBattleDao;
import com.stang.game.ffd.dao.impl.GameRaceBattleDaoImpl;
import com.stang.game.ffd.entity.detail.GameRaceBattleDetail;
import com.stang.game.ffd.service.IGameRaceBattleService;


public class GameRaceBattleServiceImpl extends
		BaseServiceImpl<GameRaceBattleDetail> implements IGameRaceBattleService {
	protected IGameRaceBattleDao getBaseDao() {
		if(baseDao == null){
			baseDao = new GameRaceBattleDaoImpl();
		}
		return (IGameRaceBattleDao) baseDao;
		
	}

	public List<GameRaceBattleDetail> getGameRaceBattleDetail(
			Map<String, Object> map) {
		return getBaseDao().getGameRaceBattleDetail(map);
	}

	public void insertGameRaceBattleDetail(GameRaceBattleDetail grbd) {
		getBaseDao().insertGameRaceBattleDetail(grbd);
	}

	public void updateGameRaceBattleDetail(GameRaceBattleDetail grbd) {
		getBaseDao().updateGameRaceBattleDetail(grbd);
	}
}
