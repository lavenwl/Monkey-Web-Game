package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGameEIns;
import com.stang.game.dao.IGameEInsDao;
import com.stang.game.dao.impl.GameEInsDaoImpl;
import com.stang.game.entity.detail.GameEInsDetail;
import com.stang.game.service.IGameEInsService;
public class GameEInsServiceImpl  extends BaseServiceImpl<GameEInsDetail>
   implements IGameEInsService{
	CacheGameEIns c0;
	private CacheGameEIns c(){
		if(c0==null){
			c0=new CacheGameEIns();
		}
		return c0;
		
	}
	protected IGameEInsDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameEInsDaoImpl();
		}
		return (IGameEInsDao) baseDao;
	}
	

	@Override
	public List<GameEInsDetail> getGameEIns() {
		return getBaseDao().getGameEIns();
	}

	@Override
	public List<GameEInsDetail> getGameEInsById(int id) {
		//return getBaseDao().getGameEInsById(id);
		return c().getGameEInsById(id);
	}

}
