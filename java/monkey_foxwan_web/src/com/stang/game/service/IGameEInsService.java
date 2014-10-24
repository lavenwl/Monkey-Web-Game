package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameEInsDetail;
import com.stang.game.entity.detail.GameEPropertyDetail;


public interface IGameEInsService  extends IBaseService<GameEInsDetail> {
	
    public List<GameEInsDetail> getGameEIns();
	
	public List<GameEInsDetail> getGameEInsById(int id);

}
