package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameRobotDetail;

public interface IGameRobotDao extends IEntityDao<GameRobotDetail>{

	public List<GameRobotDetail> findGameRobot(Map<String, Object> param);
}
