package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameMissionDao;
import com.stang.game.dao.impl.GameMissionDaoImpl;
import com.stang.game.entity.detail.GameMissionDetail;
import com.stang.game.service.IGameMissionService;

public class GameMissionServiceImpl extends BaseServiceImpl<GameMissionDetail> implements IGameMissionService{

	protected IGameMissionDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameMissionDaoImpl();
		}
		return (IGameMissionDao) baseDao;
	}

	public List<GameMissionDetail> findAllMission(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllMission(param);
	}

	public List<GameMissionDetail> findGameMissionByid(int id) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameMissionByid(id);
	}

	public List<GameMissionDetail> getGameMission() {
		// TODO Auto-generated method stub
		return getBaseDao().getGameMission();
	}

	public boolean insertGameMission(GameMissionDetail model) {
		// TODO Auto-generated method stub
		return getBaseDao().insertGameMission(model);
	}

	public boolean updateGameMission(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateGameMission(param);
	}
	
	
}
