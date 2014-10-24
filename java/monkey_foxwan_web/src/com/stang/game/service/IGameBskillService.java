package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBskillDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public interface IGameBskillService extends IBaseService<GameBskillDetail>{
	public List<GameBskillDetail> getGameBskill();
	public List<GameBskillDetail> findAllBskill(Map<String,Object> param);
	public List<GameBskillDetail> findGameBskillByid(int id);
	public boolean insertGameBskill(GameBskillDetail model);
	public boolean updateGameBskill(Map<String, Object> param);
}
