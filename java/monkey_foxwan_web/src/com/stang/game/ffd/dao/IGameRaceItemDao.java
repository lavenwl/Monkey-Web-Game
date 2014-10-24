package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceItemDetail;


public interface IGameRaceItemDao extends IEntityDao<GameRaceItemDetail> {

	List<GameRaceItemDetail> getGameRaceItemDetail(Map<String, Object> map);

	void insertGameRaceItemDetail(GameRaceItemDetail grid);

	void updateGameRaceItemDetail(GameRaceItemDetail grid);

}
