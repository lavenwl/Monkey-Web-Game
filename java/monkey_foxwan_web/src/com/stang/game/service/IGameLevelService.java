package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameLevelDetail;

public interface IGameLevelService extends IBaseService<GameLevelDetail> {
	public List<GameLevelDetail> getGameLevel();
	public List<GameLevelDetail> findAllLevel(Map<String,Object> param);
	public List<GameLevelDetail> findGameLevelByid(int id);
	public boolean insertGameLevel(GameLevelDetail model);
	public boolean updateGameLevel(Map<String, Object> param);
	
	
	
	
	
	public List<GameLevelDetail> allGameLevelDetail();

	public GameLevelDetail getGameLevelByRoleLevel(int roleLevel);
}
