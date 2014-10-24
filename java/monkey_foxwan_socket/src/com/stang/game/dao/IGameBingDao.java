package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBingDetail;

public interface IGameBingDao extends IEntityDao<GameBingDetail>{

	public List<GameBingDetail> getGameBing();
	
	public List<GameBingDetail> getGameBingById(Map<String,Object> param);
}
