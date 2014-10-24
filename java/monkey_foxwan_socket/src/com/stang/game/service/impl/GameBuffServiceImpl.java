package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGameBuff;
import com.stang.game.dao.IGameBuffDao;
import com.stang.game.dao.impl.GameBuffDaoImpl;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.service.IGameBuffService;

public class GameBuffServiceImpl extends BaseServiceImpl<GameBuffDetail> 
	implements IGameBuffService{
	CacheGameBuff c0;
	private CacheGameBuff c(){
		if(c0==null){
			c0=new CacheGameBuff();
		}
		return c0;
	}
	protected IGameBuffDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameBuffDaoImpl();
		}
		return (IGameBuffDao) baseDao;
	}
	
	@Override
	public List<GameBuffDetail> getGameBuff() {
		return getBaseDao().getGameBuff();
	}

	@Override
	public List<GameBuffDetail> getGameBuffById(int id) {
		//return getBaseDao().getGameBuffById(id);
          return c().getGameBuffId(id);
	}

}
