package com.stang.game.dao;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.DeliveryDetail;

public interface IDeliveryDao extends IEntityDao<DeliveryDetail>{

	public List<DeliveryDetail> findDeliveryByopenid(String openid);
	
	public boolean updateDelivery(Map<String, Object> param);
	
	public List<DeliveryDetail> findeDeliveryByList(Map<String, Object> param);
	public List<DeliveryDetail> findAllDelivery();
	
	public boolean updateDelivery(DeliveryDetail model);
	public boolean insertDelivery(DeliveryDetail model);
}
