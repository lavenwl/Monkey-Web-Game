package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.CoinDetail;

public interface ICoinDao extends IEntityDao<CoinDetail>{
	public List<CoinDetail> findAllCoin();
	public boolean insertCoin(CoinDetail CoinDetail);
	public boolean insertCoin(Map<String,Object> param);
}
