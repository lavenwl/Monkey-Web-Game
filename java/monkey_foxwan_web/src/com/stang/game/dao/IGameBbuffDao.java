package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBuffDetail;

public interface IGameBbuffDao extends IEntityDao<GameBbuffDetail>{
	public List<GameBbuffDetail> getGameBbuff();
	public List<GameBbuffDetail> findAllBbuff(Map<String,Object> param);
	public List<GameBbuffDetail> findGameBbuffByid(int id);
	public boolean insertGameBbuff(GameBbuffDetail model);
	public boolean updateGameBbuff(Map<String, Object> param);
}
