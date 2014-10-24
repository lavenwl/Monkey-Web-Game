package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameChLevelDetail;

public interface IGameChLevelService extends IBaseService<GameChLevelDetail> {
	public List<GameChLevelDetail> getGameChLevel();
	
	public List<GameChLevelDetail> findGameChLevelByparas(Map<String, Object> param);//查询功勋
}
