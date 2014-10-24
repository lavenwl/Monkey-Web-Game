package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceItemDetail;

public interface IGameRaceItemService extends IBaseService<GameRaceItemDetail> {

	void insertGameRaceItemDetail(GameRaceItemDetail grid);

	void updateGameRaceItemDetail(GameRaceItemDetail grid);

	List<GameRaceItemDetail> getGameRaceItemDetail(Map<String, Object> map);

}
