package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GameYellowVipDetail;


public interface IGameYellowVipService extends IBaseService<GameYellowVipDetail>{
	public List<GameYellowVipDetail> findAllYellowVip();
	public List<GameYellowVipDetail> findYellowVipById(int id);
}
