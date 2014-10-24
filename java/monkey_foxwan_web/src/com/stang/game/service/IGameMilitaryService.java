package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameMilitaryDetail;

public interface IGameMilitaryService extends IBaseService<GameMilitaryDetail> {
	public List<GameMilitaryDetail> getGameMilitary();
	public List<GameMilitaryDetail> findAllMilitary(Map<String,Object> param);
	public List<GameMilitaryDetail> findGameMilitaryByid(int id);
	public boolean insertGameMilitary(GameMilitaryDetail model);
	public boolean updateGameMilitary(Map<String, Object> param);
}
