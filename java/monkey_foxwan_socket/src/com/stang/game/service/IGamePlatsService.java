package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GamePlatsDetail;

public interface IGamePlatsService extends IBaseService<GamePlatsDetail> {
	public List<GamePlatsDetail> getGamePlats();
	
	public List<GamePlatsDetail> findGamePlatByparams(Map<String, Object> param);//获得随机道具
}
