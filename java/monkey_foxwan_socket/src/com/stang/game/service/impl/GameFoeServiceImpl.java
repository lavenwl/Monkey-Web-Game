package com.stang.game.service.impl;

import java.util.List;

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

	@Override
	public List<GameFoeDetail> getGameFoe() {
		return getBaseDao().getGameFoe();
	}

}
