package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;
import com.stang.game.cache.CacheCallGift;
import com.stang.game.dao.ICallgiftDao;
import com.stang.game.dao.IGameBingDao;
import com.stang.game.dao.impl.CallgiftDaoImpl;
import com.stang.game.dao.impl.GameBingDaoImpl;
import com.stang.game.entity.detail.CallGiftDetail;
import com.stang.game.service.ICallgiftService;

public class CallgiftServiceImpl extends BaseServiceImpl<CallGiftDetail> implements ICallgiftService{
	
	private static CacheCallGift cacheCallGift = null;
	private static CacheCallGift getCacheCallGift(){
		if(cacheCallGift == null){
			cacheCallGift = new CacheCallGift();
		}
		return cacheCallGift;
	}
	
	protected ICallgiftDao getBaseDao(){
		if(baseDao==null){
			baseDao = new CallgiftDaoImpl();
		}
		return (ICallgiftDao) baseDao;
	}
	@Override
	public List<CallGiftDetail> getcallgift(int id) {
		return getCacheCallGift().getcallgift(id);
//		return getBaseDao().getcallgift(id);
	}
	@Override
	public List<CallGiftDetail> findAllCallGift() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllCallGift();
	}}
