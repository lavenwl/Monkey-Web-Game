package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceMapDetail;

public interface IGameRaceMapDao extends IEntityDao<GameRaceMapDetail> {
	List<GameRaceMapDetail> getGameRaceMapDetail(Map<String, Object> map);

	void insertGameRaceMapDetail(GameRaceMapDetail grmd);

	void updateGameRaceMapDetail(GameRaceMapDetail grmd);
}
