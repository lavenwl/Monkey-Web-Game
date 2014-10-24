package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameMLevelDetail;

public interface IGameMLevelService extends IBaseService<GameMLevelDetail> {
	public List<GameMLevelDetail> getGameMLevel();
	
	public List<GameMLevelDetail> getGameMLevelBylevel(int level);
	
	public List<GameMLevelDetail> getGameMLevelByAllexp(int allexp);
}
