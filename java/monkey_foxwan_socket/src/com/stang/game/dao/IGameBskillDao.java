package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameBskillDetail;

public interface IGameBskillDao extends IEntityDao<GameBskillDetail>{

	public List<GameBskillDetail> getGameBskill();
}
