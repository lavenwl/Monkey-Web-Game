package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameBuffDetail;
import com.stang.game.entity.detail.GameBuffDetail;

public interface IGameBuffService extends IBaseService<GameBuffDetail>{
	public List<GameBuffDetail> getGameBuff();
	
	public List<GameBuffDetail> getGameBuffById(int id);
}
