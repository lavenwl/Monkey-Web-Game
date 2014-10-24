package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameMLevelDetail;

public interface IGameMLevelService extends IBaseService<GameMLevelDetail> {


	public List<GameMLevelDetail> getGameMLevel();
	public List<GameMLevelDetail> findAllMLevel(Map<String,Object> param);
	public List<GameMLevelDetail> findGameMLevelByid(int id);
	public boolean insertGameMLevel(GameMLevelDetail model);
	public boolean updateGameMLevel(Map<String, Object> param);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<GameMLevelDetail> getGameMLevelBylevel(int level);
	
	public List<GameMLevelDetail> getGameMLevelByAllexp(int allexp);
}
