package com.stang.game.dao;

import java.util.List;

import com.stang.game.entity.detail.GameBbuffDetail;
import com.stang.game.entity.detail.GameBuffDetail;

public interface IGameBbuffDao extends IEntityDao<GameBbuffDetail>{

	public List<GameBbuffDetail> getGameBbuff();
}
