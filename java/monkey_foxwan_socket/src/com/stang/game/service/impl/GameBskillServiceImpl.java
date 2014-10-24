package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.dao.IGameBskillDao;
import com.stang.game.dao.impl.GameBskillDaoImpl;
import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.service.IGameBskillService;

public class GameBskillServiceImpl extends BaseServiceImpl<GameBskillDetail> implements IGameBskillService{

	protected IGameBskillDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameBskillDaoImpl();
		}
		return (IGameBskillDao) baseDao;
	}
	
	@Override
	public List<GameBskillDetail> getGameBskill() {
		return getBaseDao().getGameBskill();
	}
}
