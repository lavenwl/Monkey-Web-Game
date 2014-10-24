package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGameVip;
import com.stang.game.dao.IGameVipDao;
import com.stang.game.dao.impl.GameVipDaoImpl;
import com.stang.game.entity.detail.GameVipDetail;
import com.stang.game.service.IGameVipService;

public class GameVipServiceImpl extends BaseServiceImpl<GameVipDetail>
		implements IGameVipService {
	CacheGameVip c0;
	private CacheGameVip c(){
		if(c0==null){
			c0=new CacheGameVip();
		}
		return c0;
	}
	
	protected IGameVipDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameVipDaoImpl();
		}
		return (IGameVipDao) baseDao;
	}

	@Override
	public List<GameVipDetail> allGameVips() {
		return getBaseDao().allGameVips();
	}

	@Override
	public List<GameVipDetail> getGameVipByLe(int level) {
		return c().getGameVipByLe(level);

		//return getBaseDao().getGameVipByLe(level);
	}

	@Override
	public List<GameVipDetail> getGameVipByAllvipRmb(int vipRmb) {
		return getBaseDao().getGameVipByAllvipRmb(vipRmb);
	}

}
