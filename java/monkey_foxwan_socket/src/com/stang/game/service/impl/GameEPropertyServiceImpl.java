package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGameEProperty;
import com.stang.game.dao.IGameEPropertyDao;
import com.stang.game.dao.impl.GameEPropertyDaoImpl;
import com.stang.game.entity.detail.GameEPropertyDetail;
import com.stang.game.service.IGameEPropertyService;

public class GameEPropertyServiceImpl extends BaseServiceImpl<GameEPropertyDetail>
    implements IGameEPropertyService {
	CacheGameEProperty c0;
	private CacheGameEProperty c(){
		if(c0==null){
			c0=new CacheGameEProperty();
		}
		return c0;
		
	}
	protected IGameEPropertyDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GameEPropertyDaoImpl();
		}
		return (IGameEPropertyDao)baseDao;
	}

	
	
	@Override
	public List<GameEPropertyDetail> getGameEPropertyById(int id) {
		return c().getGameEPropertyById(id);
		//return getBaseDao().getGameEPropertyById(id);
	}



	@Override
	public List<GameEPropertyDetail> getGameEProperty() {
		return getBaseDao().getGameEProperty();
	}



	@Override
	public List<GameEPropertyDetail> getGameEPropertyBytypequality(
			Map<String, Object> param) {
		return c().getGameEPropertyBytypequality(param);
		//return getBaseDao().getGameEPropertyBytypequality(param);
	}

}
