package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GamePriceDetail;

public interface IGamePriceDao extends IEntityDao<GamePriceDetail> {
	public List<GamePriceDetail> getAllGamePrice();

	public List<GamePriceDetail> getGamePriceById(int resId);
	
	public List<GamePriceDetail> getGamePrice(Map<String,Object>param);
}
