package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameSkillDao;
import com.stang.game.dao.impl.GameSkillDaoImpl;
import com.stang.game.entity.detail.GameSkillDetail;
import com.stang.game.service.IGameSkillService;

public class GameSkillServiceImpl extends BaseServiceImpl<GameSkillDetail> 
	implements IGameSkillService{
	
	protected IGameSkillDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameSkillDaoImpl();
		}
		return (IGameSkillDao) baseDao;
	}

	public List<GameSkillDetail> findAllSkill(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllSkill(param);
	}

	public List<GameSkillDetail> findGameSkillByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameSkillByid(id);
	}

	public List<GameSkillDetail> getGameSkill() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameSkill();
	}

	public boolean insertGameSkill(GameSkillDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameSkill(model);
	}

	public boolean updateGameSkill(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameSkill(param);
	}



}
