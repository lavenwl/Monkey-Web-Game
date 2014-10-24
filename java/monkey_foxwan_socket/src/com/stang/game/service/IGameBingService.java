package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBingDetail;

public interface IGameBingService extends IBaseService<GameBingDetail>{

	public List<GameBingDetail> getGameBing();
	
	public List<GameBingDetail> getGameBingById(Map<String,Object> param);
}
