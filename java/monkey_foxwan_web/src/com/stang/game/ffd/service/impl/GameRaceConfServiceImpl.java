package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceConfDao;
import com.stang.game.ffd.dao.impl.GameRaceConfDaoImpl;
import com.stang.game.ffd.entity.detail.GameRaceConfDetail;
import com.stang.game.ffd.service.IGameRaceConfService;

public class GameRaceConfServiceImpl extends
		BaseServiceImpl<GameRaceConfDetail> implements IGameRaceConfService {
	protected IGameRaceConfDao getBaseDao() {
		if(baseDao == null){
			baseDao = new GameRaceConfDaoImpl();
		}
		return (IGameRaceConfDao) baseDao;
		
	}

	public List<GameRaceConfDetail> getGameRaceConfDetail(
			Map<String, Object> map) {
		
		return this.getBaseDao().getGameRaceConfDetail(map);
	}

	public void insertGameRaceConfDetail(GameRaceConfDetail grcd) {
		this.getBaseDao().insertGameRaceConfDetail(grcd);
	}

	public void updateGameRaceConfDetail(GameRaceConfDetail grcd) {
		this.getBaseDao().updateGameRaceConfDetail(grcd);
	}

	public int getGameRaceConfCount() {
		return this.getBaseDao().getGameRaceConfCount();
	}
}
