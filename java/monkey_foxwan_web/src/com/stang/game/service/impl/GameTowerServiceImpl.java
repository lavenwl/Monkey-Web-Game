package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IGameTowerDao;
import com.stang.game.dao.impl.GameTowerDaoImpl;
import com.stang.game.entity.detail.GameTowerDetail;
import com.stang.game.service.IGameTowerService;

public class GameTowerServiceImpl extends BaseServiceImpl<GameTowerDetail>
		implements IGameTowerService {
	protected IGameTowerDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameTowerDaoImpl();
		}
		return (IGameTowerDao) baseDao;
	}

	public List<GameTowerDetail> getGameTower() {
		return getBaseDao().getGameTower();
	}

	public List<GameTowerDetail> getGameTowerLevel(int towerid) {
		return getBaseDao().getGameTowerLevel(towerid);
	}
}
