package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameRobotDetail;

public interface IGameRobotService extends IBaseService<GameRobotDetail>{

	public List<GameRobotDetail> findGameRobot(Map<String, Object> param);
}
