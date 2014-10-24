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
	
	@Override
	public List<GameRobotDetail> findGameRobot(Map<String, Object> param) {
		//return c.findGameRobot(param);
		return getBaseDao().findGameRobot(param);
	}

	@Override
	public List<GameRobotDetail> findGameRobott(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findGameRobott(param);
	}

	@Override
	public List<GameRobotDetail> findAllGameRobot() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllGameRobot();
	}

}
