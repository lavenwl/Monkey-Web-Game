package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameFoeDetail;

public interface IGameFoeService extends IBaseService<GameFoeDetail> {
	public List<GameFoeDetail> getGameFoe();
}
