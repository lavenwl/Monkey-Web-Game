package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceGiftDetail;


public interface IGameRaceGiftDao extends IEntityDao<GameRaceGiftDetail> {

	List<GameRaceGiftDetail> getGameRaceGiftDetail(Map<String, Object> map);

	void insertGameRaceGiftDetail(GameRaceGiftDetail grgd);

	void updateGameRaceGiftDetail(GameRaceGiftDetail grgd);

}
