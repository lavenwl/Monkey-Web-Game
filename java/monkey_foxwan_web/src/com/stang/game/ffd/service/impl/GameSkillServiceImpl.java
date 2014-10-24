package com.stang.game.ffd.service.impl;

import java.util.List;

import com.stang.game.ffd.service.IGameSkillService;
import com.stang.game.ffd.dao.IGameSkillDao;
import com.stang.game.ffd.dao.impl.GameSkillDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGameSkillDetail;

public class GameSkillServiceImpl extends BaseServiceImpl<EntityGameSkillDetail> implements IGameSkillService {
	public IGameSkillDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new GameSkillDaoImpl();
		}
		return (IGameSkillDao)baseDao;
	}
	
	public List<EntityGameSkillDetail> getAllInfo(){
		return this.getBaseDao().getAllInfo();
	}
}
