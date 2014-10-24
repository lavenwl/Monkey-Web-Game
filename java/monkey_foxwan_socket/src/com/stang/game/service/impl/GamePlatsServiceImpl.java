package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGamePlat;
import com.stang.game.dao.IGamePlatsDao;
import com.stang.game.dao.impl.GamePlatsDaoImpl;
import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.service.IGamePlatsService;

public class GamePlatsServiceImpl extends BaseServiceImpl<GamePlatsDetail>
		implements IGamePlatsService {
	CacheGamePlat c0;
	private CacheGamePlat c(){
		if(c0==null){
			c0=new CacheGamePlat();
		}
		return c0;
		
	}
	protected IGamePlatsDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GamePlatsDaoImpl();
		}
		return (IGamePlatsDao) baseDao;
	}

	@Override
	public List<GamePlatsDetail> getGamePlats() {
		return getBaseDao().getGamePlats();
	}

	@Override
	public List<GamePlatsDetail> findGamePlatByparams(Map<String, Object> param) {
		return c().findGamePlatByparams(param);

		//return getBaseDao().findGamePlatByparams(param);
	}
}
