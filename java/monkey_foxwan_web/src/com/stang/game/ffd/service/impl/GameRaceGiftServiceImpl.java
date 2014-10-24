package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceGiftDao;
import com.stang.game.ffd.dao.impl.GameRaceGiftDaoImpl;
import com.stang.game.ffd.entity.detail.GameRaceGiftDetail;
import com.stang.game.ffd.service.IGameRaceGiftService;

public class GameRaceGiftServiceImpl extends
		BaseServiceImpl<GameRaceGiftDetail> implements IGameRaceGiftService {
	protected IGameRaceGiftDao getBaseDao() {
		if(baseDao == null){
			baseDao = new GameRaceGiftDaoImpl();
		}
		return (IGameRaceGiftDao) baseDao;
		
	}

	public List<GameRaceGiftDetail> getGameRaceGiftDetail(
			Map<String, Object> map) {
		return getBaseDao().getGameRaceGiftDetail(map);
	}

	public void insertGameRaceGiftDetail(GameRaceGiftDetail grgd) {
		getBaseDao().insertGameRaceGiftDetail(grgd);
	}

	public void updateGameRaceGiftDetail(GameRaceGiftDetail grgd) {
		getBaseDao().updateGameRaceGiftDetail(grgd);
	}
}
