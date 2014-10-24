package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceMapDetail;

public interface IGameRaceMapService extends IBaseService<GameRaceMapDetail> {
	void insertGameRaceMapDetail(GameRaceMapDetail grid);

	void updateGameRaceMapDetail(GameRaceMapDetail grid);

	List<GameRaceMapDetail> getGameRaceMapDetail(Map<String, Object> map);
}
