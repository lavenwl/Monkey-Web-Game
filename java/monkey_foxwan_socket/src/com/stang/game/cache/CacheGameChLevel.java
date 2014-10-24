package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameChLevel {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameChLevelDetail>  gameChLevels = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameChLevelQueue = null;
	//静态初始化方法
	public CacheGameChLevel(){
		if(gameChLevels == null)
			gameChLevels = GlobalDatat.cacheGameChLevelDetails;
		if(gameChLevelQueue == null)
			gameChLevelQueue = new QueueCache();
	}
	public List<GameChLevelDetail> findGameChLevelByparas(Map<String, Object> param) {
		//System.out.println("CacheGamechLevel:param:" + param.toString());
		List<GameChLevelDetail> gameChLevelDetailList = new ArrayList<GameChLevelDetail>();
		Object type = param.get("type");
		Object level = param.get("level");
		Iterator it = gameChLevels.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameChLevelDetail gameChLevelDetail = gameChLevels.get(i);
			if(gameChLevelDetail.getType() == (null == type ? gameChLevelDetail.getType() : Integer.valueOf(String.valueOf(type)))
			&& gameChLevelDetail.getLevel() == (null == level ? gameChLevelDetail.getLevel() : Integer.valueOf(String.valueOf(level)))){
				gameChLevelDetailList.add(gameChLevelDetail);
			}
		}
		return gameChLevelDetailList;
	}
	
	
}
