package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameMapDao;
import com.stang.game.dao.impl.GameMapDaoImpl;
import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.service.IGameMapService;

public class GameMapServiceImpl extends BaseServiceImpl<GameMapDetail>
		implements IGameMapService {
	protected IGameMapDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameMapDaoImpl();
		}
		return (IGameMapDao) baseDao;
	}

	public List<GameMapDetail> getGameMap() {
		return getBaseDao().getGameMap();
	}

	public List<GameMapDetail> findGameMapByid(int id) {
		return getBaseDao().findGameMapByid(id);
	}

	public List<GameMapDetail> findAllMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllMap(param);
	}

	public boolean insertGameMap(GameMapDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameMap(model);
	}

	public boolean updateGameMap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameMap(param);
	}
}
