package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IGameRobotDao;
import com.stang.game.dao.impl.GameRobotDaoImpl;
import com.stang.game.entity.detail.GameRobotDetail;
import com.stang.game.service.IGameRobotService;

public class GameRobotServiceImpl extends BaseServiceImpl<GameRobotDetail>
		implements IGameRobotService {

	protected IGameRobotDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameRobotDaoImpl();
		}
		return (IGameRobotDao) baseDao;
	}
	
	public List<GameRobotDetail> findGameRobot(Map<String, Object> param) {
		return getBaseDao().findGameRobot(param);
	}

}
