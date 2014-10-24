package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameChLevelDetail;
import com.stang.game.entity.detail.RoleMilitaryDetail;

public interface IGameChLevelDao extends IEntityDao<GameChLevelDetail> {
	public List<GameChLevelDetail> getGameChLevel();
	
	public List<GameChLevelDetail> findGameChLevelByparas(Map<String, Object> param);//查询功勋
}
