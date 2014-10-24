package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameBuff {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameBuffDetail>  gameBuffs = null;
	//变动过的对象组成的队列，由于自动同步数据库
	public static QueueCache gameBuffQueue = null;
	//静态初始化方法
	public CacheGameBuff(){
		if(gameBuffs == null)
			gameBuffs = GlobalDatat.cacheGameBuffDetails;
		if(gameBuffQueue == null)
			gameBuffQueue = new QueueCache();
	}
	public List<GameBuffDetail> getGameBuffId(int id) {
		List<GameBuffDetail> gameBuffDetailList = new ArrayList<GameBuffDetail>();
		
		gameBuffDetailList.add(gameBuffs.get(id));
		
		return gameBuffDetailList;
	}
	
}
