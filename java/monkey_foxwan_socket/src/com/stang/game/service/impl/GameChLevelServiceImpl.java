package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGameChLevel;
import com.stang.game.dao.IGameChLevelDao;
import com.stang.game.dao.impl.GameChLevelDaoImpl;
import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.service.IGameChLevelService;

public class GameChLevelServiceImpl extends BaseServiceImpl<GameChLevelDetail> implements IGameChLevelService {
	private static CacheGameChLevel c;
	private static CacheGameChLevel getCacheGameChLevel(){
		if(c == null){
			c = new CacheGameChLevel();
		}
		return c;
	}
	protected IGameChLevelDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameChLevelDaoImpl();
		}
		return (IGameChLevelDao) baseDao;
	}

	@Override
	public List<GameChLevelDetail> getGameChLevel() {
		return getBaseDao().getGameChLevel();
	}

	@Override
	public List<GameChLevelDetail> findGameChLevelByparas(
			Map<String, Object> param) {
		//return getBaseDao().findGameChLevelByparas(param);
		return this.getCacheGameChLevel().findGameChLevelByparas(param);
	}

}
