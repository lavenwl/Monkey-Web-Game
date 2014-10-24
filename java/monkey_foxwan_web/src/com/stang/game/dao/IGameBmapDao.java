package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBmapDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public interface IGameBmapDao extends IEntityDao<GameBmapDetail>{
	public List<GameBmapDetail> getGameBmap();
	public List<GameBmapDetail> findAllBmap(Map<String,Object> param);
	public List<GameBmapDetail> findGameBmapByid(int id);
	public boolean insertGameBmap(GameBmapDetail model);
	public boolean updateGameBmap(Map<String, Object> param);
}
