package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGameTotem;
import com.stang.game.dao.IGameItemDao;
import com.stang.game.dao.IGametotemDao;
import com.stang.game.dao.impl.GametotemDaoImpl;
import com.stang.game.entity.detail.GametotemDetail;
import com.stang.game.service.IGametotemService;


public class GametotemServiceImpl extends BaseServiceImpl<GametotemDetail>
		implements IGametotemService {
	 CacheGameTotem c0;
	 private CacheGameTotem c(){
		 if(c0==null){
			 c0=new CacheGameTotem();
		 }
		return c0;
	 }
	 
	protected IGametotemDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GametotemDaoImpl();
		}
		return (IGametotemDao) baseDao;
	}

	@Override
	public List<GametotemDetail> getGametotem() {
		// TODO Auto-generated method stub
		return getBaseDao().getGametotem();
	}

	@Override
	public List<GametotemDetail> getGametotembyid(int id) {
		// TODO Auto-generated method stub
		return c().getGametotembyid(id);

		//return getBaseDao().getGametotembyid(id);
	}

	@Override
	public List<GametotemDetail> getGametotembyparam(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return c().getGametotembyparam(param);
		//return getBaseDao().getGametotembyparam(param);
	}}
