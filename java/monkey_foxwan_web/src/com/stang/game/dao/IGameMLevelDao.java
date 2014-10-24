package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameMLevelDetail;
import com.stang.game.entity.detail.GameTaskDetail;

public interface IGameMLevelDao extends IEntityDao<GameMLevelDetail> {

	public List<GameMLevelDetail> getGameMLevelBylevel(int level);
	
	public List<GameMLevelDetail> getGameMLevelByAllexp(int allexp);
	
	
	
	
	
	
	
	public List<GameMLevelDetail> getGameMLevel();
	public List<GameMLevelDetail> findAllMLevel(Map<String,Object> param);
	public List<GameMLevelDetail> findGameMLevelByid(int id);
	public boolean insertGameMLevel(GameMLevelDetail model);
	public boolean updateGameMLevel(Map<String, Object> param);
}
