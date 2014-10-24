package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameAstrologyBagDao;
import com.stang.game.ffd.dao.impl.GameAstrologyBagDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGameAstrologyBagDetail;
import com.stang.game.ffd.service.IGameAstrologyBagService;

public class GameAstrologyBagServiceImpl extends BaseServiceImpl<EntityGameAstrologyBagDetail> implements 
IGameAstrologyBagService{
	
	public IGameAstrologyBagDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new GameAstrologyBagDaoImpl();
		}
		return (IGameAstrologyBagDao)baseDao;
	}
		
	public int addGameAstrologyBag(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<EntityGameAstrologyBagDetail> findAllGameAstrologyBag(
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateGameAstrologyBag(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
