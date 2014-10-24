package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceBattleDetail;

public interface IGameRaceBattleService extends
		IBaseService<GameRaceBattleDetail> {

	void insertGameRaceBattleDetail(GameRaceBattleDetail grbd);

	void updateGameRaceBattleDetail(GameRaceBattleDetail grbd);

	List<GameRaceBattleDetail> getGameRaceBattleDetail(Map<String, Object> map);

}
