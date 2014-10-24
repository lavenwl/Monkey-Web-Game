package com.stang.game.cache;

import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameEIns {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameEInsDetail>  gameEInss = null;
	//静态初始化方法
	public CacheGameEIns(){
		if(gameEInss == null)
			gameEInss = GlobalDatat.cacheGameEInsDetails;
	}
	
	public List<GameEInsDetail> getGameEInsById(int id) {
		List<GameEInsDetail> gameEInsDetailList = new ArrayList<GameEInsDetail>();
		
				gameEInsDetailList.add(gameEInss.get(id));
			
		
		return gameEInsDetailList;
	}
	
}
