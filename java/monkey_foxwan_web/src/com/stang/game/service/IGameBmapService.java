package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBmapDetail;

public interface IGameBmapService extends IBaseService<GameBmapDetail>{
	public List<GameBmapDetail> getGameBmap();
	public List<GameBmapDetail> findAllBmap(Map<String,Object> param);
	public List<GameBmapDetail> findGameBmapByid(int id);
	public boolean insertGameBmap(GameBmapDetail model);
	public boolean updateGameBmap(Map<String, Object> param);
}
