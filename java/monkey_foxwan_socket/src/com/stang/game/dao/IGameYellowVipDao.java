package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameYellowVipDetail;


public interface IGameYellowVipDao extends IEntityDao<GameYellowVipDetail>{

	public List<GameYellowVipDetail> findAllYellowVip();
}
