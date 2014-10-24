package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.GamePriceDetail;

public interface IGamePriceService extends IBaseService<GamePriceDetail> {
	public List<GamePriceDetail> getAllGamePrice();

	public List<GamePriceDetail> getGamePriceById(int resId);
	
	public List<GamePriceDetail> getGamePrice(Map<String,Object>param);
}
