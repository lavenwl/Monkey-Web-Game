package com.stang.game.ffd.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.ffd.dao.IOrderInfoDao;
import com.stang.game.ffd.dao.impl.OrderInfoDaoImpl;
import com.stang.game.ffd.entity.detail.EntityOrderInfoDetail;
import com.stang.game.ffd.service.IOrderInfoService;

public class OrderInfoServiceImpl extends BaseServiceImpl<EntityOrderInfoDetail> implements IOrderInfoService {
	
	public IOrderInfoDao getBasedao(){
		if(this.baseDao==null){
			this.baseDao = new OrderInfoDaoImpl();
		}return (IOrderInfoDao)baseDao;
	}
	
	public List<EntityOrderInfoDetail> getAllInfoOrderInfo(Map<String, Object> parm) {
		// TODO Auto-generated method stub
		return this.getBasedao().getAllInfoOrderInfo(parm);
	}



}
