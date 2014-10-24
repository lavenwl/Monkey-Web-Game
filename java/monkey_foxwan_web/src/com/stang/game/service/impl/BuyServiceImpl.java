package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.common.Response;
import com.stang.game.dao.IBuyDao;
import com.stang.game.dao.impl.BuyDaoImpl;
import com.stang.game.entity.detail.BuyDetail;
import com.stang.game.service.IBuyService;

public class BuyServiceImpl extends BaseServiceImpl<BuyDetail>
implements IBuyService{
	protected IBuyDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new BuyDaoImpl();
		}
		return (IBuyDao) baseDao;
	}

	public List<BuyDetail> getBuy(String openid) {
		// TODO Auto-generated method stub
		return getBaseDao().getBuy(openid);
	}

	public List<BuyDetail> getAllBuy() {
		// TODO Auto-generated method stub
		return getBaseDao().getAllBuy();
	}

	public List<BuyDetail> findAll(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findAll(param);
	}

	public List<BuyDetail> findbytime(Map<String,Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findbytime(param);
	}

	public List<BuyDetail> findbytimeandopenid(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findbytimeandopenid(param);
	}

	
}
