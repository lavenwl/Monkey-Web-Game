package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGameBmap;
import com.stang.game.dao.IGameBmapDao;
import com.stang.game.dao.impl.GameBmapDaoImpl;
import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.service.IGameBmapService;

public class GameBmapServiceImpl extends BaseServiceImpl<GameBmapDetail> implements IGameBmapService{
     CacheGameBmap c0;
     private CacheGameBmap c(){
    	 if(c0==null){
    		 c0=new CacheGameBmap();
    	 }
		return c0;
    	 
     }
	protected IGameBmapDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameBmapDaoImpl();
		}
		return (IGameBmapDao) baseDao;
	}
	
	@Override
	public List<GameBmapDetail> getGameBmap() {
		return getBaseDao().getGameBmap();
	}

	@Override
	public List<GameBmapDetail> findGameBmapByParams(Map<String, Object> param) {
		//return getBaseDao().findGameBmapByParams(param);
		return c().findGameBmapByParams(param);
	}

}
