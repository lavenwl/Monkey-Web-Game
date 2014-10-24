package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGamePlat {
	//缓存类操作的缓存对象(key:index, value:ActivityDetail)
	private static Map<Integer, GamePlatsDetail>  gamePlats = null;
	//静态初始化方法
	public CacheGamePlat(){
		if(gamePlats == null)
			gamePlats = GlobalDatat.cacheGamePlatsDetails;
	}
	public List<GamePlatsDetail> findGamePlatByparams(Map<String, Object> param) {
		//System.out.println("CacheGamePlat:.findGamePlatByParams:" + param.toString());
		List<GamePlatsDetail> gamePlatsDetailList = new ArrayList<GamePlatsDetail>();
		Object id = param.get("id");
		Object mid = param.get("mid");
		Iterator it = gamePlats.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GamePlatsDetail gamePlatsDetail = gamePlats.get(i);
			if(gamePlatsDetail.getId() == (null == id ? gamePlatsDetail.getId() : Integer.valueOf(String.valueOf(id)))
			&& gamePlatsDetail.getMid() == (null == mid ? gamePlatsDetail.getMid() : Integer.valueOf(String.valueOf(mid)))){
				gamePlatsDetailList.add(gamePlatsDetail);
				}
		}
		return gamePlatsDetailList;
	}
	
}
