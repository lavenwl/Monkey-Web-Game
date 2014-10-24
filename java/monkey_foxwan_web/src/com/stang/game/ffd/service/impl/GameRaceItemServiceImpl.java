package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameRaceItemDao;
import com.stang.game.ffd.dao.impl.GameRaceItemDaoImpl;
import com.stang.game.ffd.entity.detail.GameRaceItemDetail;
import com.stang.game.ffd.service.IGameRaceItemService;

public class GameRaceItemServiceImpl extends
		BaseServiceImpl<GameRaceItemDetail> implements IGameRaceItemService {
	protected IGameRaceItemDao getBaseDao() {
		if(baseDao == null){
			baseDao = new GameRaceItemDaoImpl();
		}
		return (IGameRaceItemDao) baseDao;
		
	}

	public List<GameRaceItemDetail> getGameRaceItemDetail(
			Map<String, Object> map) {
		return getBaseDao().getGameRaceItemDetail(map);
	}

	public void insertGameRaceItemDetail(GameRaceItemDetail grid) {
		getBaseDao().insertGameRaceItemDetail(grid);
	}

	public void updateGameRaceItemDetail(GameRaceItemDetail grid) {
		getBaseDao().updateGameRaceItemDetail(grid);
	}
}
