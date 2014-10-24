package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameMLevelDao;
import com.stang.game.dao.impl.GameMLevelDaoImpl;
import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.service.IGameMLevelService;

public class GameMLevelServiceImpl extends BaseServiceImpl<GameMLevelDetail>
		implements IGameMLevelService {
	protected IGameMLevelDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameMLevelDaoImpl();
		}
		return (IGameMLevelDao) baseDao;
	}



	public List<GameMLevelDetail> getGameMLevelBylevel(int level) {
		return getBaseDao().getGameMLevelBylevel(level);
	}

	public List<GameMLevelDetail> getGameMLevelByAllexp(int allexp) {
		return getBaseDao().getGameMLevelByAllexp(allexp);
	}



	public List<GameMLevelDetail> findAllMLevel(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllMLevel(param);
	}



	public List<GameMLevelDetail> findGameMLevelByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameMLevelByid(id);
	}



	public List<GameMLevelDetail> getGameMLevel() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameMLevel();
	}



	public boolean insertGameMLevel(GameMLevelDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameMLevel(model);
	}



	public boolean updateGameMLevel(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameMLevel(param);
	}
}
