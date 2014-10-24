package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGameStar;
import com.stang.game.dao.IGameStarDao;
import com.stang.game.dao.impl.GameStarDaoImpl;
import com.stang.game.entity.detail.GameStarDetail;
import com.stang.game.service.IGameStarService;

public class GameStarServiceImpl extends BaseServiceImpl<GameStarDetail> implements IGameStarService{
    CacheGameStar c0;
    private CacheGameStar c(){
    	if(c0==null){
    		c0=new CacheGameStar();
    	}
		return c0;
    }
    
//	protected IDantiaoDao getBaseDao(){
//		if(baseDao == null){
//			baseDao = new DantiaoDaoImpl();
//		}
//		return (IDantiaoDao) baseDao;
//	}
	protected IGameStarDao getBaseDao(){
		if(baseDao==null){
			baseDao=new GameStarDaoImpl();
		}
		return (IGameStarDao) baseDao;
	}
	
	@Override
	public List<GameStarDetail> getgamestars(int starlevel) {
		// TODO Auto-generated method stub
		return c().getgamestars(starlevel);
		//return getBaseDao().getgamestars(starlevel);
	}

	@Override
	public List<GameStarDetail> getallgamestar() {
		// TODO Auto-generated method stub
		return getBaseDao().getallgamestar();
	}

}
