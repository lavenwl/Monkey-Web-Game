package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGameLevel;
import com.stang.game.dao.IGameLevelDao;
import com.stang.game.dao.impl.GameLevelDaoImpl;
import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.service.IGameLevelService;

public class GameLevelServiceImpl extends BaseServiceImpl<GameLevelDetail>
		implements IGameLevelService {
	CacheGameLevel c0;
	private CacheGameLevel c(){
	if(c0==null){
		c0=new CacheGameLevel();
	}
		return c0;
		
	}
	@Override
	public List<GameLevelDetail> findAllGameLevel() {
		return getBaseDao().findAllGameLevel();
	}
	
	protected IGameLevelDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameLevelDaoImpl();
		}
		return (IGameLevelDao) baseDao;
	}

	public GameLevelDetail getGameLevelDetail(Map param) {
		return getBaseDao().getModel(param);
	}

	public List<GameLevelDetail> allGameLevelDetail() {
		return c().allGameLevelDetail();
		//return getBaseDao().allGameLevelDetail();
	}

	public GameLevelDetail getGameLevelByRoleLevel(Integer roleLevel) {
		//return getBaseDao().getGameLevelByRoleLevel(roleLevel);
		return c().getGameLevelByRoleLevel(roleLevel);
	}

	@Override
	public List<GameLevelDetail> getGaemLevelByParams(Map<String, Object> param) {
		return c().getGaemLevelByParams(param);
		//return getBaseDao().getGaemLevelByParams(param);
	}

}
