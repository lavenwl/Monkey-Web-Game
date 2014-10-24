package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.GameSkill;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGameStar {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameStarDetail>  gameStars = null;
	//静态初始化方法
	public CacheGameStar(){
		if(gameStars == null)
			gameStars = GlobalDatat.cacheGameStarDetails;
	}
	public List<GameStarDetail> getgamestars(int starlevel) {
		List<GameStarDetail> gameStarDetailList = new ArrayList<GameStarDetail>();
		Iterator it = gameStars.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameStarDetail gameStarDetail = gameStars.get(i);
			if(gameStarDetail.getStarlevel() == (Integer.valueOf(String.valueOf(starlevel)))){
				gameStarDetailList.add(gameStarDetail);
				break;
			}
		}
		return gameStarDetailList;
	}


}
