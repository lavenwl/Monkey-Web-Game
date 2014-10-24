package com.stang.game.service;

import java.util.List;

import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBuffDetail;

public interface IGameBbuffService extends IBaseService<GameBbuffDetail>{

	public List<GameBbuffDetail> getGameBbuff();
}
