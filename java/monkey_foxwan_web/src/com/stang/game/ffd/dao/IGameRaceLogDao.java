package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceLogDetail;


public interface IGameRaceLogDao extends IEntityDao<GameRaceLogDetail> {

	List<GameRaceLogDetail> getGameRaceLogDetail(Map<String, Object> map);

	void insertGameRaceLogDetail(GameRaceLogDetail grld);

	void updateGameRaceLogDetail(GameRaceLogDetail grld);

}
