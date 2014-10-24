package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheGamBlingItem;
import com.stang.game.dao.IGamblingItemDao;
import com.stang.game.dao.impl.GamblingItemDaoImpl;
import com.stang.game.entity.detail.GamblingItemDetail;
import com.stang.game.entity.detail.RoleMapDetail;
import com.stang.game.service.IGamblingItemService;

public class GamblingItemServiceImpl extends
		BaseServiceImpl<GamblingItemDetail> implements IGamblingItemService {
        CacheGamBlingItem cg0;
        private CacheGamBlingItem cg(){
        	if(cg0==null){
        		cg0=new CacheGamBlingItem();
        	}
			return cg0;
        	
        }
	protected IGamblingItemDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new GamblingItemDaoImpl();
		}
		return (IGamblingItemDao) baseDao;
	}

	public List<GamblingItemDetail> getGamblingItem(Map<String, Object> param) {
		//return getBaseDao().getGamblingItem(param);
		return cg().getGamblingItem(param);
	}

	public void updateGamblingItemByParam(Map<String, Object> param) {
		//getBaseDao().updateGamblingItemByParam(param);
		cg().updateGamblingItemByParam(param);
	}

	@Override
	public List<GamblingItemDetail> getGamblingItemBytype(int type) {
		//return getBaseDao().getGamblingItemBytype(type);
		return cg().getGamblingItemBytype(type);
	}

	@Override
	public List<GamblingItemDetail> getGamblingItemBymid(int mid) {
		//return getBaseDao().getGamblingItemBymid(mid);
		return cg().getGamblingItemBymid(mid);
	}

	@Override
	public List<GamblingItemDetail> getGamblingItemByparam(Map<String, Object> param) {
		//return getBaseDao().getGamblingItemByparam(param);
		return cg().getGamblingItemByparam(param);
	}

	@Override
	public List<GamblingItemDetail> findAllGamblingItem() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllGamblingItem();
	}


}
