package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameBingDao;
import com.stang.game.dao.impl.GameBingDaoImpl;
import com.stang.game.entity.detail.GameBingDetail;
import com.stang.game.service.IGameBingService;

public class GameBingServiceImpl extends BaseServiceImpl<GameBingDetail> implements IGameBingService{

	protected IGameBingDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameBingDaoImpl();
		}
		return (IGameBingDao) baseDao;
	}

	public List<GameBingDetail> findAllBing(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllBing(param);
	}

	public List<GameBingDetail> findGameBingByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameBingByid(id);
	}

	public List<GameBingDetail> getGameBing() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameBing();
	}

	public boolean insertGameBing(GameBingDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameBing(model);
	}

	public boolean updateGamebing(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGamebing(param);
	}
	
	

}
