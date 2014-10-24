package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBmapDetail;

public interface IGameBmapDao extends IEntityDao<GameBmapDetail>{

	public List<GameBmapDetail> getGameBmap();
	
	public List<GameBmapDetail> findGameBmapByParams(Map<String,Object> param);
}
