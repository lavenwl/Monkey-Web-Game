package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameBing {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameBingDetail> gameBings = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameBingQueue = null;
	//静态初始化方法
	public CacheGameBing(){
		if(gameBings == null)
			gameBings = GlobalDatat.cacheGameBingDetails;
		if(gameBingQueue == null)
			gameBingQueue = new QueueCache("gameBing");
	}
	public List<GameBingDetail> getGameBingById(Map<String, Object> param) {
		List<GameBingDetail> gameBingDetailList = new ArrayList<GameBingDetail>();
		Object id = param.get("id");
		Object type = param.get("type");
		
		Iterator it = gameBings.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameBingDetail gameBingDetail = gameBings.get(i);
			if(gameBingDetail.getId() == (null == id ? gameBingDetail.getId() : Integer.valueOf(String.valueOf(id)))
			&& gameBingDetail.getType() == (null == type ? gameBingDetail.getType() : Integer.valueOf(String.valueOf(type)))){
				gameBingDetailList.add(gameBingDetail);
			}
		}
		return gameBingDetailList;
	}
	
}
