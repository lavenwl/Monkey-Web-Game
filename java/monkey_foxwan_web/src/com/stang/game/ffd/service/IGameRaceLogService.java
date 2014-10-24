package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceLogDetail;

public interface IGameRaceLogService extends IBaseService<GameRaceLogDetail> {

	void insertGameRaceLogDetail(GameRaceLogDetail grld);

	void updateGameRaceLogDetail(GameRaceLogDetail grld);

	List<GameRaceLogDetail> getGameRaceLogDetail(Map<String, Object> map);

}
