package com.stang.game.ffd.service;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.entity.detail.GameRaceRoleDetail;

public interface IGameRaceRoleService extends IBaseService<GameRaceRoleDetail> {

	void insertGameRaceRoleDetail(GameRaceRoleDetail grrd);

	void updateGameRaceRoleDetail(GameRaceRoleDetail grrd);

	List<GameRaceRoleDetail> getGameRaceRoleDetail(Map<String, Object> map);

}
