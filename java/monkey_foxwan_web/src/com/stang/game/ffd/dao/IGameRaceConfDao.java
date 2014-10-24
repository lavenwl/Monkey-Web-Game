package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceConfDetail;


public interface IGameRaceConfDao extends IEntityDao<GameRaceConfDetail> {

	List<GameRaceConfDetail> getGameRaceConfDetail(Map<String, Object> map);
	
	void insertGameRaceConfDetail(GameRaceConfDetail grcd);

	void updateGameRaceConfDetail(GameRaceConfDetail grcd);

	int getGameRaceConfCount();

}
