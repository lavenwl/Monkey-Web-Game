package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGameMap;
import com.stang.game.dao.IGameMapDao;
import com.stang.game.dao.impl.GameMapDaoImpl;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.service.IGameMapService;

public class GameMapServiceImpl extends BaseServiceImpl<GameMapDetail>
		implements IGameMapService {
	CacheGameMap c0;
	private CacheGameMap c(){
		if(c0==null){
			c0=new CacheGameMap();
		}
		return c0;
		
	}
	protected IGameMapDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameMapDaoImpl();
		}
		return (IGameMapDao) baseDao;
	}

	@Override
	public List<GameMapDetail> getGameMap() {
		return getBaseDao().getGameMap();
	}

	@Override
	public List<GameMapDetail> findGameMapByid(int id) {
		return c().findGameMapByid(id);

		//return getBaseDao().findGameMapByid(id);
	}
}
