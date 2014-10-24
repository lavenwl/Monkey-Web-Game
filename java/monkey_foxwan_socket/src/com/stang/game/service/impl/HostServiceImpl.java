package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheHost;
import com.stang.game.dao.IHostDao;
import com.stang.game.dao.impl.HostDaoImpl;
import com.stang.game.entity.detail.HostDetail;
import com.stang.game.service.IHostService;

public class HostServiceImpl extends BaseServiceImpl<HostDetail> implements IHostService{
	private static CacheHost ch0;
	private CacheHost ch(){
		if(ch0==null){
			ch0=new CacheHost();
		}
		return ch0;
	}
	protected IHostDao getBaseDao(){
		if(baseDao == null){
			baseDao = new HostDaoImpl();
		}
		return (IHostDao) baseDao;
	}

	@Override
	public List<HostDetail> findHostByParam(Map<String, Object> param) {
		//return getBaseDao().findHostByParam(param);
		return ch().findHostByParam(param);
	}

	@Override
	public List<HostDetail> findHostById(int id) {
		//return getBaseDao().findHostById(id);
		return ch().findHostById(id);
	}

	@Override
	public List<HostDetail> findAllHost() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllHost();
	}
}
