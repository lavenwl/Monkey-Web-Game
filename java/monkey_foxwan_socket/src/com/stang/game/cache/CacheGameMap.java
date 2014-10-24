package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameMap {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameMapDetail>  gameMaps = null;
	//静态初始化方法
	public CacheGameMap(){
		if(gameMaps == null)
			gameMaps = GlobalDatat.cacheGameMapDetails;
	}
	public List<GameMapDetail> findGameMapByid(int id) {
		// TODO Auto-generated method stub
		List<GameMapDetail> GameMapDetailList=new ArrayList<GameMapDetail>();
		GameMapDetailList.add(gameMaps.get(id));
		return GameMapDetailList;
	}


}
