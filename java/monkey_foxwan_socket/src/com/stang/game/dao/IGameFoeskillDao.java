package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameFoeDetail;
import com.stang.game.entity.detail.GameFoeskillDetail;

public interface IGameFoeskillDao extends IEntityDao<GameFoeskillDetail> {
	public List<GameFoeskillDetail> getGameFoeskill();
}
