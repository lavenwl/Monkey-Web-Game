package com.stang.game.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.stang.game.cache.GlobalDatat;
import com.stang.game.dao.IGameYellowVipDao;
import com.stang.game.dao.impl.GameYellowVipDaoImpl;
import com.stang.game.entity.detail.GameYellowVipDetail;
import com.stang.game.service.IGameYellowVipService;

public class GameYellowVipServiceImpl extends BaseServiceImpl<GameYellowVipDetail> implements IGameYellowVipService{
	

	
	protected IGameYellowVipDao getBaseDao(){
		if(baseDao==null){
			baseDao = new GameYellowVipDaoImpl();
		}
		return (IGameYellowVipDao) baseDao;
	}
	

	@Override
	public List<GameYellowVipDetail> findAllYellowVip() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllYellowVip();
	}


	@Override
	public List<GameYellowVipDetail> findYellowVipById(int id) {
		// TODO Auto-generated method stub
		 List<GameYellowVipDetail> li=new ArrayList<GameYellowVipDetail>();
		 li.add(GlobalDatat.cacheGameYellowVipDetails.get(id));
		return li;
	}}
