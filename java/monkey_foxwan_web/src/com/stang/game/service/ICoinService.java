package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.CoinDetail;

public interface ICoinService extends IBaseService<CoinDetail>{

	public boolean insertCoin(Map<String,Object> param);
	public List<CoinDetail> getBuycoin(int roleid);
	public List<CoinDetail> getAllBuycoin();
	public List<CoinDetail> findAllcoin(Map<String,Object> param);
	public List<CoinDetail> findcoinbytime(Map<String,Object> param);
	public List<CoinDetail> findcoinbytimeandopenid(Map<String,Object> param);
}
