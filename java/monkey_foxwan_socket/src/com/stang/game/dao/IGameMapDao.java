package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameMapDetail;
import com.stang.game.entity.detail.GameMilitaryDetail;

public interface IGameMapDao extends IEntityDao<GameMapDetail> {
	public List<GameMapDetail> getGameMap();
	
	public List<GameMapDetail> findGameMapByid(int id);
}
