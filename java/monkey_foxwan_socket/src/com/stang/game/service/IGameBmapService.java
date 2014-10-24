package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBmapDetail;

public interface IGameBmapService extends IBaseService<GameBmapDetail>{

	public List<GameBmapDetail> getGameBmap();
	
	public List<GameBmapDetail> findGameBmapByParams(Map<String,Object> param);
}
