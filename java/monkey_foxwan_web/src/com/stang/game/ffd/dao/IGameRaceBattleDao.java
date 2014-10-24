package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceBattleDetail;


public interface IGameRaceBattleDao extends IEntityDao<GameRaceBattleDetail> {

	List<GameRaceBattleDetail> getGameRaceBattleDetail(Map<String, Object> map);

	void insertGameRaceBattleDetail(GameRaceBattleDetail grbd);

	void updateGameRaceBattleDetail(GameRaceBattleDetail grbd);

}
