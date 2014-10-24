package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IGameAstrologyCapacityDao;
import com.stang.game.ffd.dao.impl.GameAstrologyCapacityDaoImpl;
import com.stang.game.ffd.entity.detail.EntityGameAstrologyCapacityDetail;
import com.stang.game.ffd.service.IGameAstrologyCapacityService;

public class GameAstrologyCapacityServiceImpl extends BaseServiceImpl<EntityGameAstrologyCapacityDetail>
implements IGameAstrologyCapacityService{
	
	public IGameAstrologyCapacityDao getBaseDao(){
		if(this.baseDao==null){
			baseDao = new GameAstrologyCapacityDaoImpl();
		}
		return (IGameAstrologyCapacityDao)baseDao;
	}
	public int addGameAstrologyCapacity(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<EntityGameAstrologyCapacityDetail> findAllGameAstrologyCapacity(
			Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateGameAstrologyCapacity(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
