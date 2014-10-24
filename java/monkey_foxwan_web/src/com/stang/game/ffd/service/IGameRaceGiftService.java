package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceGiftDetail;

public interface IGameRaceGiftService extends IBaseService<GameRaceGiftDetail> {

	void insertGameRaceGiftDetail(GameRaceGiftDetail grgd);

	void updateGameRaceGiftDetail(GameRaceGiftDetail grgd);

	List<GameRaceGiftDetail> getGameRaceGiftDetail(Map<String, Object> map);

}
