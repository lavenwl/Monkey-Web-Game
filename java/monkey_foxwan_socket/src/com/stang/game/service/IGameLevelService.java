package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameLevelDetail;

public interface IGameLevelService extends IBaseService<GameLevelDetail> {
	
	public List<GameLevelDetail> findAllGameLevel();
	
	public GameLevelDetail getGameLevelDetail(Map param);

	public List<GameLevelDetail> allGameLevelDetail();

	public GameLevelDetail getGameLevelByRoleLevel(Integer roleLevel);
	
	public List<GameLevelDetail> getGaemLevelByParams(Map<String,Object> param);

}
