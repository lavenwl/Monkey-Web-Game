package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGamePrice {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GamePriceDetail>  gamePrices = null;
	//静态初始化方法
	public CacheGamePrice(){
		if(gamePrices == null)
			gamePrices = GlobalDatat.cacheGamePriceDetails;
	}
	public List<GamePriceDetail> getGamePriceById(int resId) {
		List<GamePriceDetail> gamePriceDetailList = new ArrayList<GamePriceDetail>();
		Iterator it = gamePrices.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GamePriceDetail gamePriceDetail = gamePrices.get(i);
			if(gamePriceDetail.getResId() == (Integer.valueOf(String.valueOf(resId)))){
				gamePriceDetailList.add(gamePriceDetail);
				break;
			}
		}
		return gamePriceDetailList;
	}
	public List<GamePriceDetail> getGamePrice(Map<String, Object> param) {
		List<GamePriceDetail> gamePriceDetailList = new ArrayList<GamePriceDetail>();
		Object resId = param.get("resId");
		Object resType = param.get("resType");
		Object costType = param.get("costType");
		
		Iterator it = gamePrices.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GamePriceDetail gamePriceDetail = gamePrices.get(i);
			if(gamePriceDetail.getResId() == (null == resId ? gamePriceDetail.getResId() : Integer.valueOf(String.valueOf(resId)))
			&& gamePriceDetail.getResType() == (null == resType ? gamePriceDetail.getResType() : Integer.valueOf(String.valueOf(resType)))
			&& gamePriceDetail.getCostType() == (null == costType ? gamePriceDetail.getCostType() : Integer.valueOf(String.valueOf(costType)))){
				gamePriceDetailList.add(gamePriceDetail);
			}
		}
		return gamePriceDetailList;
	}

	
}
