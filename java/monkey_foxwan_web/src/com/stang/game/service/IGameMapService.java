package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameMapDetail;

public interface IGameMapService extends IBaseService<GameMapDetail> {
	public List<GameMapDetail> getGameMap();

	public List<GameMapDetail> findAllMap(Map<String,Object> param);
	public List<GameMapDetail> findGameMapByid(int id);
	public boolean insertGameMap(GameMapDetail model);
	public boolean updateGameMap(Map<String, Object> param);
}
