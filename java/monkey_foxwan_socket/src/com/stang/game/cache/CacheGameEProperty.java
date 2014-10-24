package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameEProperty {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameEPropertyDetail>  gameEPropertys = null;
	//静态初始化方法
	public CacheGameEProperty(){
		if(gameEPropertys == null)
			gameEPropertys = GlobalDatat.cacheGameEPropertyDetails;
	}
	public List<GameEPropertyDetail> getGameEPropertyById(int id) {
		List<GameEPropertyDetail> gameEPropertyList = new ArrayList<GameEPropertyDetail>();
		
		gameEPropertyList.add(gameEPropertys.get(id));
	

return gameEPropertyList;
}
	public List<GameEPropertyDetail> getGameEPropertyBytypequality(
			Map<String, Object> param) {
		List<GameEPropertyDetail> gameEPropertyDetailList = new ArrayList<GameEPropertyDetail>();
		Object type = param.get("type");
		Object quality = param.get("quality");
		
		Iterator it = gameEPropertys.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameEPropertyDetail gameEPropertyDetail = gameEPropertys.get(i);
			if(gameEPropertyDetail.getType()==(Integer.valueOf(String.valueOf(type)))
					&&gameEPropertyDetail.getQuality()==(Integer.valueOf(String.valueOf(quality)))){
				gameEPropertyDetailList.add(gameEPropertyDetail);
			}
		}
		return gameEPropertyDetailList;
	}

	
}
