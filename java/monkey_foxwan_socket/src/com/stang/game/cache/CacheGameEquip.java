package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameEquip {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameEquipDetail>  gameEquips = null;
	//静态初始化方法
	public CacheGameEquip(){
		if(gameEquips == null)
			gameEquips = GlobalDatat.cacheGameEquipDetails;
	}
	public List<GameEquipDetail> getGameEquipById(int id) {
		List<GameEquipDetail> gameEquipDetailList = new ArrayList<GameEquipDetail>();
		
		gameEquipDetailList.add(gameEquips.get(id));
		
		return gameEquipDetailList;
	}
	
}
