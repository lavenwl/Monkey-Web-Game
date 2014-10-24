package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IGameFoeDao;
import com.stang.game.dao.IGameFoeskillDao;
import com.stang.game.dao.impl.GameFoeDaoImpl;
import com.stang.game.dao.impl.GameFoeskillDaoImpl;
import com.stang.game.entity.detail.GameFoeDetail;
import com.stang.game.entity.detail.GameFoeskillDetail;
import com.stang.game.service.IGameFoeService;
import com.stang.game.service.IGameFoeskillService;

public class GameFoeskillServiceImpl extends BaseServiceImpl<GameFoeskillDetail>
		implements IGameFoeskillService {
	protected IGameFoeskillDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameFoeskillDaoImpl();
		}
		return (IGameFoeskillDao) baseDao;
	}

	@Override
	public List<GameFoeskillDetail> getGameFoeskill() {
		return getBaseDao().getGameFoeskill();
	}

}
