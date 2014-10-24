package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameMLevelDetail;

public interface IGameMLevelDao extends IEntityDao<GameMLevelDetail> {
	public List<GameMLevelDetail> getGameMLevel();
	
	public List<GameMLevelDetail> getGameMLevelBylevel(int level);
	
	public List<GameMLevelDetail> getGameMLevelByAllexp(int allexp);
}
