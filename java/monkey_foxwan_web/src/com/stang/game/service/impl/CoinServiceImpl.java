package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.ICoinDao;
import com.stang.game.dao.impl.CoinDaoImpl;
import com.stang.game.entity.detail.CoinDetail;
import com.stang.game.service.ICoinService;

public class CoinServiceImpl extends BaseServiceImpl<CoinDetail> implements ICoinService{

	protected ICoinDao getBaseDao(){
		if(baseDao == null){
			baseDao = new CoinDaoImpl();
		}
		return (ICoinDao) baseDao;
	}
	
	public boolean insertCoin(Map<String, Object> param) {
		return getBaseDao().insertCoin(param);
	}

	public List<CoinDetail> findAllcoin(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAllcoin(param);
	}

	public List<CoinDetail> getAllBuycoin() {
		// TODO Auto-generated method stub
		return getBaseDao().getAllBuycoin();
	}

	public List<CoinDetail> getBuycoin(int roleid) {
		// TODO Auto-generated method stub
		return getBaseDao().getBuycoin(roleid);
	}

	public List<CoinDetail> findcoinbytime(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findcoinbytime(param);
	}

	public List<CoinDetail> findcoinbytimeandopenid(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findcoinbytimeandopenid(param);
	}

}
