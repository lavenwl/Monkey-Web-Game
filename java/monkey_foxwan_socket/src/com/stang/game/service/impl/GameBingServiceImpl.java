package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGameBing;
import com.stang.game.dao.IGameBingDao;
import com.stang.game.dao.impl.GameBingDaoImpl;
import com.stang.game.entity.detail.GameBingDetail;
import com.stang.game.service.IGameBingService;

public class GameBingServiceImpl extends BaseServiceImpl<GameBingDetail> implements IGameBingService{
    CacheGameBing c0;
    private CacheGameBing c(){
    	if(c0==null){
    		c0=new CacheGameBing();
    	}
    	return c0;
    }
	protected IGameBingDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameBingDaoImpl();
		}
		return (IGameBingDao) baseDao;
	}
	
	@Override
	public List<GameBingDetail> getGameBing() {
		return getBaseDao().getGameBing();
	}

	@Override
	public List<GameBingDetail> getGameBingById(Map<String,Object> param) {
		//return getBaseDao().getGameBingById(param);
		return c().getGameBingById(param);
	}

}
