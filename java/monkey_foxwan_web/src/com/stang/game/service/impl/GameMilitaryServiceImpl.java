package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameMilitaryDao;
import com.stang.game.dao.impl.GameMilitaryDaoImpl;
import com.stang.game.entity.detail.GameMilitaryDetail;
import com.stang.game.service.IGameMilitaryService;

public class GameMilitaryServiceImpl extends
		BaseServiceImpl<GameMilitaryDetail> implements IGameMilitaryService {
	protected IGameMilitaryDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameMilitaryDaoImpl();
		}
		return (IGameMilitaryDao) baseDao;
	}

	public List<GameMilitaryDetail> findAllMilitary(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllMilitary(param);
	}

	public List<GameMilitaryDetail> findGameMilitaryByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameMilitaryByid(id);
	}

	public List<GameMilitaryDetail> getGameMilitary() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameMilitary();
	}

	public boolean insertGameMilitary(GameMilitaryDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameMilitary(model);
	}

	public boolean updateGameMilitary(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameMilitary(param);
	}


}
