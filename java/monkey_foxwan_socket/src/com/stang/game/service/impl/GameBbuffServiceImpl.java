package com.stang.game.service.impl;

import java.util.List;

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
	
	@Override
	public List<GameBbuffDetail> getGameBbuff() {
		return getBaseDao().getGameBbuff();
	}

}
