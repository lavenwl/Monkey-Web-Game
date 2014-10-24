package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameEPropertyDetail;
public interface IGameEPropertyDao  extends IEntityDao<GameEPropertyDetail>{
	public List<GameEPropertyDetail> getGameEProperty();
	public List<GameEPropertyDetail> findAllEProperty(Map<String,Object> param);
	public List<GameEPropertyDetail> findGameEPropertyByid(int id);
	public boolean insertGameEProperty(GameEPropertyDetail model);
	public boolean updateGameEProperty(Map<String, Object> param);
}
