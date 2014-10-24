package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.CoinDetail;

public interface ICoinService extends IBaseService<CoinDetail>{
	public List<CoinDetail> findAllCoin();
	public boolean insertCoin(Map<String,Object> param);
}
