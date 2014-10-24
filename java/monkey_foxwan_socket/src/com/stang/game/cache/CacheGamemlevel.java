package com.stang.game.cache;

import com.stang.game.entity.GameEquip;
import com.stang.game.entity.detail.*;

import java.util.*;
/**
 * 具体对象的缓存类
 * @author Laven Wang
 *
 */
public class CacheGamemlevel {
	//缓存类操作的缓存对象(key:id, value:ActivityDetail)
	private static Map<Integer, GameMLevelDetail>  gamemlevels = null;
	//静态初始化方法
	public CacheGamemlevel(){
		if(gamemlevels == null)
			gamemlevels = GlobalDatat.cacheGameMLevelDetails;
	}
	public List<GameMLevelDetail> getGameMLevelBylevel(int level) {
		List<GameMLevelDetail> gameMLevelDetailList = new ArrayList<GameMLevelDetail>();
		Iterator it = gamemlevels.keySet().iterator();
		while(it.hasNext()){
			Integer i = Integer.valueOf(it.next().toString());
			GameMLevelDetail gameMLevelDetail = gamemlevels.get(i);
			if(gameMLevelDetail.getLevel()==level){
				gameMLevelDetailList.add(gameMLevelDetail);
			}
		}
		return gameMLevelDetailList;
	}


}
