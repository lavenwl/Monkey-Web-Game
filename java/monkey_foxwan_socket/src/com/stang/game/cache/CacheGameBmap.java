package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameBmap {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameBmapDetail>  gameBmaps = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameBmapQueue = null;
	//静态初始化方法
	public CacheGameBmap(){
		if(gameBmaps == null)
			gameBmaps = GlobalDatat.cacheGameBmapDetails;
		if(gameBmapQueue == null)
			gameBmapQueue = new QueueCache("gameBmap");
	}
	public List<GameBmapDetail> findGameBmapByParams(Map<String, Object> param) {
		List<GameBmapDetail> gameBmapDetailList = new ArrayList<GameBmapDetail>();
		Object mapid = param.get("mapid");
		Object nandu = param.get("nandu");
		
		Iterator it = gameBmaps.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameBmapDetail gameBmapDetail = gameBmaps.get(i);
			if(gameBmapDetail.getMapid() == (null == mapid ? gameBmapDetail.getMapid() : Integer.valueOf(String.valueOf(mapid)))
			&& gameBmapDetail.getNandu() == (null == nandu ? gameBmapDetail.getNandu() : Integer.valueOf(String.valueOf(nandu)))){
				gameBmapDetailList.add(gameBmapDetail);
			}
		}
		return gameBmapDetailList;
	}
	
}
