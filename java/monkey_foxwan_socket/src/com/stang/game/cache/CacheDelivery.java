package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheDelivery {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<String, DeliveryDetail> deliverys = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache deliveryQueue = null;
	//静态类同步数据库线程
	public static ThreadCache thread = null;
	//静态初始化方法
	public CacheDelivery(){
		if(thread == null){
			thread = new ThreadCache("delivery");
			thread.start();
		}
		if(deliverys == null)
			deliverys = GlobalDatat.cacheDeliveryDetails;
		if(deliveryQueue == null)
			deliveryQueue = new QueueCache("delivery");
	}
	public List<DeliveryDetail> findDeliveryByopenid(String openid) {
		List<DeliveryDetail> deliveryList = new ArrayList<DeliveryDetail>();
		
		Iterator it = deliverys.keySet().iterator();
		while(it.hasNext()){
			String i = it.next().toString();
			DeliveryDetail md = deliverys.get(i);
			if(md.getOpenid()==openid){
				deliveryList.add(md);
				break;
			}
		}
		return deliveryList;
	}
	public boolean updateDelivery(Map<String, Object> param) {
		boolean b = false;
		int status=Integer.valueOf(String.valueOf(param.get("status")));
		String openid=String.valueOf(param.get("openid"));
		Object token = String.valueOf(param.get("token"));
		Object payitem =String.valueOf(param.get("isused"));
		DeliveryDetail deliveryDetail = new DeliveryDetail();
		try{
			deliveryDetail=(DeliveryDetail)deliverys.get(openid).clone();
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			deliveryDetail.setStatus(status);
			if(null!=token){
				deliveryDetail.setToken(String.valueOf(param.get("token")));
			}
			if(null!=payitem){
				deliveryDetail.setPayitem(String.valueOf(param.get("isused")));
			}
			//deliverys.remove(openid);
			deliverys.put(openid, deliveryDetail);
			deliveryDetail.setIsUpdate(1);
			deliveryQueue.enqueue(deliveryDetail);
			b = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	public List<DeliveryDetail> findeDeliveryByList(Map<String, Object> param) {
		List<DeliveryDetail> deliveryList = new ArrayList<DeliveryDetail>();
		Object openid = param.get("openid");
		Object serverid = param.get("serverid");
		Iterator it = deliverys.keySet().iterator();
		while(it.hasNext()){
			String i = it.next().toString();
			DeliveryDetail delivery = deliverys.get(i);
			if(delivery.getOpenid().equals (null == openid ? delivery.getOpenid()+"d" : String.valueOf(openid))){
				if(delivery.getZoneid().equals((null == serverid ? delivery.getZoneid() : String.valueOf(serverid)))){
					deliveryList.add(delivery);
				}
				
			}
		}
		return deliveryList;
	}
	
}
