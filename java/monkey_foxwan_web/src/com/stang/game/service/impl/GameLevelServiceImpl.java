package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameLevelDao;
import com.stang.game.dao.impl.GameLevelDaoImpl;
import com.stang.game.entity.detail.GameLevelDetail;
import com.stang.game.service.IGameLevelService;

public class GameLevelServiceImpl extends BaseServiceImpl<GameLevelDetail>
		implements IGameLevelService {
	protected IGameLevelDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameLevelDaoImpl();
		}
		return (IGameLevelDao) baseDao;
	}

	public List<GameLevelDetail> findAllLevel(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllLevel(param);
	}

	public List<GameLevelDetail> findGameLevelByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameLevelByid(id);
	}

	public List<GameLevelDetail> getGameLevel() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameLevel();
	}

	public boolean insertGameLevel(GameLevelDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameLevel(model);
	}

	public boolean updateGameLevel(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameLevel(param);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	public List<GameLevelDetail> allGameLevelDetail() {
		return getBaseDao().allGameLevelDetail();
	}

	

	public GameLevelDetail getGameLevelByRoleLevel(int roleLevel) {
		// TODO Auto-generated method stub
		return getBaseDao().getGameLevelByRoleLevel(roleLevel);
	}

}
