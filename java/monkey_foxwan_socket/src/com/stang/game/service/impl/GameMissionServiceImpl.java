package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheGameMission;
import com.stang.game.dao.IGameMissionDao;
import com.stang.game.dao.impl.GameMissionDaoImpl;
import com.stang.game.entity.detail.GameMissionDetail;
import com.stang.game.service.IGameMissionService;

public class GameMissionServiceImpl extends BaseServiceImpl<GameMissionDetail> implements IGameMissionService{
   CacheGameMission c0;
   private CacheGameMission c(){
   if(c0==null){
	   c0=new CacheGameMission();
   }
   return c0;
   }
	protected IGameMissionDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameMissionDaoImpl();
		}
		return (IGameMissionDao) baseDao;
	}
	
	@Override
	public List<GameMissionDetail> getGameMission() {
		return getBaseDao().getGameMission();
	}

	@Override
	public List<GameMissionDetail> findGameMissionById(int id) {
		return c().findGameMissionById(id);
		//return getBaseDao().findGameMissionById(id);
	}

}
