package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameFoeDao;
import com.stang.game.dao.impl.GameFoeDaoImpl;
import com.stang.game.entity.detail.GameFoeDetail;
import com.stang.game.service.IGameFoeService;

public class GameFoeServiceImpl extends BaseServiceImpl<GameFoeDetail>
		implements IGameFoeService {
	protected IGameFoeDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameFoeDaoImpl();
		}
		return (IGameFoeDao) baseDao;
	}

	public List<GameFoeDetail> findAllFoe(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllFoe(param);
	}

	public List<GameFoeDetail> findGameFoeByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameFoeByid(id);
	}

	public List<GameFoeDetail> getGameFoe() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameFoe();
	}

	public boolean insertGameFoe(GameFoeDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameFoe(model);
	}

	public boolean updateGameFoe(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameFoe(param);
	}

	

}
