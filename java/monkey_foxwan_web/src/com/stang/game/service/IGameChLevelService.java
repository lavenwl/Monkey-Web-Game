package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameChLevelDetail;

public interface IGameChLevelService extends IBaseService<GameChLevelDetail> {

	public List<GameChLevelDetail> getGameChlevel();
	public List<GameChLevelDetail> findAllChlevel(Map<String,Object> param);
	public List<GameChLevelDetail> findGameChlevelByid(int id);
	public boolean insertGameCHLevel(GameChLevelDetail model);
	public boolean updateGameGameCHLevel(Map<String, Object> param);
}
