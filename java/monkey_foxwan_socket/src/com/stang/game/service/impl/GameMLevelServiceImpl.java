package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGamemlevel;
import com.stang.game.dao.IGameMLevelDao;
import com.stang.game.dao.impl.GameMLevelDaoImpl;
import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.service.IGameMLevelService;

public class GameMLevelServiceImpl extends BaseServiceImpl<GameMLevelDetail>
		implements IGameMLevelService {
	CacheGamemlevel c0;
	private CacheGamemlevel c(){
		if(c0==null){
			c0=new CacheGamemlevel();
		}
		return c0;
		
	}
	
	protected IGameMLevelDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameMLevelDaoImpl();
		}
		return (IGameMLevelDao) baseDao;
	}

	@Override
	public List<GameMLevelDetail> getGameMLevel() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameMLevel();
	}

	@Override
	public List<GameMLevelDetail> getGameMLevelBylevel(int level) {
		return c().getGameMLevelBylevel(level);

		//return getBaseDao().getGameMLevelBylevel(level);
	}

	@Override
	public List<GameMLevelDetail> getGameMLevelByAllexp(int allexp) {
		return getBaseDao().getGameMLevelByAllexp(allexp);
	}
}
