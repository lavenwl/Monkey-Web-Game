package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameMission {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameMissionDetail>  gameMissions = null;
	//静态初始化方法
	public CacheGameMission(){
		if(gameMissions == null)
			gameMissions = GlobalDatat.cacheGameMissionDetails;
	}
	public List<GameMissionDetail> findGameMissionById(int id) {
		// TODO Auto-generated method stub
		List<GameMissionDetail> gameMissionDetailList=new ArrayList<GameMissionDetail>();
		gameMissionDetailList.add(gameMissions.get(id));
		return gameMissionDetailList;
	}


}
