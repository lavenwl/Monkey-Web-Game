package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.entity.detail.GameBingDetail;

public interface IGameBingService extends IBaseService<GameBingDetail>{
	public List<GameBingDetail> getGameBing();
	public List<GameBingDetail> findAllBing(Map<String,Object> param);
	public List<GameBingDetail> findGameBingByid(int id);
	public boolean insertGameBing(GameBingDetail model);
	public boolean updateGamebing(Map<String, Object> param);
}
