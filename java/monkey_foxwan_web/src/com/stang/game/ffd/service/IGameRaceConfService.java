package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceConfDetail;

public interface IGameRaceConfService extends IBaseService<GameRaceConfDetail> {

	void insertGameRaceConfDetail(GameRaceConfDetail grcd);

	void updateGameRaceConfDetail(GameRaceConfDetail grcd);

	List<GameRaceConfDetail> getGameRaceConfDetail(Map<String, Object> map);

	int getGameRaceConfCount(); 
}
