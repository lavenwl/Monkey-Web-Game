package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGametower;
import com.stang.game.dao.IGameTowerDao;
import com.stang.game.dao.impl.GameTowerDaoImpl;
import com.stang.game.entity.detail.GameTowerDetail;
import com.stang.game.service.IGameTowerService;

public class GameTowerServiceImpl extends BaseServiceImpl<GameTowerDetail>
		implements IGameTowerService {
	CacheGametower c0;
	private CacheGametower c(){
		if(c0==null){
			c0=new CacheGametower();
		}
		return c0;
	}
	protected IGameTowerDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameTowerDaoImpl();
		}
		return (IGameTowerDao) baseDao;
	}

	@Override
	public List<GameTowerDetail> getGameTower() {
		return getBaseDao().getGameTower();
	}

	@Override
	public List<GameTowerDetail> getGameTowerLevel(int towerid) {
		return c().getGameTowerLevel(towerid);
		//return getBaseDao().getGameTowerLevel(towerid);
	}
}
