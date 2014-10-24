package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGamePriceDao;
import com.stang.game.dao.impl.GamePriceDaoImpl;
import com.stang.game.entity.detail.GamePriceDetail;
import com.stang.game.service.IGamePriceService;

public class GamePriceServiceImpl extends BaseServiceImpl<GamePriceDetail>
		implements IGamePriceService {
	protected IGamePriceDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GamePriceDaoImpl();
		}
		return (IGamePriceDao) baseDao;
	}

	public List<GamePriceDetail> getAllGamePrice() {
		return getBaseDao().getAllGamePrice();
	}

	public List<GamePriceDetail> getGamePriceById(int resId) {
		return getBaseDao().getGamePriceById(resId);
	}

	public List<GamePriceDetail> getGamePrice(Map<String, Object> param) {
		return getBaseDao().getGamePrice(param);
	}

}
