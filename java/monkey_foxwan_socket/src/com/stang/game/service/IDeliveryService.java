package com.stang.game.service;

import java.util.List;
import java.util.Map;

import com.stang.game.entity.detail.DeliveryDetail;

public interface IDeliveryService  extends IBaseService<DeliveryDetail>{
	public List<DeliveryDetail> findAllDelivery();
	public List<DeliveryDetail> findDeliveryByopenid(String openid);
	
	public boolean updateDelivery(Map<String, Object> param);
	
	public List<DeliveryDetail> findeDeliveryByList(Map<String, Object> param);
}
