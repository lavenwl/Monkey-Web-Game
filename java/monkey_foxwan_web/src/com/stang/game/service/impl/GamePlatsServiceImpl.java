package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGamePlatsDao;
import com.stang.game.dao.impl.GamePlatsDaoImpl;
import com.stang.game.entity.detail.GamePlatsDetail;
import com.stang.game.service.IGamePlatsService;

public class GamePlatsServiceImpl extends BaseServiceImpl<GamePlatsDetail>
		implements IGamePlatsService {
	protected IGamePlatsDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GamePlatsDaoImpl();
		}
		return (IGamePlatsDao) baseDao;
	}

	public List<GamePlatsDetail> findAllPlat(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllPlat(param);
	}

	public List<GamePlatsDetail> findGamePlatByid(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findGamePlatByid(param);
	}

	public List<GamePlatsDetail> getGamePlat() {
		// TODO Auto-generated method stub
		return getBaseDao().getGamePlat();
	}

	public boolean insertGameplat(GamePlatsDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameplat(model);
	}

	public boolean updateGameplat(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameplat(param);
	}


}
