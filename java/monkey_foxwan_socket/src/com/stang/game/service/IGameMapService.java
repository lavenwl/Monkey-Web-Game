package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameMapDetail;

public interface IGameMapService extends IBaseService<GameMapDetail> {
	public List<GameMapDetail> getGameMap();
	
	public List<GameMapDetail> findGameMapByid(int id);
}
