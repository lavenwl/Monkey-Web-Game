package com.stang.game.service.impl;

import java.util.List;
import java.util.Map;

import com.stang.game.cache.CacheDelivery;
import com.stang.game.dao.IDeliveryDao;
import com.stang.game.dao.impl.DeliveryDaoImpl;
import com.stang.game.entity.detail.DeliveryDetail;
import com.stang.game.entity.detail.GameRoleDetail;
import com.stang.game.service.IDeliveryService;


public class DeliveryServiceImpl extends BaseServiceImpl<DeliveryDetail>
		implements IDeliveryService {
      CacheDelivery cd0;
      protected CacheDelivery cd(){
    	 if(cd0==null){
    		 cd0=new CacheDelivery();
    	 }
    	 return cd0;
     }
	protected IDeliveryDao getBaseDao() {
		if (baseDao == null) {
			baseDao = new DeliveryDaoImpl();
		}
		return (IDeliveryDao) baseDao;
	}
	
	@Override
	public List<DeliveryDetail> findDeliveryByopenid(String openid) {
		return getBaseDao().findDeliveryByopenid(openid);
		//return cd().findDeliveryByopenid(openid);
	}

	@Override
	public boolean updateDelivery(Map<String, Object> param) {
		return getBaseDao().updateDelivery(param);
		//return cd().updateDelivery(param);
	}

	@Override
	public List<DeliveryDetail> findeDeliveryByList(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return getBaseDao().findeDeliveryByList(param);
		//return cd().findeDeliveryByList(param);
	}

	@Override
	public List<DeliveryDetail> findAllDelivery() {
		// TODO Auto-generated method stub
		return getBaseDao().findAllDelivery();
	}

}
