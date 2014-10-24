package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameBbuffDao;
import com.stang.game.dao.impl.GameBbuffDaoImpl;
import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.service.IGameBbuffService;


public class GameBbuffServiceImpl extends BaseServiceImpl<GameBbuffDetail> implements IGameBbuffService{

	protected IGameBbuffDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameBbuffDaoImpl();
		}
		return (IGameBbuffDao) baseDao;
	}

	public List<GameBbuffDetail> findAllBbuff(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllBbuff(param);
	}

	public List<GameBbuffDetail> findGameBbuffByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameBbuffByid(id);
	}

	public List<GameBbuffDetail> getGameBbuff() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameBbuff();
	}

	public boolean insertGameBbuff(GameBbuffDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameBbuff(model);
	}

	public boolean updateGameBbuff(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameBbuff(param);
	}
	
	

}
