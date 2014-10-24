package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameBuffDetail;

public interface IGameBuffService extends IBaseService<GameBuffDetail>{
	public List<GameBuffDetail> getGameBuff();
	public List<GameBuffDetail> findAllBuff(Map<String,Object> param);
	public List<GameBuffDetail> findGameBuffByid(int id);
	public boolean insertGameBuff(GameBuffDetail model);
	public boolean updateGameBuff(Map<String, Object> param);
}
