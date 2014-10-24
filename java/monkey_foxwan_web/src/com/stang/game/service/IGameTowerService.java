package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameTowerDetail;

public interface IGameTowerService extends IBaseService<GameTowerDetail> {
	public List<GameTowerDetail> getGameTower();

	public List<GameTowerDetail> getGameTowerLevel(int towerid);
}
