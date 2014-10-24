package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameChLevelDao;
import com.stang.game.dao.impl.GameChLevelDaoImpl;
import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.service.IGameChLevelService;

public class GameChLevelServiceImpl extends BaseServiceImpl<GameChLevelDetail>
		implements IGameChLevelService {
	protected IGameChLevelDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameChLevelDaoImpl();
		}
		return (IGameChLevelDao) baseDao;
	}

	public List<GameChLevelDetail> findAllChlevel(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllChlevel(param);
	}

	public List<GameChLevelDetail> findGameChlevelByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameChlevelByid(id);
	}

	public List<GameChLevelDetail> getGameChlevel() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameChlevel();
	}

	public boolean insertGameCHLevel(GameChLevelDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameCHLevel(model);
	}

	public boolean updateGameGameCHLevel(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameGameCHLevel(param);
	}



}
