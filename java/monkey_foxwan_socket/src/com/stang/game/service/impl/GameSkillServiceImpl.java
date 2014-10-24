package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGameSkill;
import com.stang.game.dao.IGameSkillDao;
import com.stang.game.dao.impl.GameSkillDaoImpl;
import com.stang.game.entity.detail.GameSkillDetail;
import com.stang.game.service.IGameSkillService;

public class GameSkillServiceImpl extends BaseServiceImpl<GameSkillDetail> 
	implements IGameSkillService{
	CacheGameSkill c0;
	private CacheGameSkill c(){
		if(c0==null){
			c0=new CacheGameSkill();
		}
		return c0;
		
	}
	protected IGameSkillDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameSkillDaoImpl();
		}
		return (IGameSkillDao) baseDao;
	}

	@Override
	public List<GameSkillDetail> getGameSkill() {
		return getBaseDao().getGameSkill();
	}

	@Override
	public List<GameSkillDetail> getGameSkillById(int id) {
		return c().getGameSkillById(id);
		//return getBaseDao().getGameSkillById(id);
	}

}
