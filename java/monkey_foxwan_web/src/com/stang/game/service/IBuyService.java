package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.BuyDetail;

public interface IBuyService extends IBaseService<BuyDetail>{
	public List<BuyDetail> getBuy(String openid);
	public List<BuyDetail> getAllBuy();
	public List<BuyDetail> findAll(Map<String,Object> param);

	public List<BuyDetail> findbytime(Map<String,Object> param);
	public List<BuyDetail> findbytimeandopenid(Map<String,Object> param);
}
