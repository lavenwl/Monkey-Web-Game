package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameBskillDetail;

public interface IGameBskillService extends IBaseService<GameBskillDetail>{

	public List<GameBskillDetail> getGameBskill();
}
