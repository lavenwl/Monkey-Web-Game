package com.stang.game.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.stang.game.common.GameConstants;
import com.stang.game.dao.IGameRobotDao;
import com.stang.game.entity.detail.GameRobotDetail;
import com.stang.game.entity.detail.RoleQuicktimeDetail;

public class GameRobotDaoImpl extends EntityDao<GameRobotDetail> implements
		IGameRobotDao {

	@Override
	public List<GameRobotDetail> findGameRobot(Map<String, Object> param) {
		List<GameRobotDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameRobot", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRobotDetail> findGameRobott(Map<String, Object> param) {
		List<GameRobotDetail> list = null;
		try {
			list = sqlMapper.queryForList("findGameRobott", param);
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	@Override
	public List<GameRobotDetail> findAllGameRobot() {
		List<GameRobotDetail> list = null;
		try {
			list = sqlMapper.queryForList("findAllGameRobot");
		} catch (SQLException e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

}
