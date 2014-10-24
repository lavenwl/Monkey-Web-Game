package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameBuffDao;
import com.stang.game.dao.impl.GameBuffDaoImpl;
import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.service.IGameBuffService;

public class GameBuffServiceImpl extends BaseServiceImpl<GameBuffDetail> 
	implements IGameBuffService{
	
	protected IGameBuffDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameBuffDaoImpl();
		}
		return (IGameBuffDao) baseDao;
	}

	public List<GameBuffDetail> findAllBuff(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllBuff(param);
	}

	public List<GameBuffDetail> findGameBuffByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameBuffByid(id);
	}

	public List<GameBuffDetail> getGameBuff() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameBuff();
	}

	public boolean insertGameBuff(GameBuffDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameBuff(model);
	}

	public boolean updateGameBuff(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameBuff(param);
	}
	
	

}
