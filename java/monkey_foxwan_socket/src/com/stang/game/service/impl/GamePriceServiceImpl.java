package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGamePrice;
import com.stang.game.dao.IGamePriceDao;
import com.stang.game.dao.impl.GamePriceDaoImpl;
import com.stang.game.entity.detail.GamePriceDetail;
import com.stang.game.service.IGamePriceService;

public class GamePriceServiceImpl extends BaseServiceImpl<GamePriceDetail>
		implements IGamePriceService {
	CacheGamePrice c0;
	private CacheGamePrice c(){
		if(c0==null){
			c0=new CacheGamePrice();
		}
		return c0;
		
	}
	protected IGamePriceDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GamePriceDaoImpl();
		}
		return (IGamePriceDao) baseDao;
	}

	@Override
	public List<GamePriceDetail> getAllGamePrice() {
		return getBaseDao().getAllGamePrice();
	}

	@Override
	public List<GamePriceDetail> getGamePriceById(int resId) {
		return c().getGamePriceById(resId);
		//return getBaseDao().getGamePriceById(resId);
	}

	@Override
	public List<GamePriceDetail> getGamePrice(Map<String, Object> param) {
		//return getBaseDao().getGamePrice(param);
		return c().getGamePrice(param);
	}

}
