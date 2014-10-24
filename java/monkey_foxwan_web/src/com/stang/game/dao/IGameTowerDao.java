package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameTowerDetail;

public interface IGameTowerDao extends IEntityDao<GameTowerDetail> {
	public List<GameTowerDetail> getGameTower();

	public List<GameTowerDetail> getGameTowerLevel(int towerid);
}
