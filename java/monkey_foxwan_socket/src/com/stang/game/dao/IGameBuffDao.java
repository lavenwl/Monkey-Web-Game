package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameBuffDetail;

public interface IGameBuffDao extends IEntityDao<GameBuffDetail>{
	public List<GameBuffDetail> getGameBuff();
	
	public List<GameBuffDetail> getGameBuffById(int id);
}
