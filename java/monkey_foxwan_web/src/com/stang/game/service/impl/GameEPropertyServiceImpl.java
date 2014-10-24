package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameEPropertyDao;
import com.stang.game.dao.impl.GameEPropertyDaoImpl;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.service.IGameEPropertyService;

public class GameEPropertyServiceImpl extends BaseServiceImpl<GameEPropertyDetail>
    implements IGameEPropertyService {
	
	protected IGameEPropertyDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameEPropertyDaoImpl();
		}
		return (IGameEPropertyDao)baseDao;
	}

	public List<GameEPropertyDetail> findAllEProperty(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllEProperty(param);
	}

	public List<GameEPropertyDetail> findGameEPropertyByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameEPropertyByid(id);
	}

	public List<GameEPropertyDetail> getGameEProperty() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameEProperty();
	}

	public boolean insertGameEProperty(GameEPropertyDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameEProperty(model);
	}

	public boolean updateGameEProperty(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameEProperty(param);
	}

	
	
}
