package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheCoin;
import com.stang.game.dao.ICoinDao;
import com.stang.game.dao.impl.CoinDaoImpl;
import com.stang.game.entity.detail.CoinDetail;
import com.stang.game.service.ICoinService;

public class CoinServiceImpl extends BaseServiceImpl<CoinDetail> implements ICoinService{
    private static CacheCoin cc=new CacheCoin();
    private static CacheCoin getCacheCoin(){
    	if(cc == null){
    		cc = new CacheCoin();
    	}
    	return cc;
    }
	protected ICoinDao getBaseDao(){
		if(baseDao == null){
			baseDao = new CoinDaoImpl();
		}
		return (ICoinDao) baseDao;
	}
	
	@Override
	public boolean insertCoin(Map<String, Object> param) {
		return getBaseDao().insertCoin(param);
		//return this.getCacheCoin().insertCoin(param);
	}

	@Override
	public List<CoinDetail> findAllCoin() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllCoin();
	}

}
