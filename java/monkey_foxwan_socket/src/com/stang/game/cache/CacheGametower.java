package com.stang.game.cache;

import com.stang.game.entity.GameTower;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGametower {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameTowerDetail>  gameTowers = null;
	//静态初始化方法
	public CacheGametower(){
		if(gameTowers == null)
			gameTowers = GlobalDatat.cacheGameTowerDetails;
	}
	public List<GameTowerDetail> getGameTowerLevel(int towerid) {
		// TODO Auto-generated method stub
		List<GameTowerDetail> gameTowerDetailList=new ArrayList<GameTowerDetail>();
		gameTowerDetailList.add(gameTowers.get(towerid));
		return gameTowerDetailList;
	}

}
