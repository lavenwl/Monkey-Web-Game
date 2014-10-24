package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameVip {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameVipDetail>  gameVips = null;
	//静态初始化方法
	public CacheGameVip(){
		if(gameVips == null)
			gameVips = GlobalDatat.cacheGameVipDetails;
	}
	public List<GameVipDetail> getGameVipByLe(int level) {
		List<GameVipDetail> gameVipDetailList = new ArrayList<GameVipDetail>();
		Iterator it = gameVips.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameVipDetail gameVipDetail = gameVips.get(i);
			if(gameVipDetail.getVipLevel()==level){
				gameVipDetailList.add(gameVipDetail);
			}
		}
		return gameVipDetailList;
	}
	
	
}
