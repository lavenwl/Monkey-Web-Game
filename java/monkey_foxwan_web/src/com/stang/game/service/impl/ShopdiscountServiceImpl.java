package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.dao.IShopdiscountDao;
import com.stang.game.dao.impl.ShopdiscountDaoImpl;
import com.stang.game.entity.detail.ShopdiscountDetail;
import com.stang.game.service.IShopdiscountService;

public class ShopdiscountServiceImpl extends BaseServiceImpl<ShopdiscountDetail> implements IShopdiscountService{
	protected IShopdiscountDao getBaseDao(){
		if(baseDao==null){
			baseDao = new ShopdiscountDaoImpl();
		}
		return (IShopdiscountDao) baseDao;
	}

	public List<ShopdiscountDetail> getShopdiscount(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getShopdiscount(param);
	}

	public boolean updateShop(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().updateShop(param);
	}

	

}
