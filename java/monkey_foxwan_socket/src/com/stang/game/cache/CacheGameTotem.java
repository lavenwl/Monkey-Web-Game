package com.stang.game.cache;

import com.stang.game.entity.Gametotem;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameTotem {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GametotemDetail>  gameTotems = null;
	//静态初始化方法
	public CacheGameTotem(){
		if(gameTotems == null)
			gameTotems = GlobalDatat.cacheGametotemDetails;
	}
	public List<GametotemDetail> getGametotembyid(int id) {
		// TODO Auto-generated method stub
		List<GametotemDetail> gametotemDetailList = new ArrayList<GametotemDetail>();
		gametotemDetailList.add(gameTotems.get(id));
		return gametotemDetailList;
	}
	public List<GametotemDetail> getGametotembyparam(Map<String, Object> param) {
		List<GametotemDetail> gametotemDetailList = new ArrayList<GametotemDetail>();
		Object type = param.get("type");
		Object level = param.get("level");
		
		Iterator it = gameTotems.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GametotemDetail gametotemDetail = gameTotems.get(i);
			if(gametotemDetail.getType() == (Integer.valueOf(String.valueOf(type)))
			&& gametotemDetail.getLevel() == (Integer.valueOf(String.valueOf(level)))){
				gametotemDetailList.add(gametotemDetail);
			}
		}
		return gametotemDetailList;
	}

	
}
