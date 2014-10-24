package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameFoeskillDetail;

public interface IGameFoeskillService extends IBaseService<GameFoeskillDetail> {
	public List<GameFoeskillDetail> getGameFoeskill();
}
