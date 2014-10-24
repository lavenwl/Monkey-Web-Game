package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameFoeDetail;

public interface IGameFoeDao extends IEntityDao<GameFoeDetail> {
	public List<GameFoeDetail> getGameFoe();
}
