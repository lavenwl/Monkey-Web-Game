package com.stang.game.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.cache.GlobalDatat;
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
	
	
	

	@Override
	public List<ShopdiscountDetail> getShopdiscount(Map<String, Object> param) {
		// TODO Auto-generated method stub
		//return getBaseDao().getShopdiscount(param);
	//	System.out.println(GlobalDatat.cacheShopdiscountDetails.size()+":::::::::GlobalDatat.cacheShopdiscountDetails");
		List<ShopdiscountDetail> li=new ArrayList<ShopdiscountDetail>();
		li.add(GlobalDatat.cacheShopdiscountDetails.get(1));
		return li;
	}


	@Override
	public List<ShopdiscountDetail> getShopdiscounttwo(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().getShopdiscount(param);
	}

	

}
