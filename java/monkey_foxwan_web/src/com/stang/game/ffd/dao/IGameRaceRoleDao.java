package com.stang.game.ffd.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceRoleDetail;


public interface IGameRaceRoleDao extends IEntityDao<GameRaceRoleDetail> {

	List<GameRaceRoleDetail> getGameRaceRoleDetail(Map<String, Object> map);

	void insertGameRaceRoleDetail(GameRaceRoleDetail grrd);

	void updateGameRaceRoleDetail(GameRaceRoleDetail grrd);

}
