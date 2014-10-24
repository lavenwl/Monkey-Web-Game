package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBskillDetail;

public interface IGameBskillDao extends IEntityDao<GameBskillDetail>{
	public List<GameBskillDetail> getGameBskill();
	public List<GameBskillDetail> findAllBskill(Map<String,Object> param);
	public List<GameBskillDetail> findGameBskillByid(int id);
	public boolean insertGameBskill(GameBskillDetail model);
	public boolean updateGameBskill(Map<String, Object> param);
}
