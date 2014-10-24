package com.stang.game.service.impl;

import java.util.List;

import com.stang.game.cache.CacheCdkStore;
import com.stang.game.dao.ICdkStoreDao;
import com.stang.game.dao.impl.CdkStoreDaoImpl;
import com.stang.game.entity.detail.CdkStoreDetail;
import com.stang.game.service.ICdkStoreService;

public class CdkStoreServiceImpl extends BaseServiceImpl<CdkStoreDetail> implements ICdkStoreService{

	private static CacheCdkStore cc=new CacheCdkStore();
    private static CacheCdkStore getCacheCdkStore(){
    	if(cc == null){
    		cc = new CacheCdkStore();
    	}
    	return cc;
    }
	protected ICdkStoreDao getBaseDao(){
		if(baseDao == null){
			baseDao = new CdkStoreDaoImpl();
		}
		return (ICdkStoreDao) baseDao;
	}
	@Override
	public boolean Updatemploy(String employ, String cdk) {
		// TODO Auto-generated method stub
		return getBaseDao().Updatemploy(employ, cdk);
	}

	@Override
	public List<CdkStoreDetail> findCdkStoreBycdk(String cdk) {
		return getBaseDao().findCdkStoreBycdk(cdk);
	}
}
