package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGameEquip;
import com.stang.game.dao.IGameEquipDao;
import com.stang.game.dao.impl.GameEquipDaoImpl;
import com.stang.game.entity.detail.GameEquipDetail;
import com.stang.game.service.IGameEquipService;

public class GameEquipServiceImpl extends BaseServiceImpl<GameEquipDetail>
		implements IGameEquipService {
	CacheGameEquip c0;
	private CacheGameEquip c(){
		if(c0==null){
			c0=new CacheGameEquip();
		}
		return c0;
	}
	protected IGameEquipDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameEquipDaoImpl();
		}
		return (IGameEquipDao) baseDao;
	}

	@Override
	public List<GameEquipDetail> getGameEquip() {
		return getBaseDao().getGameEquip();

	}

	@Override
	public List<GameEquipDetail> getGameEquipById(int id) {
		return c().getGameEquipById(id);
		//return getBaseDao().getGameEquipById(id);
	}

	@Override
	public List<GameEquipDetail> getGameEquipByEid(int eid) {
		return c().getGameEquipById(eid);
		//return getBaseDao().getGameEquipByEid(eid);
	}

}
