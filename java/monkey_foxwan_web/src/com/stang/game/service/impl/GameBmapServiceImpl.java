package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameBmapDao;
import com.stang.game.dao.impl.GameBmapDaoImpl;
import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.service.IGameBmapService;

public class GameBmapServiceImpl extends BaseServiceImpl<GameBmapDetail> implements IGameBmapService{

	protected IGameBmapDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameBmapDaoImpl();
		}
		return (IGameBmapDao) baseDao;
	}

	public List<GameBmapDetail> findAllBmap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllBmap(param);
	}

	public List<GameBmapDetail> findGameBmapByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameBmapByid(id);
	}

	public List<GameBmapDetail> getGameBmap() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameBmap();
	}

	public boolean insertGameBmap(GameBmapDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameBmap(model);
	}

	public boolean updateGameBmap(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameBmap(param);
	}
	
	

}
