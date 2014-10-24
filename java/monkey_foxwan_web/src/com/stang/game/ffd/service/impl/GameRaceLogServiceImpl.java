package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceLogDao;
import com.stang.game.ffd.dao.impl.GameRaceLogDaoImpl;
import com.stang.game.ffd.entity.detail.GameRaceLogDetail;
import com.stang.game.ffd.service.IGameRaceLogService;

public class GameRaceLogServiceImpl extends BaseServiceImpl<GameRaceLogDetail> implements
		IGameRaceLogService {
	protected IGameRaceLogDao getBaseDao() {
		if(baseDao == null){
			baseDao = new GameRaceLogDaoImpl();
		}
		return (IGameRaceLogDao) baseDao;
		
	}

	public List<GameRaceLogDetail> getGameRaceLogDetail(Map<String, Object> map) {
		return this.getBaseDao().getGameRaceLogDetail(map);
		
	}

	public void insertGameRaceLogDetail(GameRaceLogDetail grld) {
		this.getBaseDao().insertGameRaceLogDetail(grld);
	}

	public void updateGameRaceLogDetail(GameRaceLogDetail grld) {
		this.getBaseDao().updateGameRaceLogDetail(grld);
	}
}
